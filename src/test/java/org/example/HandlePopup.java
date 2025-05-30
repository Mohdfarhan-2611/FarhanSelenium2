package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandlePopup {

    @Test
    public void handlePopup(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement popupWindow = driver.findElement(By.xpath("//button[@id='PopUp']"));
        popupWindow.click();

        String firstWindow = driver.getWindowHandle();
        System.out.println(firstWindow);

        Set<String> setallPopup = driver.getWindowHandles();
        List<String> allPopupList = new ArrayList<>(setallPopup);

        System.out.println(allPopupList);

        int count = 1;
        for(String windowid : allPopupList){
            if(!windowid.equals(firstWindow)){
                driver.switchTo().window(windowid);
                System.out.println("Popup "+count +":"+ windowid);
                System.out.println(driver.getTitle());
                driver.close();
                count++;
            }

        }

        driver.switchTo().window(firstWindow);
        driver.quit();




    }
}
