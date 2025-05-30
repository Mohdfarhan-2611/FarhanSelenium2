package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;

public class Alerts {

    @Test
    public void AlertExample() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement simpleAlert = driver.findElement(By.id("alertBtn"));
        simpleAlert.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();


        WebElement confirmationAlert = driver.findElement(By.id("confirmBtn"));
        confirmationAlert.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        confirmationAlert.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();


        WebElement promptAlert = driver.findElement(By.id("promptBtn"));
        promptAlert.click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("My name is Farhan");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();





    }

}
