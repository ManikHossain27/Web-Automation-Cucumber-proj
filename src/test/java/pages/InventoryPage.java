package pages;

import base.Base;
import org.openqa.selenium.By;

public class InventoryPage extends Base {
    public String inventoryPageURL = "https://www.saucedemo.com/inventory.html";
    public By inventoryAppLogo = By.xpath("//div[@class='app_logo']");


    //Get Inventory page logo
    public String getInventoryAppLogo(){
        return getText(inventoryAppLogo);
    }
}
