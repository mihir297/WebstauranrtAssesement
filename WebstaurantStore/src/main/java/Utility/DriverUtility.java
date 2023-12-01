package Utility;

import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DriverUtility {
    public  static WebElement GetElement(WebDriver driver, By locator, int time) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            WebElement element;
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            return  element;
        }
        catch (Exception e)
        {
            throw new Exception("Unable to get element with locator "+locator+".");
        }
    }
    public  static List<WebElement> GetElements(WebDriver driver, By locator, int time) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
             wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        }
        catch (Exception e)
        {
            throw new Exception("Unable to get elements with locator "+locator+".");
        }
        return  driver.findElements(locator);
    }
//    public static void WaitForPageLoad(WebDriver driver)
//    {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        wait.until(x => (JavascriptExecutor)driver)
//                .executeScript("return document.readyState")
//                .Equals("complete");
//    }
   public static void WaitForPageLoad(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Adjust the timeout as needed

    // Wait for JavaScript to indicate that the page has finished loading
    ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        }
    };
    wait.until(pageLoadCondition);
}
}
