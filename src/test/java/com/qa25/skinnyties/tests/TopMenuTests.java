package com.qa25.skinnyties.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopMenuTests extends TestBase {

    @BeforeMethod
    public void insurePreconditions(){
        if(!mainPage.isMainPageOpened()){
            mainPage.openMainPage();
        }
    }

    @Test(priority = 0)
    public void verifyRetroProductsPriceTest() throws InterruptedException {

        //In the top menu select Pattern->Retro
        mainPage.clickPatternRetro();

        //Scroll the page down to be sure all the products are presented on the page
        productPage.scrollPageDown();

        //Verify the sum for all products is larger then $20
        double resultSum = productPage.countSumAllProducts();
        Assert.assertTrue((resultSum > 20), "Sum of all the displayed products is larger than $20 and  equals " + resultSum + "!!!");

    }

    @Test(priority = 1)
    public void verifyTieBarsPriceTest() throws InterruptedException {

        //In the top menu select Tie Bars
        mainPage.clickTieBars();

        //Scroll the page down to be sure all the products are presented on the page
        productPage.scrollPageDown();

        //Verify the sum for all products is larger then $20
        double resultSum = productPage.countSumAllProducts();

        Assert.assertTrue((resultSum > 20), "Sum of all the displayed products is larger than $20 and  equals " + resultSum + "!!!");

    }

}
