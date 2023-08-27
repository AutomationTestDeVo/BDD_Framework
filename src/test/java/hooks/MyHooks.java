package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.ConfigReader;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

    WebDriver driver ;
    
    @Before
    public void setup() {
	Properties prop = ConfigReader.initialzeProperties();
	driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
	driver.get(prop.getProperty("url"));
	
    }
    
    @After
    public void tearDown(Scenario scenario) {
	
	String ScenarioName = scenario.getName().replaceAll(" ","_");
	if(scenario.isFailed()) {
	    byte[] srcScreenshort = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    scenario.attach(srcScreenshort, "image/png", ScenarioName);
	}
	driver.quit();
    }
}
