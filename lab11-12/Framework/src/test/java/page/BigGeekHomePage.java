package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BigGeekHomePage extends AbstractPage {
    public static String BIG_GEEK_HOME_PAGE_URL = "https://biggeek.ru";

    private final String searchInputXpath = "//*[@id=\"search-header-middle\"]";

    @FindBy(xpath = searchInputXpath)
    private WebElement searchInput;

    public BigGeekHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public BigGeekSearchResultPage searchForTerms(String searchQuery) {
        searchInput.sendKeys(searchQuery);
        searchInput.sendKeys(Keys.ENTER);
        return new BigGeekSearchResultPage(driver);
    }

    @Override
    public BigGeekHomePage openPage() {
        driver.get(BIG_GEEK_HOME_PAGE_URL);
        return this;
    }
}
