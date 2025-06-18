package org.redbus;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.Duration;

public class RedBus {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.redbus.in/");
    }

    @Test
    public void selectFromToWithKeyboard() {
        Actions actions = new Actions(driver);

        // 1. Click on "From" box (it's a div, not input)
        WebElement fromDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@tabindex='0']/descendant::div[text()='From']")));
        actions.moveToElement(fromDiv);
        JavascriptExecutor js  = (JavascriptExecutor) driver;
        js.executeScript("argument[0].click",fromDiv);
        actions.sendKeys("Ghaziabad").pause(Duration.ofSeconds(1)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        // 2. Click on "To" box
        WebElement toDiv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='To']/following-sibling::div")));
        toDiv.click();
        actions.sendKeys("Dehradun").pause(Duration.ofSeconds(1)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        // 3. Click search
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Search Buses')]")));
        searchBtn.click();
    }

  //  @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
