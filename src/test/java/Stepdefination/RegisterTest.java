package Stepdefination;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.HomePage;
import Pages.RegisterPage;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterTest {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homepage = new HomePage(driver);
    RegisterPage registerpage = new RegisterPage(driver);
    
    @Given("User navigates to Register Account page")
    public void user_navigates_to_register_account_page() {
       homepage.clickonMyAccount();
       homepage.clickonRegisterOption();
    }

    @When("User enters the below fields")
    public void user_enters_the_below_fields(io.cucumber.datatable.DataTable dataTable) {
	Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
	
	registerpage.enterfirstName(dataMap.get("firstName"));
	registerpage.enterlastName(dataMap.get("lastname"));
	registerpage.enteremail(generateEmailwitTimeStamp());
	registerpage.entertelephone(dataMap.get("telephone"));
	registerpage.enterpassword(dataMap.get("password"));
	registerpage.enterconfirmpassword(dataMap.get("password"));
	
    }
    
    @When("User enters the below fields with duplicate")
    public void user_enters_the_below_fields_with_duplicate(io.cucumber.datatable.DataTable dataTable) {
	Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
	
	registerpage.enterfirstName(dataMap.get("firstName"));
	registerpage.enterlastName(dataMap.get("lastname"));
	registerpage.enteremail(dataMap.get("email"));
	registerpage.entertelephone(dataMap.get("telephone"));
	registerpage.enterpassword(dataMap.get("password"));
	registerpage.enterconfirmpassword(dataMap.get("password"));
	
    }

    @When("User selects privacy policu")
    public void user_selects_privacy_policu() {
       registerpage.privacyPolicyButton();
    }

    @When("User clicks on continue button")
    public void user_clicks_on_continue_button() {
       registerpage.clickcontinueButton();
    }

    @Then("User account should get created successfully")
    public void user_account_should_get_created_successfully() {
	String successMsg = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	Assert.assertEquals("Your Account Has Been Created!", successMsg);
    }

    @When("User selects yes for newzletter")
    public void user_selects_yes_for_newzletter() {
	registerpage.clicknewsletter();
    }

    @Then("User should get a proper warning about duplicate email")
    public void user_should_get_a_proper_warning_about_duplicate_email() {
       String warningMsg = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
       Assert.assertEquals("Warning: E-Mail Address is already registered!", warningMsg, "The message is not matched");
    }

    @When("User dont enter any details into fields")
    public void user_dont_enter_any_details_into_fields() {
	registerpage.enterfirstName("");
	registerpage.enterlastName("");
	registerpage.enteremail("");
	registerpage.entertelephone("");
	registerpage.enterpassword("");
	registerpage.enterconfirmpassword("");
    }

    @When("clicks on Continue button")
    public void clicks_on_continue_button() {
	registerpage.clickcontinueButton();
    }

    @Then("User should get proper warning messages for every mandatory field")
    public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
        Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),"following Text is not visible");
        Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),"following Text is not visible");
        Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),"following Text is not visible");
        Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),"following Text is not visible");
        Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),"following Text is not visible");
    }

    
    private String generateEmailwitTimeStamp() {

	Date date = new Date();
	String timestamp = date.toString().replace(" ", "_").replace(":", "_");
	return "hello"+timestamp+"@gmail.com";

    }
    

}
