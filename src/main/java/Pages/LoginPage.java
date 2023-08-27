package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtils;

public class LoginPage {
    
    WebDriver driver;
    private ElementUtils elementUtils;
    
    public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	elementUtils = new ElementUtils(driver);
    }
    
    @FindBy(id = "input-email")
    private WebElement EmailField;
    @FindBy(id = "input-password")
    private WebElement PasswordField;
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement LoginButton;
    
    
    public void emailtextfield(String email) {
	elementUtils.typeTextIntoElement(EmailField, email, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void passwordtextfield(String password) {
	elementUtils.typeTextIntoElement(PasswordField, password, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void clicklognbutton() {
	elementUtils.clickOnElement(LoginButton, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
