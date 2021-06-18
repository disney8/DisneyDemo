package com.proyecto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DemoPropertiesContainer {
 
	private static DemoPropertiesContainer demoPropertiesContainer;
	
	private Properties prop;
	private boolean initialized;
	
	private DemoPropertiesContainer() { 
		prop = new Properties();
		initialized = false;
	}
	
	/**
	 * in thread project, we can use synchronized or volatile
	 * @return
	 */ 
	public static DemoPropertiesContainer instance() {
		if(demoPropertiesContainer == null)
			demoPropertiesContainer = new DemoPropertiesContainer();
		
		return demoPropertiesContainer;
	}
	
	public void init() throws IOException {
		InputStream inputStream = Demo.class.getClassLoader().getResourceAsStream("application.properties");
		prop.load(inputStream);
		initialized = true;
	}
	
	public String get(String key) throws IOException {
		if(!initialized) init();
		return prop.getProperty(key);
	}
	
	public void set(String key, String value) throws IOException {
		if(!initialized) init();
		prop.setProperty(key, value);
	}

}
