package Dialogs;
import Utility.DriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
public class BaseAlertDialog {

    WebDriver Driver;
    public BaseAlertDialog(WebDriver driver) throws Exception {
        Driver =driver;
    }

    By _mainModal = By.xpath("//div[@role='alertdialog']");

    public WebElement MainModal =
            DriverUtility.GetElement(Driver, _mainModal, 20);
}
