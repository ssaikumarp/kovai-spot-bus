package com.example.citybussearching;

import com.example.citybussearching.R;
import com.example.citybussearching.WebService;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
public class MainActivity extends Activity {

	 Spinner s1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 s1 = (Spinner) findViewById(R.id.spinner1);
		 
		 
		 //
		//  String getsub=WebService.viewcityonly("getsub","Citydetails");
	      //  String[] str1=null;

	      //  if (getsub.toString()!="") {
	      //      str1 = getsub.split("#");
	      //      ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, str1);
	       ///     dataAdapter.setDropDownViewResource(R.layout.spinner_item);
	       //     s1.setAdapter(dataAdapter);
	       // }
		 //
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
