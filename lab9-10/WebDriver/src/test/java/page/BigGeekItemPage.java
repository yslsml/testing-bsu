package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigGeekItemPage extends AbstractPage{
    public static String BIG_GEEK_ITEM_PAGE_URL = "https://biggeek.ru/products/apple-iphone-13-128gb-midnight";

    @FindBy(xpath = "/html/body/div[1]/main/div[2]/section[1]/div/div/div[2]/div/div[2]/div/div[4]/a")
    private WebElement addToCartButton;

    @FindBy(xpath = "/html/body/div[2]/div/div")
    private WebElement modalCartWindow;

    public BigGeekItemPage(WebDriver driver) {
        super(driver);
    }

    public BigGeekItemPage addItemToCart() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/main/div[2]/section[1]/div/div/div[2]/div/div[2]/div/div[4]/a")));
        addToCartButton.click();
        return this;
    }

    public boolean isModalCartWindowDisplayed() {
        WebElement modalCartWindow = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("cart-modal__product-wrap")));
        return modalCartWindow.isDisplayed();
    }

    @Override
    public BigGeekItemPage openPage() {
        driver.get(BIG_GEEK_ITEM_PAGE_URL);
        return this;
    }

}
