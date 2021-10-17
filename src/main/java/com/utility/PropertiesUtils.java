package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.testBase.TestBase;

public class PropertiesUtils extends TestBase {

	public static FileInputStream fis=null;
	public static Properties prop=null;
	
	
	public static String getProperty(String key) {
		try {
			log.info("reading property file for key: "+key);
			fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		} catch (FileNotFoundException e) {
			log.error("property filepath is wrong");
			e.printStackTrace();
		}
		prop= new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			log.error("property file not initialised properly");
			e.printStackTrace();
		}		
		log.info("property value found");
		return prop.getProperty(key);
	}
	
	
}
