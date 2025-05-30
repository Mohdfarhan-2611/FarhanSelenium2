package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SearchTextBox {

    @Test
    public void enterTextInSearchBox() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement searchBox = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
        searchBox.sendKeys("Selenium");

        WebElement searchIcon = driver.findElement(By.xpath("//input[@type='submit']"));
        searchIcon.click();

        String firstWindowSession = driver.getWindowHandle();
        System.out.println("First window session: "+firstWindowSession);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> searchResult = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@id,'Wikipedia1_wikipedia-search')]//a")));
        for(WebElement result : searchResult) {
            System.out.println(result.getText());
            result.click();
        }

        Set<String> allWindows = driver.getWindowHandles();
        List<String> allWindowsList = new ArrayList<>(allWindows);

        for(String windowid : allWindowsList){
            if(!windowid.equals(firstWindowSession)){
                System.out.println(windowid);
                driver.switchTo().window(windowid);
                System.out.println("Title of window"+driver.getTitle());
                driver.close();
            }
        }


        driver.quit();


    }
}
