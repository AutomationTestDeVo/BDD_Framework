package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtils;
import Utils.PageControlUtils;

public class ShoppingCartPage {

    WebDriver driver;
    private ElementUtils elementUtils;
    private PageControlUtils pageUtils;
    
    public ShoppingCartPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	elementUtils = new ElementUtils(driver);
    }
    
    @FindBy(linkText = "btn btn-primary")
    private WebElement CheckOutButton;
    
    //Handling Table for product price Verification
    
    @FindBy(xpath="//div[@class='col-sm-4 col-sm-offset-8']/table")
    private WebElement TableElement1;
    
}
