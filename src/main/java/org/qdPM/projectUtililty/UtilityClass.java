package org.qdPM.projectUtililty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class UtilityClass {

	private UtilityClass()
	{

	}

	// Method to get property value on basis of key 
	/*
	 * public static String getValue(String key) throws IOException {
	 * FileInputStream fileInputStream = new FileInputStream(
	 * "C:\\Users\\sumit\\Education\\Web_Automation\\org.qdPM\\src\\main\\resources\\frameworkproperties\\Property.properties"
	 * ); Properties prop = new Properties(); prop.load(fileInputStream); String
	 * value = prop.getProperty(key); if (key==" " || Objects.isNull(value)) {
	 * System.out.
	 * println("Check key !! value or key is blank or incorrect....key = "
	 * +key+"value of key = "+ value); } return value; }
	 */
	
	
	private static Properties prop = new Properties(); 
	private static final HashMap<String,String> MAP = new HashMap<String, String>();
	// static block is used to load properties file 
	static
	{
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("C:\\Users\\sumit\\Education\\Web_Automation\\org.qdPM\\src\\main\\resources\\frameworkproperties\\Property.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Object key : prop.keySet())
		{
			MAP.put(String.valueOf(key), String.valueOf(prop.get(key)));
		}
	
	}

	// getting property values using Hashmap
	
	public static String getValue(String key) throws IOException
	{
		if(Objects.isNull(key) || Objects.isNull(MAP.get(key)))
		{
			System.out.println("Check key !! value or key is blank or incorrect....key =" +key+" value of key = "+MAP.get(key));
		}
		return MAP.get(key);
		
	}




}
