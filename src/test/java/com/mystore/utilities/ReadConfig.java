package com.mystore.utilities;

import java.io.FileInputStream;

import java.util.Properties;



public class ReadConfig {
	
	Properties properties;
	
	String path="C:\\Users\\User\\eclipse\\MyStoreV2\\Configuration\\config.properties";

	//constructor
	public ReadConfig() {
		
		
		
		try {
			properties=new Properties();
			FileInputStream file=new FileInputStream(path);
			
				properties.load(file);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}
	
	public String getBaseUrl() {
		
		String value=properties.getProperty("baseurl");
		
		if(value!=null)
		return value;
		else
			throw new RuntimeException("url not specifiged in config file");
		
		
	}
	
	public String getBrowser() {
		
		String value=properties.getProperty("browser");
		if(value!=null)
			return value;
			else
				throw new RuntimeException("Browser not specifiged in config file");
			
	}
	
	
	
}
