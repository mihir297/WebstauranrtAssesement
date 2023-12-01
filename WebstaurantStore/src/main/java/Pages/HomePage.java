package Pages;

import Utility.DriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;

public class HomePage {
    WebDriver Driver;
    public HomePage(WebDriver driver) throws Exception {
        Driver =driver;
    }

     By searchBoxLocator = By.xpath("(//input[@id='searchval'])[2]");

    public WebElement SearchBox = DriverUtility.GetElement(Driver,searchBoxLocator,20);
    public  void Search(String searchtext)
    {
        SearchBox.clear();
        SearchBox.sendKeys(searchtext);
        SearchBox.submit();
    }
}
