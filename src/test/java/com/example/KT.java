package com.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class KT {

     @Test
     void demo() throws IOException {

         WebDriver driver = new ChromeDriver();
         driver.get("https://www.google.com");
         driver.manage().window().maximize();

         // Take screenshot
         File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

         // Save screenshot to file
         FileUtils.copyFile(screenshot, new File("screenshot.png"));

         System.out.println("Screenshot saved successfully!");

     }


}
