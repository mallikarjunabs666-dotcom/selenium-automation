package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppTest {
    @Test
    public void Amazon() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/login/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[contains(@name, 'email')]")).clear();

        driver.findElement(By.xpath("//input[@name='pass']")).clear();;

        driver.findElement(By.xpath("//input[contains(@name, 'email')]")).sendKeys("mbs@onetrust.com");

        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("123arjun");

        driver.findElement(By.xpath("//div[@role='button' and @aria-label='Log in']")).click();

        System.out.println(driver.findElement(By.xpath("//span[contains(text(), 'Forgotten password?')]")).getText());

        System.out.println(driver.findElement(By.xpath("//*[name()='svg' and @aria-label='Meta logo']")).getLocation());

        System.out.println(driver.findElement(By.xpath("//span[contains(text(), 'Create new account')]")).getSize());
//        driver.findElement(By.xpath())


    }
}
