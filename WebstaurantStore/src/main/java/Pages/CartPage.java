package Pages;
import Dialogs.EmptyCartDialog;
import Utility.DriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
public class CartPage {

    WebDriver Driver;
    public CartPage(WebDriver driver) throws Exception {
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
