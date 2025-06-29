package org.Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class PaginationExamples {

    @Test
    public void PaginationExample() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        List<WebElement> allPagination = driver.findElements(By.xpath("//ul[@class='pagination']/li"));

        for(WebElement pagination : allPagination){
           int rows =driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr")).size();
           int cols =driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr[1]/td")).size();

           for(int r=1; r<=rows; r++){
               String names = driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+r+"]/td[2]")).getText();
               System.out.println(names);
               Thread.sleep(3000);
               WebElement checkbox = driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+r+"]/td[4]/input[@type='checkbox']"));
               checkbox.click();
           }
            pagination.click();
        }
    }
}
