package com.testFramework.core;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver driver;

    @BeforeClass
    public static void beforeSuite() {
        try {
            String driverPath = "..\\TestFramework\\src\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert driver != null;
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void maximiseWindow (WebDriver driver) {
        driver.manage().window().maximize();
    }

    protected void implicitWait (WebDriver driver, int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS) ;
    }

    @AfterClass
    public static void afterSuite() {
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }

}
