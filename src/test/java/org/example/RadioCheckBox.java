package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class RadioCheckBox {

    @Test
    public void clickRadioAndCheckBoxes() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement maleRadio = driver.findElement(By.id("male"));
        System.out.println(maleRadio.isSelected());
        maleRadio.click();
        System.out.println(maleRadio.isSelected());

        Thread.sleep(5000);

        WebElement femaleRadio = driver.findElement(By.id("female"));
        System.out.println(femaleRadio.isSelected());
        femaleRadio.click();
        System.out.println(femaleRadio.isSelected());

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//label[text()='Days:']/following::input[@class='form-check-input']"));
        for(WebElement checkbox : checkBoxes){
            checkbox.click();
            Thread.sleep(2000);
        }






    }
}
