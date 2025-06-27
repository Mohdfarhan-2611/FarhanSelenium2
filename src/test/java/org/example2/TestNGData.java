package org.example2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestNGData {


    @Test(dataProvider = "getUserData")
        public void enterDataFromTestNG(String name, String email, String phone) {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://testautomationpractice.blogspot.com/");

            // Fill form fields
            driver.findElement(By.id("name")).sendKeys(name);
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("phone")).sendKeys(phone);

            // Cleanup
            driver.quit();
        }

        @DataProvider
        public Object[][] getUserData() {
            return new Object[][]{
                    {"Mohammad Farhan", "farhan@example.com", "9876543210"},
                    {"John Doe", "john@example.com", "1234567890"},
                    {"Jane Smith", "jane@example.com", "1122334455"}
            };
        }





    @Test(dataProvider = "getUserData2")
    public void enterDataFromTestNG2(String name, String email, String phone) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        // Fill form fields
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("phone")).sendKeys(phone);

        System.out.println("✅ Entered data: " + name + ", " + email + ", " + phone);

        // Cleanup
        driver.quit();
    }

    @DataProvider
    public Iterator<Object[]> getUserData2() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"Mohammad Farhan", "farhan@example.com", "9876543210"});
        data.add(new Object[]{"John Doe", "john@example.com", "1234567890"});
        data.add(new Object[]{"Jane Smith", "jane@example.com", "1122334455"});

        return data.iterator(); // Returning Iterator instead of 2D array
    }




    }

