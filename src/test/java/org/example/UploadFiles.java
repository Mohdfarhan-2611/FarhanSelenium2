package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFiles {


    @Test
    public void UploadFileExample() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement chooseFiles = driver.findElement(By.xpath("//input[@id='singleFileInput']"));
        chooseFiles.sendKeys("C:/Users/mhdfa/Downloads/Setup_Java_Git_GitHub_Guide.docx");

        WebElement uploadsingleFiles = driver.findElement(By.xpath("//button[text()='Upload Single File']"));
        uploadsingleFiles.click();


        WebElement textUploadElement = driver.findElement(By.xpath("//p[@id='singleFileStatus']"));
        String textValue = textUploadElement.getText();
        Assert.assertEquals(textValue,"Single file selected: Setup_Java_Git_GitHub_Guide.docx, Size: 1144578 bytes, Type: application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        System.out.println(textValue);
        System.out.println("Text verified");









    }

}
