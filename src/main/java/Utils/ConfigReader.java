package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    
    public static Properties initialzeProperties() {
	
	Properties prop = new Properties();
	File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ConfigFile\\config.properties");
	FileInputStream fis;
	try {
	    fis = new FileInputStream(propFile);
	    prop.load(fis);
	} catch (Throwable e) {
	    e.printStackTrace();
	}
	return prop;
    }
    
}
