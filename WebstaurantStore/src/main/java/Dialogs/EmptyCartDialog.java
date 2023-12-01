package Dialogs;
import Utility.DriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;

public class EmptyCartDialog {

    WebDriver Driver;
    public EmptyCartDialog(WebDriver driver) throws Exception {
        Driver =driver;
    }

    By _EmptyCartButton =
            By.xpath("//button[text()='Empty Cart']");

    public WebElement EmptyCartButton =
            DriverUtility.GetElement(Driver, _EmptyCartButton, 20);

    public EmptyCartDialog EmptyCart() throws Exception {
        EmptyCartButton.click();
        return new EmptyCartDialog(Driver);
    }
}
