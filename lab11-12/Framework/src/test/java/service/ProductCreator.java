package service;

import model.Product;
import org.openqa.selenium.support.PageFactory;

public class ProductCreator {
    public static final String TESTDATA_PRODUCT_NAME = "testdata.product.name";
    public static final String TESTDATA_PRODUCT_PRICE = "testdata.product.price";

    public static Product withCredentialsFromProperty(){
        return new Product(TestDataReader.getTestData(TESTDATA_PRODUCT_NAME),
                TestDataReader.getTestData(TESTDATA_PRODUCT_PRICE));
    }

    public static Product withEmptyName(){
        return new Product("", TestDataReader.getTestData(TESTDATA_PRODUCT_PRICE));
    }

    public static Product withEmptyPrice(){
        return new Product(TestDataReader.getTestData(TESTDATA_PRODUCT_NAME), "");
    }

}
