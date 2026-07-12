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

public class Practiceprogram3 {


    @Test
    void practice3()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String tablexpath = "//h2[contains(text(), 'Dynamic Web Table')]/following-sibling::div//table[@id='taskTable']";

        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tablexpath)));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows)
        {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (WebElement cell : cells)
            {
                System.out.print(cell.getText() + " ");
            }

            System.out.println();


        }
driver.quit();




    }






}
