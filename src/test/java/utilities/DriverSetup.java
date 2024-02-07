package utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverSetup {
    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        DriverSetup.LOCAL_DRIVER.set(driver);
    }

    public static WebDriver getDriver(){
        return LOCAL_DRIVER.get();
    }

    public static WebDriver createBrowser(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        }
        else {
            throw new RuntimeException("Browser not found! using the given name: " + browserName);
        }
    }

    public static synchronized void setBrowser(String browserName){
        WebDriver driver = createBrowser(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        setDriver(driver);
    }

    public static synchronized void quitBrowser(Scenario scenario){
        takeScreenShot(scenario);
        getDriver().quit();
    }
    public static void takeScreenShot(Scenario scenario){
        try {
            String screenshotName= scenario.getName().replace("", "_");
            if(scenario.isFailed()) {
                scenario.log("this is my failure message");
                TakesScreenshot ts = (TakesScreenshot)getDriver();
                byte[]screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
