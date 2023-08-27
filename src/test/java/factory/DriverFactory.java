package factory;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Utils.ElementUtils;



public class DriverFactory {
    
    static WebDriver driver=null;
    
    public static WebDriver initializeBrowser(String browserName) {	
	
	if(browserName.equalsIgnoreCase("chrome")) {
	    	driver = new ChromeDriver();
	}else if(browserName.equalsIgnoreCase("firefox")) {
	    	driver = new FirefoxDriver();
	}else if(browserName.equalsIgnoreCase("edge")) {
	    	driver = new EdgeDriver();
	}else if(browserName.equalsIgnoreCase("safari")) {
	    	driver = new SafariDriver();
	}
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ElementUtils.PAGE_LOAD_TIMEOUT));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ElementUtils.IMPLICIT_WAIT_TIME));
	return driver;
	
    }
    public static WebDriver getDriver() {
	return driver;
    }
}
