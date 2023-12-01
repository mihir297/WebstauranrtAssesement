package example.test;

import Pages.CartPage;
import Pages.HomePage;
import Pages.SearchResultPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WebstaurantProductSearchTest {
    private WebDriver driver;

    @Before
    public void setUp() {

        driver = WebDriverManager.chromedriver().create();
    }

    @Test
    public void WebstaurantSelenium() throws Exception {
        // 1. Go to website
        driver.get("https://www.webstaurantstore.com/");
        driver.manage().window().fullscreen();

//        // 2. Search for ‘stainless work table’
        HomePage homePage = new HomePage(driver);
        homePage.Search("stainless work table");

        //3. Check the Search result ensuring every Product has the word 'Table' in its title.
       assertTrue("", new SearchResultPage(driver).IsSearchResultCorrect("Table"));

       //4. Add Last Product
        new SearchResultPage(driver).AddLastProductToCart();

        /* 5. Empty Cart */
        new CartPage(driver).EmptyCart();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
