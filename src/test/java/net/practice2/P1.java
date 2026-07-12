package net.practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchfield = driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));

        searchfield.sendKeys("amazon");

        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Wikipedia1_wikipedia-search-input")));

        List<WebElement> searchresults = driver.findElements(By.xpath("//div[contains(@id,'wikipedia-search-result-link')]"));

        System.out.println("total search results is " + searchresults.size());

        driver.findElement(By.xpath("//button[@name='start' and text()='START']")).click();

        driver.findElement(By.xpath("//button[@name='stop' and text()='STOP']")).click();









    }



}
