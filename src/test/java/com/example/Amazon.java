package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Amazon {
    @Test
    public void Amazon() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement element = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        element.sendKeys("Shoes");

        element.sendKeys(Keys.ENTER);

        List<WebElement> allshoes = driver.findElements(By.xpath("//div[contains(@class,'s-result-item') and contains(@class,'s-asin')]"));

        System.out.println("Total shoes " + allshoes.size());

        for (int i = 0; i < allshoes.size(); i++) {
            WebElement shoe = allshoes.get(i);

            try {
                String title = shoe.findElement(By.xpath(".//h2")).getText();
                String price = shoe.findElement(By.xpath(".//span[contains(@class,'a-price')]")).getText();

                System.out.println("Shoe #" + (i + 1) + ": " + title + " - " + price);

            } catch (Exception e) {
                System.out.println("Error processing shoe #" + (i + 1));
            }


        }


    }
}


//*[normalize-space()='High School'] - recommnded
