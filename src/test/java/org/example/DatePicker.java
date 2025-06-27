package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class DatePicker {

    String expectedMonth = "August";
    String expectedYear = "2025";
    String expectedDate = "15";

    @Test
    public void DatePickerExample() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement datePicker1 = driver.findElement(By.xpath("//input[@id='datepicker']"));
        //datePicker1.sendKeys("21/07/2025");
        datePicker1.click();

        while (true){

            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(actualMonth.equals(expectedMonth) && actualYear.equals(expectedYear)){

                List<WebElement> dateElements = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a"));
                for(WebElement element : dateElements){
                    if(element.getText().equals(expectedDate)){
                        element.click();
                    }
                }

                break;
            }

            driver.findElement(By.xpath("//a[@title='Next']")).click();
            //driver.findElement(By.xpath("//a[@title='Prev']")).click();

        }
    }


    @Test
    public void DatePickerExample2() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement datePicker2 = driver.findElement(By.xpath("//input[@id='start-date']"));
        datePicker2.sendKeys("10-05-2030");

    }
}
