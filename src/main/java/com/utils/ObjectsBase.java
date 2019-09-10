package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class ObjectsBase {
    public ObjectsBase(WebDriver driver){
        PageFactory.initElements(driver, this );
    }

}
