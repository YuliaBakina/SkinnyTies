package com.qa25.skinnyties.tests;

import com.qa25.skinnyties.fw.MainPage;
import com.qa25.skinnyties.fw.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;
    String baseURL = "https://skinnyties.com/";
    MainPage mainPage;
    ProductPage productPage;

    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeMethod(alwaysRun = true)
    public void init() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseURL);

        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void stop() {
        driver.quit();
    }


    @BeforeMethod(alwaysRun = true)
    public void startTest(Method m)
    {
        logger.info("Start test: " + m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result){

        if(result.isSuccess()){
            logger.info("Test result: PASSED");
        }else{
            logger.error("Test result: FAILED");
        }

        logger.info("Stop test: " + result.getMethod().getMethodName());
        logger.info("======================================================");
    }

}
