package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtils;

public class CheckOutPage {

    WebDriver driver;
    private ElementUtils elementUtils;
    
    public CheckOutPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	elementUtils = new ElementUtils(driver);
    }
    
    //Billing details
    
    @FindBy(xpath="//input[@name='payment_address'][@value='new']")
    private WebElement new_Address;
    
    @FindBy(xpath="//input[@id='input-payment-firstname']")
    private WebElement firstName;
    
    @FindBy(xpath="//input[@id='input-payment-lastname']")
    private WebElement lastName;
    
    @FindBy(xpath="//input[@id='input-payment-address-1']")
    private WebElement Address1;
    
    @FindBy(xpath="//input[@id='input-payment-city']")
    private WebElement City;
    
    @FindBy(xpath="//select[@id='input-payment-country']")
    private WebElement Country;
    
    @FindBy(xpath="//select[@id='input-payment-zone']")
    private WebElement State;
    
    @FindBy(xpath="//input[@id='button-payment-address']")
    private WebElement ContinueButtonBillingAdress;
    
    //delivery details
    
    @FindBy(xpath="//input[@id='button-shipping-address']")
    private WebElement ContinueButtonDeliveryAdress;
    
    //delivery Method
    
    @FindBy(xpath="//div[@Class='panel-body']/p[4]/textarea")
    private WebElement AddCommentDelivery;
    
    @FindBy(xpath="//input[@id='button-shipping-method']")
    private WebElement ContinueButtonDeliveryMethod;
    
    //Payment Method
    
    @FindBy(xpath="//div[@Class='panel-body']/p[4]/textarea")
    private WebElement AddCommentPayment;
    
    @FindBy(xpath="//div[@Class='pull-right']/input[@type='checkbox']")
    private WebElement termsCondition;
    
    @FindBy(xpath="//input[@id='button-payment-method']")
    private WebElement ContinueButtonPaymentMethod;
    
    //Confirm order
}
