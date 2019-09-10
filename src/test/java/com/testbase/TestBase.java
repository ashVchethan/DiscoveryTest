package com.testbase;

import com.utils.Base;
import com.utils.InitiateDriver;
import com.utils.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        InitiateDriver initiateDriver = new InitiateDriver();
        driver = initiateDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Base.driver = driver;
        driver.get("https://go.discovery.com/");
        driver.manage().window().maximize();
    }
    @AfterSuite(alwaysRun = true)
        public void quitbrowser(){
            driver.quit();
        }
    }
