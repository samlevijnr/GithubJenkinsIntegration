package com.gmail.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.gmail.constants.ConstantValues;

public class PropUtils implements ConstantValues {

	Properties property = null;
	
	public PropUtils() throws IOException{
		property = new Properties();
		
		FileInputStream fStream = null;
		try {
			fStream = new FileInputStream(file_object_properties);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		property.load(fStream);
	}
	
	public String GetValue(String key){
		String value = property.getProperty(key);
		return value;
	}
	
}
