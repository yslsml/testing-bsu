package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BigGeekHomePage;
import page.BigGeekItemPage;

public class BigGeekTest {

    public static String SEARCH_QUERY_FOR_COMMON_RESULTS = "iphone 13 mini pink 512GB";
    public static String EMPTY_MESSAGE = "";

    private WebDriver chromeDriver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }


    @Test
    public void handleCommonSearchResultTest() {
        int numberOfCommonSearchResults = new BigGeekHomePage(chromeDriver)
                .openPage()
                .searchForTerms(SEARCH_QUERY_FOR_COMMON_RESULTS)
                .numberOfCommonSearchResults();
        Assert.assertTrue(numberOfCommonSearchResults > 0,
                "Search result for \"" + SEARCH_QUERY_FOR_COMMON_RESULTS + "\" is empty!");
    }

    @Test
    public void addItemToCartTest() {
        WebElement addedItemToCartResultMessage = new BigGeekItemPage(chromeDriver)
                .openPage()
                .addItemToCart()
                .getAddedItemToCartConfirmMessage();
        Assert.assertNotEquals(addedItemToCartResultMessage.getText(), EMPTY_MESSAGE, "Item is not added to the cart!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        chromeDriver.quit();
        chromeDriver = null;
    }
}