package com.proyecto;
 
import java.io.IOException; 
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.postgresql.Driver;

public class Demo {   
	  
	private static final String C_LEVEL_RESTRICTION = "log_levels_restriction";
	
    private static Logger logger;  

    public Demo() {
    	logger = Logger.getLogger("MyLog"); 
    }
      
    public void LogMessage(String messageText, Level level) throws Exception {
    	 
    	String levelRestriction = DemoPropertiesContainer.instance().get(C_LEVEL_RESTRICTION); 
    	if(levelRestriction != null && !levelRestriction.contains(level.getName()))
    		 throw new Exception(level.getName() + " Level is not permitted");
    	
	    if (messageText == null || messageText.trim().length() == 0) {
	        return;
	    }
	   
	    if(level == null) {
	    	throw new Exception("Error Level was not specified");
	    }
	    
	    logger.getHandlers();
	    logger.log(level, messageText); 
 
    }
    
    
    public static void main(String[] args) throws Exception {  
    	app_init(); 
    	Demo demo = new Demo();

		int i;
		for (i = 0; i < args.length; i++) {
			System.out.print(args[i]+ " ");
		}
    	demo.LogMessage("hola, Mensaje error", Level.SEVERE);
    	demo.LogMessage("hola, mensaje de advertencia", Level.WARNING);
    }

	private static void app_init() throws SecurityException, IOException {
		LogManager.getLogManager().readConfiguration(Demo.class.getClassLoader().getResourceAsStream("logging.properties")); 
	}
    
}
