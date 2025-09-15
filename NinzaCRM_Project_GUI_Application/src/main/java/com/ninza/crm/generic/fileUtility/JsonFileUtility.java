package com.ninza.crm.generic.fileUtility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileUtility {


	public JSONObject jsonFileUtility(String file) throws IOException, ParseException, org.json.simple.parser.ParseException
	{
		//		-------------------------JSON file--------------------------------------------
//		step--1---Create a java representation of physical file 
		
		FileReader fr=new FileReader(file);
		
//		step 2---create the object of JSONparser and use parse() to pass the object
		JSONParser jsonParser=new JSONParser();
	    Object javaObject = jsonParser.parse(fr);

//	    step 3---convert java object to json object by downcasting
	    JSONObject jsonObject = (JSONObject)javaObject;
	    return jsonObject;
	    
	}
	
	public String readDataFromJson(JSONObject json_Object,String value) throws IOException, ParseException
	{
//	    Read data using get()
	    	String VALUE = json_Object.get(value).toString();
	    	return VALUE;
	}
	

}
