package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    @Test
    public void DropDownExample() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement dropDownElement = driver.findElement(By.xpath("//select[@id='country']"));
        Select select = new Select(dropDownElement);
        //select.selectByVisibleText("China");

        List<WebElement> alldropdownOptions = select.getOptions();

        for(WebElement element : alldropdownOptions){
            if (element.getText().equals("India")){
                element.click();
            }
        }









    }
}
