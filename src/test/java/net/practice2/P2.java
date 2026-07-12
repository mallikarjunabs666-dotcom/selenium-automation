package net.practice2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P2 {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

       try {
           driver.get("https://testautomationpractice.blogspot.com/");

           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='alertBtn' and normalize-space()='Simple Alert']")));

           driver.findElement(By.xpath("//button[@id='alertBtn' and normalize-space()='Simple Alert']1")).click();

           wait.until(ExpectedConditions.alertIsPresent());

           Alert alert = driver.switchTo().alert();

           String alertext = alert.getText();

           System.out.println(alertext);

           alert.accept();

           System.out.println("Alert handled successfully");
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }








    }
}
