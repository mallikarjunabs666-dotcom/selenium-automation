package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Practiceprogram2 {

      WebDriver driver = new ChromeDriver();
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Test
    public void test1method() {

        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        String tablexpath = "//h2[contains(text(), 'Static Web Table')]/following-sibling::div//table[@name='BookTable']";

        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tablexpath)));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 0; i< rows.size(); i++)
        {
            List<WebElement> headers = rows.get(i).findElements(By.tagName("th"));

            for (WebElement header : headers)
            {
                System.out.print(header.getText() + " ");
            }
        }

        for (int i = 0; i<rows.size(); i++)
        {

            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

            for (int j=0; j<cells.size(); j++)
            {
                System.out.print(cells.get(j).getText() + " ");

            }

            System.out.println();



        }

//        for (WebElement row : rows)
//        {
//            List<WebElement> cells = row.findElements(By.tagName("td"));
//
//            for (WebElement cell : cells )
//            {
//                System.out.print(cell.getText() + " ");
//
//            }
//            System.out.println();
//
//
//        }

























    }



}
