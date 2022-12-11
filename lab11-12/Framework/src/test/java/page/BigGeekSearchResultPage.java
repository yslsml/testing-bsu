package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaitUtils;

import java.util.*;

public class BigGeekSearchResultPage extends AbstractPage {

    private final String productOfSpecificSearchResultXpath = "//div[@class=\"digi-product digi-has-not-color\"]";
    private final String productsSearchResultListXpath = "//div[@class=\"digi-products-grid digi-products-grid_horde\"]/div";
    private final String emptySearchResultMessageXpath = "//div[@class=\"digi-empty__wrapper\"]/p";
    private final String obtainedProductNameXpath = "//a[@class=\"digi-product__label\"]";
    private final String obtainedProductPriceXpath = "//div[@class=\"digi-product__price\"]";
    private final String priceRangeFiltersXpath = "//input[@class=\"digi-facet-slider__input\"]";

    @FindBy(xpath = productsSearchResultListXpath)
    private List<WebElement> productsSearchResultList;

    @FindBy(xpath = emptySearchResultMessageXpath)
    private WebElement emptySearchResultMessage;

    @FindBy(xpath = obtainedProductNameXpath)
    private WebElement obtainedProductName;

    @FindBy(xpath = obtainedProductPriceXpath)
    private WebElement obtainedProductPrice;

    @FindBy(xpath = priceRangeFiltersXpath)
    private List<WebElement> priceRangeFilters;

    public BigGeekSearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public List<String> getSearchedItemsText() {
        ArrayList<String> itemTextList = new ArrayList<>();
        for (WebElement productItem : productsSearchResultList) {
            itemTextList.add(productItem.getText());
        }
        return itemTextList;
    }

    public String getProductName() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(obtainedProductNameXpath, driver);
        return obtainedProductName.getText();
    }

    public String getProductPrice() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(obtainedProductPriceXpath, driver);
        return obtainedProductPrice.getText().substring(0, obtainedProductPrice.getText().length() - 1);
    }

    public String getEmptySearchResultMessage() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(emptySearchResultMessageXpath, driver);
        return emptySearchResultMessage.getText();
    }

    public BigGeekSearchResultPage enterPriceRange(String priceRange) {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(priceRangeFiltersXpath, driver);
        for (WebElement priceRangeFilter : priceRangeFilters) {
            int numberOfDigitsToClean = 7;
            for (int i = 0; i < numberOfDigitsToClean; i++) {
                priceRangeFilter.sendKeys(Keys.BACK_SPACE);
            }
            priceRangeFilter.sendKeys(priceRange);
            priceRangeFilter.sendKeys(Keys.ENTER);
        }

        WaitUtils.waitForNumberOfElementsLocatedByXpathToBe(productOfSpecificSearchResultXpath, 1, driver);
        return this;
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}

