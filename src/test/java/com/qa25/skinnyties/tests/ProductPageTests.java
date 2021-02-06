package com.qa25.skinnyties.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTests extends TestBase {

    String strForSearch = "BLACK POPLIN SKINNY TIE";

    @BeforeMethod
    public void insurePreconditions(){
        if(!mainPage.isMainPageOpened()){
           mainPage.openMainPage();
        }
    }

    @Test
    public void verifyPriceTest(){

        //Open search box
        mainPage.openSearchBox();

        //search for "BLACK POPLIN SKINNY TIE"
        mainPage.typeStringForSearch(strForSearch);

        //Enter to the product page
        mainPage.clickSearchResult();

        //Write the price and tie description
        String  price = productPage.getProductPrice();
        String description = productPage.getProductDescription();

        productPage.logger.info("For the search product: " + strForSearch);
        productPage.logger.info("    --> PRICE: " + price);
        productPage.logger.info("    --> DESCRIPTION: " + description);
        //verify the price is higher then $10
        Assert.assertTrue(verifyPrice(price), "The price is lower then $10 and equals " + price + "!!!");

    }

    private boolean verifyPrice(String price) {
        price = price.substring(1).trim();
        double pr = Double.parseDouble(price);
        return (pr > 10);
    }
}
