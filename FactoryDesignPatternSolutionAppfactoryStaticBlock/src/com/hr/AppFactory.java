package com.hr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppFactory {

	static Properties props = null;
	static {
		try {
		props = new Properties();
		props.load(new FileInputStream("src/app_class.properties"));
		}catch(Exception e) {e.printStackTrace();}
	}
	public static Object createObject(String logicalName) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Object obj = null;
		String className = null;
		className = props.getProperty(logicalName);
		obj =Class.forName(className).newInstance();
		return obj;
	}
}
