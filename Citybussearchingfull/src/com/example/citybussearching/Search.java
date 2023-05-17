package com.example.citybussearching;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Search extends Activity {
	
	 Spinner s1,s2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		s1 = (Spinner) findViewById(R.id.spinner2);
		s2 = (Spinner) findViewById(R.id.spinner3);
		
		 
		 //
		  String getsub=WebService.viewrouteonly("getsub","routeview");
	        String[] str1=null;

	        if (getsub.toString()!="") {
	            str1 = getsub.split("#");
	            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, str1);
	            dataAdapter.setDropDownViewResource(R.layout.spinner_item);
	            s1.setAdapter(dataAdapter);
	            s2.setAdapter(dataAdapter);
	        }
	        
	       
		 //
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	
	
	public void gotoview(View arg)
    {
		
         Intent i = new Intent(this, Viewresult.class);
         i.putExtra("source",s1.getSelectedItem().toString());
         i.putExtra("destination",s2.getSelectedItem().toString());
         startActivity(i);
		
    }
	
	public void gototrack(View arg)
    {
		
         Intent i = new Intent(this, VehicleTracking.class);
         startActivity(i);
		
    }

}
