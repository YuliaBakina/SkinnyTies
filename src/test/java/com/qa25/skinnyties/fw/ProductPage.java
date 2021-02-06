package com.qa25.skinnyties.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductPage extends HelperBase{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public Logger logger = LoggerFactory.getLogger(ProductPage.class);

    public String getProductPrice() {
        return getText(By.cssSelector("[class='ProductMeta__PriceList Heading']"));
    }

    public String getProductDescription() {
        return getText(By.cssSelector("[class='Rte']"));
    }

    public double countSumAllProducts() {
        double resultSum = 0;

        List<WebElement> productList = getItemsList(By.xpath("//div [@class='CollectionInner__Products']//div [@class='ProductItem__Wrapper']"));
        for(WebElement e : productList){
            String sum = e.findElement(By.cssSelector("[class='ProductItem__Price Price Text--subdued']")).getText().substring(1).trim();
            resultSum = resultSum + Double.parseDouble(sum);
        }

        logger.info("    --> Total number of items are: " + productList.size());
        logger.info("    --> Total sum of all items are: $" + resultSum);

        return resultSum;
    }

    public void scrollPageDown() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 1000)");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, 0)");
    }

}
