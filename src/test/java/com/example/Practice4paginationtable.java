package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Practice4paginationtable {


@Test
    public void Practice4()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        String tablexpath = "//h2[text()='Pagination Web Table']/ancestor::div//table[@id='productTable']";

        WebElement table = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tablexpath)));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows)
        {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (WebElement cell : cells)
            {
                System.out.print(cell.getText() + " ");

            }
            driver.findElement(By.xpath("//table[@id='productTable']//input[@type='checkbox']")).click();
            System.out.println();


        }



    }





}
