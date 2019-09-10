package com.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitiateDriver {
    private WebDriver driver;

    public InitiateDriver(){
        //To launch the  chrome browser, no need to exe of remote server to be running
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();

    }



    public WebDriver getDriver()
    {
        //custom exception if driver is not initiated
        if(driver==null)
            throw new RuntimeException("Driver has not been Instantiated or exe files are missing");

        return driver;
    }



}
