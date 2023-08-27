package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtils;

public class RegisterPage {
    
    WebDriver driver;
    private ElementUtils elementUtils;
    
    public RegisterPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	elementUtils = new ElementUtils(driver);
    }
    
    @FindBy(id ="input-firstname")
    private WebElement firstname;
    
    @FindBy(id ="input-lastname")
    private WebElement lastname;
    
    @FindBy(id ="input-email")
    private WebElement email;
    
    @FindBy(id ="input-telephone")
    private WebElement telephone;
    
    @FindBy(id ="input-password")
    private WebElement password;
    
    @FindBy(id ="input-confirm")
    private WebElement confirm;
    
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement policycheck;
    
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement continuebutton;
    
    @FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    private WebElement newzletter;
    
    
    public void enterfirstName(String text) {
	elementUtils.typeTextIntoElement(firstname, text, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public void enterlastName(String text) {
	elementUtils.typeTextIntoElement(lastname, text, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
       }
    
    public void enteremail(String text) {
	elementUtils.typeTextIntoElement(email, text, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
       }
    
    public void entertelephone(String text) {
	elementUtils.typeTextIntoElement(telephone, text, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
       }
    
    public void enterpassword(String text) {
	elementUtils.typeTextIntoElement(password, text, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
       }
    
    public void enterconfirmpassword(String text) {
	elementUtils.typeTextIntoElement(confirm, text, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
       }
    
    public void privacyPolicyButton() {
	elementUtils.clickOnElement(policycheck, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public void clickcontinueButton() {
	elementUtils.clickOnElement(continuebutton, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public void clicknewsletter() {
	elementUtils.clickOnElement(newzletter, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
