package org.StaleElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Amazone {


    @Test
    public void enterDataFromExcel()  {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("Motorola edge 60 cover");

        WebElement suggestionBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sac-autocomplete-results-container']//div[contains(text(),'motorola edge 60 cover')]")));
        suggestionBox.click();

        WebElement searchBox2 = driver.findElement(By.xpath("//input[@type='text']"));
        String searchText = searchBox2.getAttribute("value");

        System.out.println(searchText);

    }
}
