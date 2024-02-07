package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.DriverSetup.getDriver;

public class Landing_Page_Verification {
    LoginPage loginPage = new LoginPage();
    @Given("I am in Chrome Browser")
    public void i_am_in_Chrome_Browser() {
        String className = getDriver().getClass().toString(); //class org.openqa.selenium.chrome.ChromeDriver
        className = className.substring( className.lastIndexOf(".") +1);
        assertEquals("ChromeDriver", className);
    }

    @When("I navigate landing page url")
    public void i_navigate_landing_page_url() {
        loginPage.navigateURL();
    }

    @Then("The Landing Page appear")
    public void the_Landing_Page_appear() {
        assertEquals(loginPage.baseURL, loginPage.getCurrentURL());
        assertEquals("Swag Labs", loginPage.getloginLogo());
    }
}
