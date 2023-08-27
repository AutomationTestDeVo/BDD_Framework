package Stepdefination;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import Pages.ProductsPage.Palm_treo_page;
import Utils.ConfigReader;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingTest {
    
    WebDriver driver = DriverFactory.getDriver();
    HomePage homepage = new HomePage(driver);
    LoginPage loginpage = new LoginPage(driver);
    Palm_treo_page productPage = new Palm_treo_page(driver);
    SearchPage searchPage = new SearchPage(driver);
    ShoppingCartPage shoppingPage = new ShoppingCartPage(driver);
    Properties prop = ConfigReader.initialzeProperties();
    
     public String PriceTagSingleUnit;
    
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        homepage.clickonMyAccount();
        homepage.clickonLoginOption();
        loginpage.emailtextfield(prop.getProperty("userId"));
        loginpage.passwordtextfield(prop.getProperty("password"));
        loginpage.clicklognbutton();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
    }

    @When("the user searches for {string} in the search bar")
    public void the_user_searches_for_in_the_search_bar(String product) {
	homepage.enterSearchtext(product);
	homepage.clickSearchButton();
	if(searchPage.VerifyProductPage().contains(product)) {
	    searchPage.ClickProductPalmTreo();
	}
    }

    @When("the user selects a quantity of {string} for the product")
    public void the_user_selects_a_quantity_of_for_the_product(String number) {
	productPage.enterQuantityProduct(number);
	productPage.ClickAddToCart();
	PriceTagSingleUnit = productPage.CapturePriceTag();
	
    }

    @When("the user moves to the shopping cart page")
    public void the_user_moves_to_the_shopping_cart_page() {
	homepage.ClickShoppingCart();
	
	
    }

    @Then("the product quantity in the cart should be {string}")
    public void the_product_quantity_in_the_cart_should_be(String string) {
        
    }

    @Then("the user captures the price of the product")
    public void the_user_captures_the_price_of_the_product() {
	
    }

//    @Then("the user proceeds to the checkout page")
//    public void the_user_proceeds_to_the_checkout_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

    @When("the user enters the billing address details")
    public void the_user_enters_the_billing_address_details() {
        
    }

    @When("the user enters the delivery details")
    public void the_user_enters_the_delivery_details() {
        
    }

    @When("the user selects a delivery method")
    public void the_user_selects_a_delivery_method() {
        
    }

    @When("the user verifies the captured price on the checkout page")
    public void the_user_verifies_the_captured_price_on_the_checkout_page() {
        
    }

    @When("the user enters the payment method")
    public void the_user_enters_the_payment_method() {
      
    }

    @When("the user confirms the order")
    public void the_user_confirms_the_order() {
       
    }

    @Then("a success message should be displayed")
    public void a_success_message_should_be_displayed() {
      
    }

    @Then("the user verifies the order ID in the Order History page")
    public void the_user_verifies_the_order_id_in_the_order_history_page() {
     
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        
    }

    @Then("the user cannot proceed to the checkout page")
    public void the_user_cannot_proceed_to_the_checkout_page() {
       
    }

    @Then("an error message should indicate insufficient stock")
    public void an_error_message_should_indicate_insufficient_stock() {
        
    }

    @When("the user proceeds to the checkout page")
    public void the_user_proceeds_to_the_checkout_page() {
        
    }

    @When("the user enters an invalid billing address")
    public void the_user_enters_an_invalid_billing_address() {
        
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
       
    }

    @When("the user selects an invalid delivery method")
    public void the_user_selects_an_invalid_delivery_method() {
       
    }

    @When("the user removes all items from the cart")
    public void the_user_removes_all_items_from_the_cart() {
       
    }
}
