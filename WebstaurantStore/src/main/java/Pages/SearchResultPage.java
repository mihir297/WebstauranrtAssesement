package Pages;

import Utility.DriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;

import java.util.List;

public class SearchResultPage {
    WebDriver Driver;
    public SearchResultPage(WebDriver driver) throws Exception {
        Driver =driver;
    }

    public By searchResults = By.xpath("//span[@data-testid='itemDescription']");
    public List<WebElement> SearchItemDescriptions = DriverUtility.GetElements(Driver,searchResults,20);

    By _NavigationLastPage =
            By.xpath("//nav[@aria-label='pagination']" +
                    "//a[contains(@aria-label,'last page')]");
    By _NavigationPage(String pageNumber){
       return By.xpath("//nav[@aria-label='pagination']" +
                "//a[contains(@aria-label,'page') and text()='"+pageNumber+"']");
    }

    By _ProductNames = By.xpath("//span[@data-testid=" +
            "'itemDescription']");
    By _ProductAddToCartButtons = By.xpath("//input[@data-testid=" +
            "'itemAddCart']");
    By _ViewCartButton = By.xpath("//div[@class='notification__content']" +
            "//a[text()='View Cart']");


    public WebElement NavigationLastPage =
            DriverUtility.GetElement(Driver,_NavigationLastPage,20);
    public WebElement NavigationPage(String pageNumber) throws Exception {
        return  DriverUtility.GetElement(Driver, _NavigationPage(pageNumber), 20);
    }

    public List<WebElement> ProductNames =
            DriverUtility.GetElements(Driver, _ProductNames, 20);
    public List<WebElement> ProductAddToCartButtons =
            DriverUtility.GetElements(Driver, _ProductAddToCartButtons, 20);
    public WebElement ViewCartButton =
            DriverUtility.GetElement(Driver, _ViewCartButton, 20);

    public int GetTotalPageInNavigation()
    {
        return Integer.parseInt(
                NavigationLastPage.getText().trim());
    }
    public void NavigateAllPages() throws Exception {
        int totalPage = GetTotalPageInNavigation();
        for (int i = 1; i <= totalPage; i++)
        {
            NavigateToPageNumber(i);
        }
    }

    private void NavigateToPageNumber(int pageNumber) throws Exception {
        var navigationPage =DriverUtility.GetElement(Driver,
                _NavigationPage(Integer.toString(pageNumber)), 20);
        navigationPage.click();
        DriverUtility.WaitForPageLoad(Driver);
    }

    public boolean IsSearchResultCorrect(String searchText) throws Exception {
        var totalPages = GetTotalPageInNavigation();
        for (int i = 1; i <= totalPages; i++)
        {
            NavigateToPageNumber(i);
            if (DoAllProductsContainText(searchText))
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    private boolean DoAllProductsContainText(
            String searchText)
    {
        for (int i = 0; i < ProductNames.size(); i++)
        {
            if (ProductNames.get(i).getText().contains(searchText))
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    public void NavigateToLastPage() throws Exception {
        NavigateToPageNumber(GetTotalPageInNavigation());
    }
    public void AddLastProductToCart()
    {
        ProductAddToCartButtons.getLast().click();
    }

    public void ViewCart()
    {
        ViewCartButton.click();
    }
}
