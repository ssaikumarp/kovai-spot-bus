package com.example.citybussearching;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;



import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VehicleTracking extends Activity {
	public Button b2,b3;
	public String login;
	public Spinner s1;
	public EditText e1;
	//public TextView tv1;
	private Handler handler = new Handler();
	public String s,result,result1;
	StringBuilder strAddress = new StringBuilder();
	LocationManager locationManager ;
	String provider;
	String lati,log;
	//AppLocationService appLocationService;
	Handler mHandler=null;
	
	
    //ArrayList dataModels;
   
    //private CustomAdapter adapter;
    String drivname;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vehicle_tracking);
		b2=(Button)findViewById(R.id.exit);
        b3=(Button)findViewById(R.id.loginbutton);
        s1=(Spinner)findViewById(R.id.spinner1);	       
        e1=(EditText)findViewById(R.id.editText1);

        //dataModels = new ArrayList();
        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
           StrictMode.setThreadPolicy(policy);
       }
       
        
        b2.setOnClickListener(new View.OnClickListener() 
      {
    	
         @Override	
      	  public void onClick(View arg)
      	   {
      	    	finish();
      	   	System.exit(0);
      	   }
  		});
        
  //get vehicle no
        
        String getsub=WebService.Viewveh("getsub","Viewbus");
        String[] str1=null;
        //Toast.makeText(StuHomenew.this, "Data Save successfully...", Toast.LENGTH_LONG).show();
        if (getsub.toString()!="") {
            str1 = getsub.split("#");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, str1);
            dataAdapter.setDropDownViewResource(R.layout.spinner_item);
           s1.setAdapter(dataAdapter);
        }




        
        
        
        //
        
        
      
	}
	
	

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            e1.setText(locationAddress);           
        }
    }
    
   /* 
public String getMyLocationAddress(double ll,double lon) {
		
	
		String address="";
		try {
        	  
			 Geocoder geocoder;
				List<Address> addresses;
				geocoder = new Geocoder(this, Locale.getDefault());
			
				addresses = geocoder.getFromLocation(lon, ll, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
			
				address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
				String city = addresses.get(0).getLocality();
				String state = addresses.get(0).getAdminArea();
				String country = addresses.get(0).getCountryName();
				String postalCode = addresses.get(0).getPostalCode();
				String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL
        		
        	  
        	  //DBWorker(strAddress.toString());
        	 
         
        } 
		catch (IOException e) {
        		 // TODO Auto-generated catch block
        		 e.printStackTrace();
        		 Toast.makeText(getApplicationContext(),"Could not get address..!", Toast.LENGTH_LONG).show();
		} 
	
	
		return address;
	}
	*/
    @SuppressLint("NewApi")
	public void getlocation(View v)
    {
    	 if (android.os.Build.VERSION.SDK_INT >= 9) {
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy);
			}
 	  login=WebService.getlocation(s1.getSelectedItem().toString(),"getlocation");
 	  if(!login.equals("not OK") & !login.equals(""))
 	  { 		 		 
 	    	e1.setText(login);
 	  }
 	  else
 	  {
 		  Toast.makeText(getApplication(),"No Data Found",Toast.LENGTH_SHORT).show();
 		  //e1.setText("No Data Found");
	    	
 	  }  
    }
    private String getAddressString(double latitude, double longitude) {
        String strAddress = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude,
                    longitude, 1);
           
            if (addresses != null) {
            	// Toast.makeText(getApplication(), addresses.toString(), Toast.LENGTH_SHORT).show();
            	// e1.setText(addresses.toString());
                Address returnAddress = addresses.get(0);
                StringBuilder strReturnAddress = new StringBuilder("");
                String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
				String city = addresses.get(0).getLocality();
				String state = addresses.get(0).getAdminArea();
				String country = addresses.get(0).getCountryName();
				String postalCode = addresses.get(0).getPostalCode();
				String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL
             //   for (int i = 0; i < returnAddress.getMaxAddressLineIndex(); i++) {
             //       strReturnAddress
             //               .append(returnAddress.getAddressLine(i)).append(
              //                      "\n");
             //   }
				e1.setText("Latitude: " + latitude + " Longitude: " + longitude + "\n" + address + ""+ state);
                strAddress = strReturnAddress.toString();
                Log.w("address",
                        "" + strReturnAddress.toString());
            } else {
                Log.w("address", "No Address found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.w("address", "Can't get Address!");
        }
        return strAddress;
    }
	private final Runnable m_Runnable = new Runnable()
	{	  
	    public void run()
	    {       
	       //getusers();
	    }
	};
	
	
	

	
	}