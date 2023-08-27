package Pages.ProductsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtils;

public class Palm_treo_page {

    WebDriver driver;
    private ElementUtils elementUtils;
    
    public Palm_treo_page(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	elementUtils = new ElementUtils(driver);
    }
    
    
    @FindBy(xpath="//div[@Class='form-group']/input[@id='input-quantity']")
    private WebElement QuantityInfo;
    
    @FindBy(xpath="//div[@Class='form-group']/button[1]")
    private WebElement AddToCart;
    
    @FindBy(xpath="//div[@class='col-sm-4']/ul[2]/li[1]/h2")
    private WebElement priceTag;
    
    public void enterQuantityProduct(String number) {
	elementUtils.typeTextIntoElement(QuantityInfo, number, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void ClickAddToCart() {
	elementUtils.clickOnElement(AddToCart, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public String CapturePriceTag() {
	String PriceTag = elementUtils.getTextFromElement(priceTag, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	return PriceTag.substring(1);
    }
}
