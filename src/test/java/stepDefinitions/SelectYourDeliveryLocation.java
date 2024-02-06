package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

public class SelectYourDeliveryLocation {
    HomePage homePage = new HomePage();

    @Given("I am in landing page")
    public void i_am_in_landing_page() {
        homePage.navigateURL(homePage.baseURL);
        Assert.assertEquals(homePage.getCurrentURL(), "https://www.shwapno.com/");
        Assert.assertEquals(homePage.getTitle(), "Shwapno Online Grocery Shopping in Dhaka, Chattogram, Cumilla & Sylhet");
    }

    @Then("I select my city")
    public void i_select_my_city() {
        homePage.selectByVisibleText(homePage.selectYourCity, "Dhaka");
    }

    @Then("I select my area")
    public void i_select_my_area() {
        homePage.selectByValue(homePage.selectYourArea,"26346");
    }

    @Then("I click on submit button")
    public void i_click_on_submit_button() {
        homePage.click(homePage.submitBtn);
    }

    @Then("I see my area name")
    public void i_see_my_area_name() {
        Assert.assertEquals(homePage.getText(homePage.selectedAreaName), "WARI");
    }
}
