package org.example2;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.*;
import java.time.Duration;
import java.util.Iterator;

public class ExcelData {

    @Test
    public void readDataFromExcel() throws IOException, InvalidFormatException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        File file = new File(System.getProperty("user.dir")+"/src/test/java/org/example2/AutomationTestData.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("TestData");
        Iterator<Row> rowIterator =  xssfSheet.iterator();
        rowIterator.next(); //skip column
        Row row;
        Cell nameCell=null;
        Cell emailCell=null;
        Cell phoneCell=null;

        while (rowIterator.hasNext()){
            row = rowIterator.next();
            nameCell = row.getCell(0);
            emailCell = row.getCell(1);
            phoneCell = row.getCell(2);
        }

        String name = nameCell.toString();
        String email = emailCell.toString();
        String phone = phoneCell.toString();


        //Name
        WebElement nameElement = driver.findElement(By.id("name"));
        nameElement.sendKeys(name);

        //Email
        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys(email);

        //Phone
        WebElement phoneElement = driver.findElement(By.id("phone"));
        phoneElement.sendKeys(phone);


      xssfWorkbook.close();
      fis.close();
      driver.quit();
    }



    @Test
    public void writeDataToExcel() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/src/test/java/org/example2/AutomationTestData.xlsx");

        // Open existing workbook
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("TestData");

        // Find the last row number and add 1 for new row
        int lastRowNum = sheet.getLastRowNum();
        Row newRow = sheet.createRow(lastRowNum + 1);

        // Add data to new row
        newRow.createCell(0).setCellValue("Mohammad Farhan");
        newRow.createCell(1).setCellValue("farhan@example.com");
        newRow.createCell(2).setCellValue("9876543210");

        // Close input stream before writing
        fis.close();

        // Now open output stream to write changes
        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        }

        workbook.close();

        System.out.println("✅ Data appended successfully to Excel.");
    }

}

