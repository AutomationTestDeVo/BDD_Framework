package Stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.HomePage;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchTest {

    
    WebDriver driver;
    private HomePage homepage;
    
    @Given("User open the application")
    public void user_open_the_application() {
	driver = DriverFactory.getDriver();
	homepage = new HomePage(driver);
    }

    @When("User enters valid product {string} into Search box field")
    public void user_enters_valid_product_into_search_box_field(String validProduct) {
        homepage.enterSearchtext(validProduct);
    }

    @When("User clicks on seach button")
    public void user_clicks_on_seach_button() {
	homepage.clickSearchButton();
    }

    @Then("User should get valid product displayed in search results")
    public void user_should_get_valid_product_displayed_in_search_results() {
    Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
    }

    @When("User enters invalid product {string} into search box field")
    public void user_enters_invalid_product_into_search_box_field(String invalidProduct) {
	 homepage.enterSearchtext(invalidProduct);
    }

    @Then("user should get a message about no product matching")
    public void user_should_get_a_message_about_no_product_matching() {
	String ActualSearchMsg = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
	Assert.assertTrue(ActualSearchMsg.contains("There is no product that matches the search criteria."), "Required Search Error Message is not Displayed");
    }

    @When("User do not enter any product name into search box field")
    public void user_do_not_enter_any_product_name_into_search_box_field() {
	homepage.enterSearchtext("");
    }
}
