package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Interview1 {

    @Test
    void nameSuggestion() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String namefield = "//button[@id='mousehover']";

//        WebElement element = driver.findElement(By.xpath(namefield));
//
//        element.sendKeys("Mallikarjuna B S");

        WebElement element = driver.findElement(By.xpath(namefield));

        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

        driver.findElement(By.xpath("//button[@id='mousehover']/following-sibling::div/a[normalize-space()='Top']")).click();

        String pageheader = driver.findElement(By.xpath("//h1[normalize-space()='Practice Page']")).getText();

        Assert.assertEquals(pageheader, "Practice Page");


    }

}
