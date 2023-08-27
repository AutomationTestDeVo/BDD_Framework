package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.ProductsPage.Palm_treo_page;
import Utils.ElementUtils;

public class SearchPage {

    
    WebDriver driver;
    private ElementUtils elementUtils;
    
    public SearchPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	elementUtils = new ElementUtils(driver);
    }
    
    @FindBy(xpath="//div[@id='content']/h1")
    private WebElement verifyPalmText;
    
    @FindBy(linkText = "Palm Treo Pro")
    private WebElement palmPage;
    
    public String VerifyProductPage() {
   	String actualMsg = elementUtils.getTextFromElement(verifyPalmText, ElementUtils.EXPLICIT_WAIT_BASIC_TIME);
   	return actualMsg;
       }
       
     public Palm_treo_page ClickProductPalmTreo() {
   	elementUtils.clickOnElement(palmPage, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	return new Palm_treo_page(driver);
       }
}
