package Stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class experimentClas {

    public static void main(String[] args) {
	
	WebDriver driver = new EdgeDriver();
	driver.get("https://tutorialsninja.com/demo");
	driver.manage().window().maximize();
    }

}
