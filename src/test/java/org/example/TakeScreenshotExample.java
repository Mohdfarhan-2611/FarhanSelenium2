package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeScreenshotExample {


    @Test
    public void ScreenshotExample()  {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");


        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourcelocation = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"/Screenshots.png";
        File destlocation = new File(path);
        try{
            FileUtils.copyFile(sourcelocation, destlocation);
            System.out.println("Screenshot saved at: " + path);
        }catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }



    }


}
