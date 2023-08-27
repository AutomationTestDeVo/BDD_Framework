package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtils;

public class SuccessOrderPage {

    WebDriver driver;
    private ElementUtils elementUtils;
    
    public SuccessOrderPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	elementUtils = new ElementUtils(driver);
    }
    
    @FindBy(xpath="//div[@id='content']/h1")
    private WebElement SuccessMsg;
}
