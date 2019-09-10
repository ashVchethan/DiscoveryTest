package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    //this class has all reusable methods and we need to always extend this class in all logic writing classes
    public static long wait=60;
    public static WebDriver driver;

    //This javascript function will scroll down to particular element
    public static void scrollToElement(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static boolean isElementVisible(WebElement element) {
        try{
            if(element.isDisplayed())
                return true;
            return false;
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            return false;
        }
    }

    //this is explicit function for any element
    public static void waitUntilElementIsVisible(WebElement element){
        WebDriverWait wwait = new WebDriverWait(driver, wait);
        wwait.until(ExpectedConditions.visibilityOf(element));
    }


}
