package com.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Formfill {

     public static WebDriver driver = null;

   static void waitcommonmethod(String waitElement)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitElement)));
    }

    static void quickdriver()
    {
        driver.quit();
    }

    static void clickelement(String clickelement)
    {
        driver.findElement(By.xpath(clickelement)).click();
    }

    @Test
    public void form() throws IOException {
     driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/form");


//        File formfillscreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        // Save screenshot to file
//        FileUtils.copyFile(formfillscreenshot, new File("target/Screenshots/"+"formfillscreenshot.png"));
//
//        System.out.println("Screenshot saved successfully!");

        String eleCompleteWebpageHome = "//h1[contains(text(), 'Complete Web Form')]";
        waitcommonmethod(eleCompleteWebpageHome);

        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Mallikarjuna");

        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("B S");

        driver.findElement(By.xpath("//input[@id='job-title']")).sendKeys("Senior QA");

       String educationRadioButtonClick = "//div[normalize-space()='Grad School']/child::input[@type='radio']";

       clickelement(educationRadioButtonClick);

       String genderCheckBox = "//div[normalize-space()='Male']/child::input[@type='checkbox']";

       clickelement(genderCheckBox);


//// to select value from the dropdown
//
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='select-menu']"));

        Select dropvalues = new Select(dropdown);

        dropvalues.selectByIndex(1);
//
////        dropvalues.selectByVisibleText("10+");
//
//
//
//
////        to select value from the date picker
//
      driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        String datetoselect = "24";

        String datexpath = "//td[text()='" + datetoselect + "']";

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(datexpath)));

        element1.click();

        driver.findElement(By.xpath("//a[normalize-space()='Submit']")).click();

        quickdriver();
    }
}
//
//
//}

// xpath for different elemenst in that applicationrgvsx

// button
//button[contains(text(), 'Primary')]

// 1 button
//button[normalize-space()='1']

//dropdown in button page
////button[@id='btnGroupDrop1']

//Ask about take screenshot scnraio

//Ask about reports download ( Not getting test-output folder )

//Not getting invokation count to add it to test ng runs

//Ask about reporter.log ( to print both in console and reports )

// ask for seprate method for different actions for optimization


//travesing using one static element //div[@id='crosscol']//a[normalize-space()='Home']/parent::li/following-sibling::li[3]

////input[@id='name']/following-sibling::input[1]

// add xpath using parent, child, sibling( both up and down ), ancestor,

//


