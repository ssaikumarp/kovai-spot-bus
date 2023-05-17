package com.example.citybussearching;

import javax.sql.DataSource;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.R.string;

public class WebService<DataTable> {
	//Namespace of the Webservice - can be found in WSDL
	private static String NAMESPACE = "http://tempuri.org/";
	//Webservice URL - WSDL File location	
	private static final String URL = "http://192.168.43.53:32768/Service.asmx";//Make sure you changed IP address
	//SOAP Action URI again Namespace + Web method name
	private static String SOAP_ACTION = "http://tempuri.org/";
	
	
	
		
	public static String getlocation(String p1,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();
		
		
		// Set Username
		unamePI.setName("p1");
		// Set Value
		unamePI.setValue(p1);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);
				
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return loginStatus;
	}
	public static String Viewveh(String FuName, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo p1 = new PropertyInfo();


		p1.setName("res");
		p1.setValue(FuName);
		p1.setType(String.class);
		request.addProperty(p1);



		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}
	
	public static String stulogincheck(String username,String password,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();
		
		
		// Set Username
		unamePI.setName("username");
		// Set Value
		unamePI.setValue(username);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);
		//Set Password
		passPI.setName("password");
		//Set dataType
		passPI.setValue(password);
		//Set dataType
		passPI.setType(String.class);
		//Add the property to request object
		request.addProperty(passPI);
		
		
		
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return loginStatus;
	}
	
	public static String viewrouteonly(String username,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
PropertyInfo user = new PropertyInfo();
		
		
		// Set Username
		user.setName("res");
		// Set Value
		user.setValue(username);
		// Set dataType
		user.setType(String.class);
		// Add the property to request object
		request.addProperty(user);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return loginStatus;
	}
	
	public static String getuser(String username,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
PropertyInfo user = new PropertyInfo();
		
		
		// Set Username
		user.setName("username");
		// Set Value
		user.setValue(username);
		// Set dataType
		user.setType(String.class);
		// Add the property to request object
		request.addProperty(user);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'
			
			e.printStackTrace();
		} 
		//Return booleam to calling object
		return loginStatus;
	}
	
	
	
	public static String Busroutedetailsview(String P1,String P2, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo v1 = new PropertyInfo();
		PropertyInfo v2 = new PropertyInfo();

		v1.setName("Source");
		v1.setValue(P1);
		v1.setType(String.class);
		request.addProperty(v1);


		v2.setName("Destination");
		v2.setValue(P2);
		v2.setType(String.class);
		request.addProperty(v2);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}

	
	public static String updateLocation(String p1,String p4,String p5,String p6,String webMethName) 
	{
		String loginStatus ="";
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		 PropertyInfo pI1=new PropertyInfo();
		
		 PropertyInfo pI4=new PropertyInfo();
		 PropertyInfo pI5=new PropertyInfo();
		 PropertyInfo pI6=new PropertyInfo();
		 	        
		pI1.setName("p1");		
		pI1.setValue(p1);			
		pI1.setType(String.class);			
		request.addProperty(pI1);
		
		
		
		pI4.setName("p4");		
		pI4.setValue(p4);			
		pI4.setType(String.class);			
		request.addProperty(pI4);
		
		pI5.setName("p5");		
		pI5.setValue(p5);			
		pI5.setType(String.class);			
		request.addProperty(pI5);
		
		pI6.setName("p6");		
		pI6.setValue(p6);			
		pI6.setType(String.class);			
		request.addProperty(pI6);
				
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		try 
		{
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			loginStatus = response.toString();
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return loginStatus;
	}
	
	
	public static boolean addstuatt(String v1,String v2,String v3,String v4,String v5,String webMethName) {
		boolean loginStatus = false;
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo p1 = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		PropertyInfo p3 = new PropertyInfo();
		PropertyInfo p4 = new PropertyInfo();
		PropertyInfo p5 = new PropertyInfo();
		

		p1.setName("stureg");//dotnet webservice code string
		p1.setValue(v1);//in this code string variable
		p1.setType(String.class);
		request.addProperty(p1);

		p2.setName("stuname");
		p2.setValue(v2);
		p2.setType(String.class);
		request.addProperty(p2);


		p3.setName("std");
		p3.setValue(v3);
		p3.setType(String.class);
		request.addProperty(p3);

		p4.setName("Astatus");
		p4.setValue(v4);
		p4.setType(String.class);
		request.addProperty(p4);

		p5.setName("vehicleno");
		p5.setValue(v5);
		p5.setType(String.class);
		request.addProperty(p5);

	
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = Boolean.parseBoolean(response.toString());

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}
	
	//get notification
	public static String getnot(String name,String webMethName) 
	{
		String loginStatus ="";
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		 PropertyInfo p1=new PropertyInfo();
		
		p1.setName("vecno");		
		p1.setValue(name);			
		p1.setType(String.class);			
		request.addProperty(p1);
				
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		try 
		{
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			loginStatus = response.toString();
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return loginStatus;
	}
}