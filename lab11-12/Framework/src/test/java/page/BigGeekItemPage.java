package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaitUtils;

public class BigGeekItemPage extends AbstractPage{
    public static String BIG_GEEK_ITEM_PAGE_URL = "https://biggeek.ru/products/apple-iphone-13-128gb-midnight";

    private final String addToCartButtonXpath = "//a[@class=\"prod-info-price__cart-btn button cart-modal-open\"]";

    @FindBy(xpath = addToCartButtonXpath)
    private WebElement addToCartButton;

    public BigGeekItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public BigGeekItemPage addItemToCart() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(addToCartButtonXpath, driver);
        addToCartButton.click();
        return this;
    }

    @Override
    public BigGeekItemPage openPage() {
        driver.get(BIG_GEEK_ITEM_PAGE_URL);
        return this;
    }

}
