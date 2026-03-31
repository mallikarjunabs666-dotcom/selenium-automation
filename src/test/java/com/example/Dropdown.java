package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dropdown {

//    to check single select and multiselect dropdown selection


    @Test
    public void singleselectdropdown()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/login/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//span[contains(text(), 'Create new account')]")).click();

       WebDriverWait wait = new WebDriverWait(driver, 10);

       WebElement genderdropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Select your gender')]")));

       genderdropdown.click();













    }



}
