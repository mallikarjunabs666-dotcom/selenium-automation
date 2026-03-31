package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;


//    Using action class we perform following operations
//    Mouse hover, right click, double click, drag and drop
//    We create a object for the action class and pass driver as the reference

public class Actionclass {

    @Test
    public void actionclass() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions a = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//span[contains(text(), 'Account & Lists')]"));

//       to hover on web element
        a.moveToElement(element).perform();

//        to right click on web eelment

        a.contextClick(element).perform();

//        to double click

//        a.doubleClick(element).perform();

       WebElement source =  driver.findElement(By.xpath("//div/a[contains(text(), 'Sell')]"));

       WebElement destination = driver.findElement(By.xpath("//div/a[contains(text(), 'Customer Service')]"));

       a.dragAndDrop(source, destination);




    }
}




