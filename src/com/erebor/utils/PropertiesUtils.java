package com.erebor.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	private Properties properties;
	private InputStream input;
	
	public static String getProperty(String prop) throws Exception{
		Properties properties = new Properties();
		InputStream input = null;
		input = new FileInputStream(new File("application.properties"));
		
		properties.load(input);
		
		String token = properties.getProperty(prop);
		
		return token;
	}

}
