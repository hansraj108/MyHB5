package com.hr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppFactory {

	public static Object createObject(String logicalName) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Properties props = null;
		Object obj = null;
		String className = null;
		props = new Properties();
		props.load(new FileInputStream("src/app_class.properties"));
		className = props.getProperty(logicalName);
		obj =Class.forName(className).newInstance();
		return obj;
	}
}
