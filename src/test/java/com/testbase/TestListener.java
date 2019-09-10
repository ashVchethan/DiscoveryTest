package com.testbase;

import com.utils.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener extends Base implements ITestListener {

    String filePath = "./src/main/resources";
    public void onTestStart(ITestResult var1){

    }

    public void onTestSuccess(ITestResult var1){

    }

    public  void onTestFailure(ITestResult result){
        String methodName=result.getName().toString().trim();
        takeScreenShot(methodName, driver);

    }
    public void takeScreenShot(String methodName, WebDriver driver) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name
        try {
            FileHandler.copy(scrFile, new File(filePath+methodName+".png"));
            System.out.println("***Placed screen shot in "+filePath+" ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onTestSkipped(ITestResult var1){

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult var1){

    }

    public void onStart(ITestContext var1){

    }


    public void onFinish(ITestContext var1){

    }
}
