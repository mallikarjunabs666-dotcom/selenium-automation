package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Takesscreenshot {


    @Test
    public void screenshot()
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Takesscreenshot ts = (Takesscreenshot) driver;






    }
}
