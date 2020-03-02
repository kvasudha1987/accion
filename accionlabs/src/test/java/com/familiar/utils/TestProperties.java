package com.familiar.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Reporter;

public class TestProperties {
	// Properties file path.
	static String filePath = "test.properties";
	static public Properties prop = new Properties();

	public static Properties loadConfig() {
		try {
			InputStream inputStream = TestProperties.class.getClassLoader().getResourceAsStream(filePath);
			System.out.println(inputStream);
			// Loading the properties.
			prop.load(inputStream);

		} catch (IOException exception) {
			System.out.println("Problem occured when reading config file !");
			exception.printStackTrace();
		}
		return prop;
	}
	
	public static Properties loadProperties()
	  {
	    String propsFilePath = System.getProperty("user.dir").concat(File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"test.properties");
	    try
	    {
	    	prop.load(new FileInputStream(propsFilePath));
	    }
	    catch (Exception e)
	    {
	      String error = e.getMessage();
	      Reporter.log(error);
	    }
	    return prop;
	  }
}
