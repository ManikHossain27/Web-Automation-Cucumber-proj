package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class Login_Page_Verification {
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    @Given("I am in landing page")
    public void i_am_in_landing_page() {
        loginPage.navigateURL();
        assertEquals(loginPage.baseURL, loginPage.getCurrentURL());
        assertEquals("Swag Labs", loginPage.getloginLogo());
    }

    @When("I enter User Name {string}")
    public void i_enter_User_Name(String string) {
        loginPage.enterUserName(string);
    }

    @When("I enter Password {string}")
    public void i_enter_Password(String string) {
        loginPage.enterPassword(string);
    }

    @When("I click on Login button")
    public void i_click_on_Login_button() {
        loginPage.clickOnLogin();
    }

    @Then("I see the Inventory page")
    public void i_see_the_Inventory_page() {
        assertEquals(inventoryPage.inventoryPageURL, inventoryPage.getCurrentURL());
        assertEquals("Swag Labs", inventoryPage.getInventoryAppLogo());

    }
}
