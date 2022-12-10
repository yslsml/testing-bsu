package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.BigGeekHomePage;
import page.BigGeekSearchResultPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class BigGeekSearchTest extends CommonConditions {
    public static String SEARCH_QUERY_FOR_COMMON_RESULTS = "iphone 13 mini pink 512GB";
    public static String INVALID_SEARCH_QUERY = "fjfjgf";
    public static String SEARCH_QUERY_FOR_SPECIFIC_SEARCH = "apple";
    public static String SUBSTRING_OF_SEARCHED_ITEMS = "Apple iPhone 13";
    public static String EMPTY_SEARCH_RESULT_MESSAGE = "По вашему запросу ничего не найдено";
    public static String PRICE_FOR_SPECIFIC_SEARCH = "199 ";
    public static String PRODUCT_NAME_FOR_SPECIFIC_SEARCH = "Переходник для адаптера питания Apple с евро-вилкой";

    @Test
    public void handleCommonSearchResultTest() {
        List<String> textOfSearchedItems = new BigGeekHomePage(driver)
                .openPage()
                .searchForTerms(SEARCH_QUERY_FOR_COMMON_RESULTS)
                .getSearchedItemsText();

        assertThat(textOfSearchedItems, everyItem(containsString(SUBSTRING_OF_SEARCHED_ITEMS)));
    }

    @Test
    public void handleIncorrectSearchQueryResultTest() {
        String searchResultMessage = new BigGeekHomePage(driver)
                .openPage()
                .searchForTerms(INVALID_SEARCH_QUERY)
                .getEmptySearchResultMessage();

        Assert.assertTrue(searchResultMessage.contains(EMPTY_SEARCH_RESULT_MESSAGE),
                "The empty result message was not shown!");
    }

    @Test
    public void handleSpecificSearchResultTest() {
        BigGeekSearchResultPage bigGeekSearchResultPage = new BigGeekHomePage(driver)
                .openPage()
                .searchForTerms(SEARCH_QUERY_FOR_SPECIFIC_SEARCH)
                .enterPriceRange(PRICE_FOR_SPECIFIC_SEARCH);

        String obtainedProductName = bigGeekSearchResultPage
                .getProductName();
        String obtainedProductPrice = bigGeekSearchResultPage
                .getProductPrice();

        assertThat(obtainedProductName, is(equalTo(PRODUCT_NAME_FOR_SPECIFIC_SEARCH)));
        assertThat(obtainedProductPrice, is(equalTo(PRICE_FOR_SPECIFIC_SEARCH)));
    }

}
