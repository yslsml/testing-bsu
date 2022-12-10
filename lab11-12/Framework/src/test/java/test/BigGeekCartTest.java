package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BigGeekCartPage;
import page.BigGeekItemPage;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BigGeekCartTest extends CommonConditions {
    public final String PRODUCT_NAME = "Apple iPhone 13 128GB («Тёмная ночь» | Midnight)";
    public final String PRODUCT_PRICE = "57 990 ";
    public final String APPROVAL_REMOVAL_MESSAGE = "Apple iPhone 13 128GB («Тёмная ночь» | Midnight) — товар удалён из корзины";
    public final String INVALID_PROMO_CODE = "abcdef";
    public final String INVALID_PROMO_CODE_MESSAGE = "Сертификат недействителен";

    @BeforeMethod(onlyForGroups = {"addedItemToCartPreconditionIsNeeded"})
    public void addItemToCart() {
        new BigGeekItemPage(driver)
                .openPage()
                .addItemToCart();
    }

    @Test
    public void addItemToCartTest() {
        new BigGeekItemPage(driver)
                .openPage()
                .addItemToCart();

        BigGeekCartPage bigGeekCartPage = new BigGeekCartPage(driver);
        String addedProductName = bigGeekCartPage
                .openPage()
                .getProductName();
        String addedProductPrice = bigGeekCartPage
                .getProductPrice();

        assertThat(addedProductName, is(equalTo(PRODUCT_NAME)));
        assertThat(addedProductPrice, is(equalTo(PRODUCT_PRICE)));
    }

    @Test(groups = {"addedItemToCartPreconditionIsNeeded"})
    public void removeItemFromCartTest() {
        String messageAfterProductRemoval = new BigGeekCartPage(driver)
                .openPage()
                .removeItemFromCart()
                .getApprovalOfProductRemovalMessage();
        assertThat(messageAfterProductRemoval, is(equalTo(APPROVAL_REMOVAL_MESSAGE)));
    }

    @Test(groups = {"addedItemToCartPreconditionIsNeeded"})
    public void restoreItemToCartTest() {
        BigGeekCartPage bigGeekCartPage = new BigGeekCartPage(driver)
                .openPage()
                .removeItemFromCart()
                .restoreItemToCart();
        String restoredProductName = bigGeekCartPage.getProductName();
        String restoredProductPrice = bigGeekCartPage.getProductPrice();

        assertThat(restoredProductName, is(equalTo(PRODUCT_NAME)));
        assertThat(restoredProductPrice, is(equalTo(PRODUCT_PRICE)));
    }

    @Test(groups = {"addedItemToCartPreconditionIsNeeded"})
    public void useInvalidPromoCodeTest() {
        String promoCodeStatusMessage = new BigGeekCartPage(driver)
                .openPage()
                .enterPromoCode(INVALID_PROMO_CODE)
                .getPromoCodeStatusMessage();
        Assert.assertTrue(promoCodeStatusMessage.contains(INVALID_PROMO_CODE_MESSAGE),
                "The error message of using invalid promo code was not shown!");
    }
}
