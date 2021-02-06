package com.qa25.skinnyties.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperBase {
    WebDriver driver;

    public HelperBase(WebDriver driver){
        this.driver = driver;
    }

    public void click(By locator){
        waitUntilElementIsClicable(locator).click();
    }

    public WebElement waitUntilElementIsClicable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public String getText(By locator) {
        return findElementOnPage(locator).getText();
    }

    public WebElement findElementOnPage(By locator){
        return driver.findElement(locator);
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        if(text != null){
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void clickEnterKey(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void openMainPage() {
        driver.navigate().to("https://skinnyties.com/");
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public List<WebElement> getItemsList(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return element;
    }

}
