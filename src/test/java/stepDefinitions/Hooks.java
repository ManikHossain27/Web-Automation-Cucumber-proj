package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static utilities.DriverSetup.quitBrowser;
import static utilities.DriverSetup.setBrowser;

public class Hooks {
    private static String browserName = System.getProperty("browser", "chrome");

    @Before
    public void setup(){
        setBrowser(browserName);
    }

    @After
    public void tearDown(Scenario scenario){
        quitBrowser(scenario);
    }
}
