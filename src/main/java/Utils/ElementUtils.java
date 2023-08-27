package Utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
    
    public static final int IMPLICIT_WAIT_TIME=10;
    public static final int PAGE_LOAD_TIMEOUT=60;
    public static final int EXPLICIT_WAIT_BASIC_TIME=30;
    
    private WebDriver driver;

    public ElementUtils(WebDriver driver){
	this.driver = driver;
    }
    
    
    //This is the common method to wait for web element ----------------------------------------------------------------------//
    public WebElement waitforElement(WebElement element,long durationInSeonds) {
	
   	WebElement webElement = null;
   	try {
   	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeonds));
   	webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
   	}catch(Throwable e) {
   	    e.printStackTrace();
   	}
   	return webElement;
       }
    //<--------------------------------------------------------------------------------------------------------->//
    
    //This is common method to wait for Alert window------------------------------------------------------------//
    public Alert WaitforAlerts(long durationInSeonds) {
   	Alert alert=null;
   	try {
   	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeonds));
   	alert = wait.until(ExpectedConditions.alertIsPresent());
   	}catch(Throwable e) {
   	    e.printStackTrace();
   	}
   	return alert;
       }
    //<--------------------------------------------------------------------------------------------------------->//
    //This is common method for visibilityOfElement------------------------------------------------------------//
    public WebElement visibilityofElement(WebElement element, long durationInSeonds) {
	       WebElement Webelement = null;
	       try {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeonds));
	       Webelement = wait.until(ExpectedConditions.visibilityOf(element));
	       }catch(Throwable e){
		   e.printStackTrace();
	       }
	       return Webelement;
	   }
    //<--------------------------------------------------------------------------------------------------------->//
    
    
    
    public void clickOnElement(WebElement element, long durationInSeonds) {
	
	WebElement webElement = waitforElement(element, durationInSeonds);
	webElement.click();
    }
    
    public void typeTextIntoElement(WebElement element, String texttobetyped, long durationInSeonds) {
	WebElement webElement = waitforElement(element, durationInSeonds);
	webElement.click();
	webElement.clear();
	webElement.sendKeys(texttobetyped);
    }
    
    public void selectOptionInDropDown(WebElement element, String dropDownOption, long durationInSeonds) {
	
	WebElement webElement = waitforElement(element, durationInSeonds);
	Select select = new Select(webElement);
	select.selectByVisibleText(dropDownOption);
    }
    
    public void acceptAlert(long durationInSeonds) {
	Alert alert = WaitforAlerts(durationInSeonds);
	alert.accept();
    }
    
    public void dismissAlert(long durationInSeonds) {
	Alert alert = WaitforAlerts(durationInSeonds);
	alert.dismiss();
    }
    
   public void mouseHoverAndClick(WebElement element, long durationInSeonds) {
     
       WebElement Webelement = visibilityofElement(element, durationInSeonds);
       
       Actions action = new Actions(driver);
       action.moveToElement(Webelement).click().build().perform(); 
   }
   
   public void javaScriptClick(WebElement element, long durationInSeonds) {
       WebElement Webelement = visibilityofElement(element,durationInSeonds);
       JavascriptExecutor jse = ((JavascriptExecutor)driver);
       jse.executeScript("argument[0].click()", Webelement);
   }
   
   public void javaScriptType(WebElement element, String texttobetyped, long durationInSeonds) {
       WebElement Webelement = visibilityofElement(element,durationInSeonds);
       JavascriptExecutor jse = ((JavascriptExecutor)driver);
       jse.executeScript("argument[0].value='"+texttobetyped+"'", Webelement);
   }
   
   public String getTextFromElement(WebElement element, long durationInSeonds) {
       WebElement webElement = waitforElement(element, durationInSeonds);
       return webElement.getText();
       
   }
   
   public boolean displayStatusOfElement(WebElement element, long durationInSeonds) {
       
       try {
       WebElement Webelement = visibilityofElement(element, durationInSeonds);
       return Webelement.isDisplayed();
       }catch(Throwable e) {
	   e.printStackTrace();
	   return false;
       }
   }
   
}
