package com.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitiateDriver {
    private WebDriver driver;

    public InitiateDriver(){
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();

    }



    public WebDriver getDriver()
    {
        if(driver==null)
            throw new RuntimeException("Driver has not been Instantiated or exe files are missing");

        return driver;
    }



}
