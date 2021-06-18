package com.proyecto.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utiles {
	
	private Properties properties = new Properties();
	private String usuario;
	private String password;
	
	// This method is used to load the properties file
		  public void loadPropertiesFile(){
		    InputStream iStream = null;
		      try {
		        // Loading properties file from the path (relative path given here)
		    	  iStream = this.getClass().getClassLoader().getResourceAsStream("app.properties");
		    	  properties.load(iStream);
		      } catch (IOException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		      }finally {
		        try {
		          if(iStream != null){
		            iStream.close();
		          }
		        } catch (IOException e) {
		          // TODO Auto-generated catch block
		          e.printStackTrace();
		        }
		      }
		    }
		  
		  /**
		  * Method to read the properties from a * loaded property file
		  */
		  public void readProperties(){
		    setPassword(properties.getProperty("password"));
		    setUsuario(properties.getProperty("usuario"));
		  }

		public Properties getProperties() {
			return properties;
		}

		public void setProperties(Properties properties) {
			this.properties = properties;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

}
