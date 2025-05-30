package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class HandleWindow {


    @Test
    public void getWindow() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement newTab = driver.findElement(By.xpath("//button[text()='New Tab']"));

        Actions actions = new Actions(driver);
        actions.scrollToElement(newTab).perform();

        String firstWindow = driver.getWindowHandle();
        System.out.println("FirstWindow " + firstWindow);

        newTab.click();

        Set<String> allWindows = driver.getWindowHandles();
        System.out.println(allWindows);

        for (String a : allWindows) {
            if (!a.equals(firstWindow)) {
                driver.switchTo().window(a);
                a = driver.getWindowHandle();
                System.out.println("second window " + a);
                System.out.println(driver.getTitle());
                System.out.println(driver.getCurrentUrl());

                List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
                System.out.println("Total iframes: " + iframes.size());

                for (WebElement frame : iframes) {
                    driver.switchTo().frame(frame);
                    try {
                        WebElement label = driver.findElement(By.xpath("//div[contains(text(),'Followers')]"));
                        System.out.println("Header text: " + label.getText());
                        break; // Found it, no need to check further
                    } catch (Exception e) {
                        // Element not found in this frame, try next
                    }
                    driver.switchTo().defaultContent();
                }
                driver.close();
            }


        }

        driver.switchTo().window(firstWindow);
        driver.close();
    }

}
