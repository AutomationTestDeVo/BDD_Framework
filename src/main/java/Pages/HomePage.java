package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtils;

public class HomePage {
    
    WebDriver driver;
    private ElementUtils elementUtils;
    
    public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	elementUtils = new ElementUtils(driver);
    }
    //This can't be access outside classes
    @FindBy(xpath="//span[text()='My Account']")
    private WebElement MyAccountDropMenu;
    
    @FindBy(linkText = "Login")
    private WebElement loginOption;
    
    @FindBy(linkText = "Register")
    private WebElement registerOption;
    
    @FindBy(xpath="//a[@title='Shopping Cart']")
    private WebElement shoppingCart;
    
    //Search bar
    @FindBy(xpath = "//input[contains(@class,'input-lg')]")
    private WebElement searchbox;
    
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    private WebElement searchButton;
    
    
    
    //This can be access by any classes
    public void clickonMyAccount() {
	elementUtils.clickOnElement(MyAccountDropMenu, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void clickonLoginOption() {
	elementUtils.clickOnElement(loginOption, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void clickonRegisterOption() {
	elementUtils.clickOnElement(registerOption, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void enterSearchtext(String text) {
	elementUtils.typeTextIntoElement(searchbox, text, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void clickSearchButton() {
	elementUtils.clickOnElement(searchButton, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public void ClickShoppingCart() {
	elementUtils.clickOnElement(shoppingCart, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
