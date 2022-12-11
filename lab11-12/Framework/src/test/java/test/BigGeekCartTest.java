package test;

import model.Product;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BigGeekCartPage;
import page.BigGeekItemPage;
import service.ProductCreator;
import service.TestDataReader;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BigGeekCartTest extends CommonConditions {
    public final String APPROVAL_REMOVAL_MESSAGE = TestDataReader.getTestData("testdata.approval_removal_message");
    public final String INVALID_PROMO_CODE = TestDataReader.getTestData("testdata.invalid_promo_code");
    public final String INVALID_PROMO_CODE_MESSAGE = TestDataReader.getTestData("testdata.invalid_promo_code_message");

    @BeforeMethod(onlyForGroups = {"addedItemToCartPreconditionIsNeeded"})
    public void addItemToCart() {
        new BigGeekItemPage(driver)
                .openPage()
                .addItemToCart();
    }

    @Test
    public void addItemToCartTest() {
        Product testProduct = ProductCreator.withCredentialsFromProperty();

        new BigGeekItemPage(driver)
                .openPage()
                .addItemToCart();

        BigGeekCartPage bigGeekCartPage = new BigGeekCartPage(driver);
        String addedProductName = bigGeekCartPage
                .openPage()
                .getProductName();
        String addedProductPrice = bigGeekCartPage
                .getProductPrice();

        assertThat(addedProductName, is(equalTo(testProduct.getName())));
        assertThat(addedProductPrice, is(equalTo(testProduct.getPrice())));
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
        Product testProduct = ProductCreator.withCredentialsFromProperty();

        BigGeekCartPage bigGeekCartPage = new BigGeekCartPage(driver)
                .openPage()
                .removeItemFromCart()
                .restoreItemToCart();
        String restoredProductName = bigGeekCartPage.getProductName();
        String restoredProductPrice = bigGeekCartPage.getProductPrice();

        assertThat(restoredProductName, is(equalTo(testProduct.getName())));
        assertThat(restoredProductPrice, is(equalTo(testProduct.getPrice())));
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
