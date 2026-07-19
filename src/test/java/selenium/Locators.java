package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Locators {

    @Test
    void locators()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.id("name")).sendKeys("Mallikarjuna");
        driver.findElement(By.id("email")).sendKeys("mallikarjunsbs666@gmail.com");
//        driver.findElement(By.linkText("Udemy Courses")).click();
//        driver.findElement(By.partialLinkText("Udemy")).click();
        driver.findElement(By.cssSelector("input[id='phone']")).sendKeys("9535675912");
        driver.findElement(By.xpath("//textarea[@id='textarea']"));

//        Implicitly wait

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
//        driver.manage().timeouts().implicitlyWait(Duration.ofDays(1));
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    }

    @Test
    void explicitWait()
    {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//select[@id='country']")).click();
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='Alerts & Popups']")).getText());
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='Alerts & Popups']/following-sibling::div/button[normalize-space()='Simple Alert']")).getText());
        System.out.println(driver.findElement(By.xpath("//button[normalize-space()='START']")).getLocation());
        System.out.println(driver.findElement(By.xpath("//button[normalize-space()='START']")).getSize());






    }
}
