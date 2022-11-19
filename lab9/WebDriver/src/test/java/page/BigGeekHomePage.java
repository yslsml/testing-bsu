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
        searchInput.sendKeys(Keys.ENTER);
        return new BigGeekSearchResultPage(driver);
    }

}
