package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigGeekCartPage extends AbstractPage {
    public static String BIG_GEEK_CART_PAGE_URL = "https://biggeek.ru/cart";

    private final String closeModalWarningWindowButtonXpath = "//button[@class=\"we-closed-modal__close\"]";
    private final String productNameXpath = "//a[@class=\"product-cart__link\"]";
    private final String productPriceXpath = "//p[@class=\"product-cart__count\"]/b";
    private final String removeItemButtonXpath = "//button[@class=\"product-cart__remove-button\"]";
    private final String approvalOfProductRemovalMessageXpath = "//p[@class=\"product-cart__text\"]";
    private final String restoreItemButtonXpath = "//button[@class=\"product-cart__add-button\"]";
    private final String promoCodeInputXpath = "//input[@class=\"complete-cart__input\"]";
    private final String promoCodeSubmitButtonXpath = "//button[@class=\"complete-cart__coupon-submit\"]";
    private final String promoCodeStatusMessageXpath = "//div[@class=\"order-cart__complete complete-cart\"]";

    @FindBy(xpath = closeModalWarningWindowButtonXpath)
    private WebElement closeModalWarningWindowButton;

    @FindBy(xpath = productNameXpath)
    private WebElement productName;

    @FindBy(xpath = productPriceXpath)
    private WebElement productPrice;

    @FindBy(xpath = removeItemButtonXpath)
    private WebElement removeItemButton;

    @FindBy(xpath = approvalOfProductRemovalMessageXpath)
    private WebElement approvalOfProductRemovalMessage;

    @FindBy(xpath = restoreItemButtonXpath)
    private WebElement restoreItemButton;

    @FindBy(xpath = promoCodeInputXpath)
    private WebElement promoCodeInput;

    @FindBy(xpath = promoCodeSubmitButtonXpath)
    private WebElement promoCodeSubmitButton;

    @FindBy(xpath = promoCodeStatusMessageXpath)
    private WebElement promoCodeStatusMessage;

    public BigGeekCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getProductName() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(productNameXpath)));
        return productName.getText();
    }

    public String getProductPrice() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(productPriceXpath)));
        return productPrice.getText().substring(0, productPrice.getText().length() - 1);
    }

    public BigGeekCartPage removeItemFromCart() {
        removeItemButton.click();
        return this;
    }

    public String getApprovalOfProductRemovalMessage() {
        return approvalOfProductRemovalMessage.getText();
    }

    public BigGeekCartPage restoreItemToCart() {
        restoreItemButton.click();
        return this;
    }

    public BigGeekCartPage enterPromoCode(String promoCode) {
        promoCodeInput.sendKeys(promoCode);
        promoCodeSubmitButton.click();
        return this;
    }

    public String getPromoCodeStatusMessage() {
        return promoCodeStatusMessage.getText();
    }

    @Override
    public BigGeekCartPage openPage() {
        driver.get(BIG_GEEK_CART_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(closeModalWarningWindowButtonXpath)));
        closeModalWarningWindowButton.click();
        return this;
    }

}
