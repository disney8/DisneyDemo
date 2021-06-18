package com.proyecto.handlers;

import java.sql.Statement;
import java.text.DateFormat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import org.postgresql.Driver;

import com.proyecto.DemoPropertiesContainer;

public class DataBaseHandler extends Handler {
  
	private static final String C_DB_URL = "db_url"; 
	private static final String C_DB_USER = "db_username"; 
	private static final String C_DB_PASSWORD = "db_password";
	   
			 
	public DataBaseHandler() { 
	}

	/**
	 * store the message
	 */
	@Override
	public void publish(LogRecord record) {

		try {
			
			Connection connection = DriverManager.getConnection(DemoPropertiesContainer.instance().get(C_DB_URL),
					  										    DemoPropertiesContainer.instance().get(C_DB_USER),
					  										    DemoPropertiesContainer.instance().get(C_DB_PASSWORD));
			  
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("insert into log_values (msg) values ('" + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + record.getMessage() + ", " + record.getLevel().getName() + "')");
			connection.close();
		} catch (SQLException | IOException e) { 
			e.printStackTrace();
		}
		
	}
  
	@Override
	public void flush() {   
	}

	@Override
	public void close() throws SecurityException { 
	}


}
