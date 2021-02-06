package com.qa25.skinnyties.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends HelperBase{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openSearchBox() {
        click(By.xpath("//li//a [@href='/search']"));
    }

    public void typeStringForSearch(String strForSearch) {
        type(By.name("q"),strForSearch);
        clickEnterKey(By.name("q"));
    }

    public void clickSearchResult() {
        click(By.cssSelector("[class='ProductItem ']"));
    }


    public boolean isMainPageOpened() {
        return isElementPresent(By.cssSelector("[id='section-slideshow']"));
    }

    public void clickPatternRetro() {
        WebElement menuPattern = driver.findElement(By.xpath("//a[contains(text(),'Pattern')]"));
        Actions build = new Actions(driver);
        build.moveToElement(menuPattern).build().perform();
        click(By.xpath("//ul//li//a[@href='/collections/retro']"));
    }

    public void clickTieBars() {
        click(By.xpath("//li//a[contains(text(),'Tie Bars')]"));
    }
}
