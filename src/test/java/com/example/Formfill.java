package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Formfill {

    @Test
    public void form() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/form");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Complete Web Form')]")));

        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Mallikarjuna");

        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("B S");

        driver.findElement(By.xpath("//input[@id='job-title']")).sendKeys("Senior QA");

        driver.findElement(By.xpath("//div[normalize-space()='Grad School']/child::input[@type='radio']")).click();

        driver.findElement(By.xpath("//div[normalize-space()='Male']/child::input[@type='checkbox']")).click();


// to select value from the dropdown

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='select-menu']"));

        Select dropvalues = new Select(dropdown);

        dropvalues.selectByIndex(1);

//        dropvalues.selectByVisibleText("10+");




//        to select value from the date picker

        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        String datetoselect = "24";

        String datexpath = "//td[text()='"+ datetoselect+"']";

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

       WebElement element1 =  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(datexpath)));

       element1.click();

       driver.findElement(By.xpath("//a[normalize-space()='Submit']")).click();

    }


}

// xpath for different elemenst in that application

// button
//button[contains(text(), 'Primary')]

// 1 button
//button[normalize-space()='1']

//dropdown in button page
////button[@id='btnGroupDrop1']


