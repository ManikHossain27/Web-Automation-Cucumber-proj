package pages;

import base.Base;
import org.openqa.selenium.By;

public class LoginPage extends Base {
    public  String baseURL = "https://www.saucedemo.com/";
    public By Login_Logo = By.xpath("//div[@class='login_logo']");
    public By userName = By.xpath("//input[@id='user-name']");
    public By password = By.xpath("//input[@id='password']");
    public By errorMsg = By.xpath("//h3[@data-test='error']");
    public By loginButton = By.xpath("//input[@id='login-button']");

    //navigate to the url
    public void navigateURL(){
        navigate(baseURL);
    }
    //Get Login Logo
    public String getloginLogo(){
        return getText(Login_Logo);
    }
    //Enter UserName
    public void enterUserName(String name){
        sendKeys(userName, name);
    }
    //Enter Password
    public void enterPassword(String pass){
        sendKeys(password, pass);
    }
    //Get Error Message
    public String errorMessage(By errorMsg){
       return getText(errorMsg);
    }
    //Click on Login Button
    public void clickOnLogin(){
        click(loginButton);
    }

}
