package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BigGeekHomePage;

public class BigGeekTest {

    public static String SEARCH_QUERY_FOR_COMMON_RESULTS = "iphone 13 mini pink 512GB";
    private WebDriver chromeDriver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }


    @Test
    public void handleCommonSearchResult() {
        int numberOfCommonSearchResults = new BigGeekHomePage(chromeDriver)
                .openPage()
                .searchForTerms(SEARCH_QUERY_FOR_COMMON_RESULTS)
                .numberOfCommonSearchResults();
        Assert.assertTrue(numberOfCommonSearchResults > 0,
                "Search result for \"" + SEARCH_QUERY_FOR_COMMON_RESULTS + "\" is empty!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        chromeDriver.quit();
        chromeDriver = null;
    }
}
