package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigGeekHomePage extends AbstractPage {
    public static String BIG_GEEK_HOME_PAGE_URL = "https://biggeek.ru";

    @FindBy(xpath = "//*[@id=\"digi-shield\"]/div[3]/div/div/div[2]/div/div[3]/button")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/div[1]/main/div[4]/div/button")
    private WebElement closeModelWindowButton;

    @FindBy(xpath = "//*[@id=\"search-header-middle\"]")
    private WebElement searchInput;

    public BigGeekHomePage(WebDriver driver) {
        super(driver);
    }

    public BigGeekHomePage openPage() {
        driver.get(BIG_GEEK_HOME_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/main/div[4]/div/button")));
        closeModelWindowButton.click();
        return this;
    }

    public BigGeekSearchResultPage searchForTerms(String searchQuery) {
        searchInput.sendKeys(searchQuery);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"digi-shield\"]/div[3]/div/div/div[2]/div/div[3]/button")));
        searchButton.click();
        return new BigGeekSearchResultPage(driver);
    }

}
