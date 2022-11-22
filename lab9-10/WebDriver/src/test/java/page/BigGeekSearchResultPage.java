package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BigGeekSearchResultPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"digi-shield\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div")
    private List<WebElement> productsSearchResultList;

    public BigGeekSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfCommonSearchResults() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"digi-shield\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div")));
        return productsSearchResultList.size();
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}

