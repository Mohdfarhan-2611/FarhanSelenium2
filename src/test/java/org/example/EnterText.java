package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EnterText {

    @Test
    public void enterText(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement name = driver.findElement(By.id("name"));
        System.out.println(name.isEnabled());
        name.sendKeys("Farhan");


        WebElement email = driver.findElement(By.id("email"));
        System.out.println(email.isDisplayed());
        email.sendKeys("mhdfarhan@gmail.com");

        WebElement phone = driver.findElement(By.id("phone"));
        System.out.println(phone.isSelected());
        phone.sendKeys("8744831661");

        WebElement address = driver.findElement(By.id("textarea"));
        address.sendKeys("Mohalla Mohan Ganda Nala");


    }
}
