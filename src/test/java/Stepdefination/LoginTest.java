package Stepdefination;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.HomePage;
import Pages.LoginPage;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
    
    WebDriver driver = DriverFactory.getDriver();//Own Implementation
    HomePage homepage = new HomePage(driver);
    LoginPage loginpage = new LoginPage(driver);

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
	homepage.clickonMyAccount();
	homepage.clickonLoginOption();
    
    }

    @When("^User Enters valid email address (.+) into email field$")
    public void user_enters_valid_email_address_into_email_field1(String emailText) {
        loginpage.emailtextfield(emailText);
    }

    @When("^User has Entered valid password (.+) into password field$")
    public void user_has_entered_valid_password_into_password_field(String PasswordText) {
	 loginpage.passwordtextfield(PasswordText);
    }

    @When("Clicks on Login button")
    public void clicks_on_login_button() {
         loginpage.clicklognbutton();
    }

    @Then("User gets successfully logged in")
    public void user_gets_successfully_logged_in() {
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
    }
    
    @When("User enters invalid email address into email field")
    public void user_enters_invalid_email_address_into_email_field() {
	loginpage.emailtextfield(generateEmailwitTimeStamp());
    }
    

    @When("User enters invalid password {string} into password filed")
    public void user_enters_invalid_password_into_password_filed(String passowordText) {
	 loginpage.passwordtextfield(passowordText);
    }

    @When("clicks on login button")
    public void clicks_on_login_button1() {
	 loginpage.clicklognbutton();
    }

    @Then("User should get a warning message about credentials mismatch")
    public void user_should_get_a_warning_message_about_credentials_mismatch() {
       String ActualMsg = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
       Assert.assertEquals(ActualMsg, "Warning: No match for E-Mail Address and/or Password.", "The Required Message is Not Displayed");
    }

    @When("User enters valid email address {string} into email field")
    public void user_enters_valid_email_address_into_email_field(String emailText) {
	loginpage.emailtextfield(emailText);
    }

    @When("User enters valid password {string} into password filed")
    public void user_enters_valid_password_into_password_filed(String passwordText) {
	loginpage.passwordtextfield(passwordText);
    }

    @When("User do not enters any email address into email field")
    public void user_do_not_enters_any_email_address_into_email_field() {
	loginpage.emailtextfield("");
    }

    @When("User do not enters any password into password field")
    public void user_do_not_enters_any_password_into_password_field() {
	loginpage.passwordtextfield("");
    }
    
    private String generateEmailwitTimeStamp() {

	Date date = new Date();
	String timestamp = date.toString().replace(" ", "_").replace(":", "_");
	return "hello"+timestamp+"@gmail.com";

    }
}
