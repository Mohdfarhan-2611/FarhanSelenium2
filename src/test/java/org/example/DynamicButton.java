package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class DynamicButton {

    @Test
    public void ClickToggleButton() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement button = driver.findElement(By.xpath("//button[@onclick='toggleButton(this)']"));
        for(int i=1; i<=10; i++){
            button.click();
            Thread.sleep(2000);
        }



    }

}
