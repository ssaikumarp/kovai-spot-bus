package com.example.citybussearching;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;


import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Viewresult extends Activity {
	
	TextView tv1,tv2;
	 String source,destination;
	 

		public String[] Busno= new String[41];
		public String[] Source= new String[41];
		public String[] Destination= new String[41];
		public String[] Bustime= new String[41];
	//	public String[] Latitude= new String[41];
	//	public String[] Longitude= new String[41];
		
	
		public ListView lv;
		public String login;
		public int rowcount=0;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewresult);
		
		Intent ii = getIntent();
		tv1 = (TextView) findViewById(R.id.textView1);
		tv2 = (TextView) findViewById(R.id.textView2);
		source = ii.getStringExtra("source");
	    tv1.setText(source);
	    destination = ii.getStringExtra("destination");
	    tv2.setText(destination);
	    
	    lv = (ListView) findViewById(R.id.listView1); 
	    
		//
		 if (android.os.Build.VERSION.SDK_INT >= 9) {
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy);
			}
	 
	 login=WebService.Busroutedetailsview(tv1.getText().toString(),tv2.getText().toString(),"Busroutedetails");		
	 
	 // Toast.makeText(getApplication(),login,Toast.LENGTH_LONG).show();
	 String[] listss= login.split("#");		
	 int xx= listss.length;

	 int iRows = listss.length;
	 rowcount=iRows;

	 Busno = new String[iRows];
	 Source = new String[iRows];
	 Destination = new String[iRows];
	 Bustime= new String[iRows];	    	
	// Latitude= new String[iRows];	    	
	// Longitude= new String[iRows];	    
	   
  
      int i=0;
      // looping through all rows and adding to list
      for (i=0;i<listss.length;i++) {
         String[] ListItems = listss[i].toString().split(",");
      	
         Busno[i]=ListItems[0].toString();
         Source[i]=ListItems[1].toString();
         Destination[i]=ListItems[2].toString();
         Bustime[i]=ListItems[3].toString();	 
         //Latitude[i]=ListItems[4].toString();	 
         //Longitude[i]=ListItems[5].toString();	 
         
          //	i++;	      	        	
      }  
    lv.setAdapter(new ImageAdapter(getApplicationContext())); 


    
    lv.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        	TextView bugid=(TextView) view.findViewById(R.id.p1);
        	//TextView bagname=(TextView) view.findViewById(R.id.bugname);
        	//TextView price=(TextView) view.findViewById(R.id.tvStatus);
        	//String url =WebService.URLimg +imgpath[position];
				            	
        //	Toast.makeText(UserHome.this,tv.getText(), Toast.LENGTH_LONG).show();             
         //  Intent ij = new Intent(Viewcomplaint.this, Updatestatus.class);
           //ij.putExtra("bugid",bugid.getText());
           
         //  ij.putExtra("userid",tv.getText().toString());
         //  ij.putExtra("bagname",bagname.getText());
          // ij.putExtra("price",price.getText());
         //  ij.putExtra("url",url);
          // startActivityForResult(ij,500);
        }
    });	
		
		//
	}
	
	
	private class ImageAdapter extends BaseAdapter
	{		
		private Context ctx;
		private TextView tv1;
		private TextView tv2;
		private TextView tv3;
		private TextView tv4;
		private TextView tv5;
		private TextView tv6;
		private ImageView image;
		private TextView tv7;
		private TextView tv8;
		private LayoutInflater layoutInflater;
		
		public ImageAdapter(Context context)
		{
			this.ctx= context;
			layoutInflater = (LayoutInflater) ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
			
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return rowcount;
		}
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {				
				ViewGroup onerow = (ViewGroup) layoutInflater.inflate(R.layout.customcomplaint, null); 	
				
				tv1 = (TextView) onerow.findViewById(R.id.p1);
				tv2 = (TextView) onerow.findViewById(R.id.p2);
				tv3 = (TextView) onerow.findViewById(R.id.p3);
				tv4 = (TextView) onerow.findViewById(R.id.p4);
				//tv5 = (TextView) onerow.findViewById(R.id.p5);
				//tv6 = (TextView) onerow.findViewById(R.id.p6);
			
			//	image = (ImageView) onerow.findViewById(R.id.ivIcon);


				URL url;
			//	try {
				//	url = new URL( WebService.URLimg +imgpath[position]);
					//Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
					//image.setImageBitmap(bmp);
				//} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				//} catch (IOException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				//}
				


				
				
				tv1.setText(Busno[position]);
				tv2.setText(Source[position]);			
				tv3.setText(Destination[position]);
				tv4.setText(Bustime[position]);
			//	tv5.setText(Latitude[position]);			
				//tv6.setText(Longitude[position]);
				
				//position++;
				return onerow;
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.viewresult, menu);
		return true;
	}

}
