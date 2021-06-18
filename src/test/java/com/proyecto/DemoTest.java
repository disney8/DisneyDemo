package com.proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager; 

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DemoTest {


	@BeforeAll
	public static void data() throws SecurityException, IOException {
		LogManager.getLogManager().readConfiguration(Demo.class.getClassLoader().getResourceAsStream("logging.properties"));
	}
	
	@Test
	public void testAllLevels() {
		try { 
			Demo demo = new Demo();  
			demo.LogMessage("hi world, it is test warnning!", Level.WARNING);
			demo.LogMessage("hi world, it is test severe", Level.SEVERE);
			 
		} catch (Exception e) { 
			e.printStackTrace(); 
		    assertTrue(true, e.getMessage());
		}
	}
	

	@Test
	public void testWarningPermitted() {
		try {
			Demo demo = new Demo();
			demo.LogMessage("hi world, it is test warning", Level.WARNING);

		} catch (Exception e) {
			String expectedMessage = "INFO Level is warning";
			assertEquals(expectedMessage,e.getMessage());
		}
	}

	@Test
	public void testNoPermitted() {
		try {
			Demo demo = new Demo();
			demo.LogMessage("hi world, it is test severe", Level.SEVERE);

		} catch (Exception e) {
			String expectedMessage = "INFO Level is not permitted";
			assertEquals(expectedMessage,e.getMessage());
		}
	}
}
