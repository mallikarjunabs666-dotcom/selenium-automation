package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Practiceprogram1 {


   public static WebDriver driver = null;

   static void webpagewaitmethod(String elementvisible)
   {

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementvisible)));

   }

   static void sendkeysmethod(String locator, String text)
   {

       WebElement element = driver.findElement(By.xpath(locator));
       element.clear();
       element.sendKeys(text);
   }

   static void click(String locator1)
   {
       driver.findElement(By.xpath(locator1)).click();
   }


   static void quitmethod()

   {
       driver.quit();
   }


    @Test
    void Automationpractice() throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        String pageheader = "//h1[normalize-space()='Automation Testing Practice']";

        webpagewaitmethod(pageheader);


//        Adding name

//        String nameFieldXpath = "//label[contains(text(), 'Name')]/following-sibling::input[@id='name']";
//
//        String actualName = "Mallikarjun B S";
//
//        sendkeysmethod(nameFieldXpath, actualName);
//
//
////        Adding email
//
//        String emailfield = "//input[@id='phone']/preceding-sibling::input[@id='email']";
//
//        String actualname = "mallikarjunabs666@gmail.com";
//
//        sendkeysmethod(emailfield, actualname);
//
//
////        Adding phone number
//
//        String phonefield = "//div//input[@id='phone']";
//
//        String actualPhoneNumber = "9535675912";
//
//        sendkeysmethod(phonefield, actualPhoneNumber);
//
//
//
////        Adding adress
//
//        String adressfield = "//label[normalize-space()='Address:']/following-sibling::textarea[@id='textarea']";
//        String actualadress = "Mallikarjun Chikkamagalur";
//        sendkeysmethod(adressfield, actualadress);
//
//
////        Gender
//
//        String genderfield = "//input[@id='male' and @type='radio']";
//
//        click(genderfield);
//
//
////        Days
//
//        String days = "//div[contains(@class, 'form-group') and .//label[text()='Days:']]//input[@id='sunday']";
//        click(days);
//
////        Countries selection from the singe select dropdown
//
//        String countryxpath = "//div[contains(@class, 'form-group') and .//label[normalize-space()='Country:']]//select[@id='country']";
//        webpagewaitmethod(countryxpath);
////        click(countryxpath); When accessing dropdown, click is not necessay, check with sir
//
//        WebElement dropdown = driver.findElement(By.xpath(countryxpath));
//
//        Select select = new Select(dropdown);
//        select.selectByVisibleText("France");
//
//        select.selectByIndex(2);
//
//        select.selectByValue("australia");
//
//
////        Selecting colours from multiselect dropdown
//
//
//        WebElement colorselement = driver.findElement(By.xpath("//div[contains(@class, 'form-group') and  .//label[text()='Colors:']]//select[@id='colors']"));
//
//        Select dropdown1 = new Select(colorselement);
//
//        if (dropdown1.isMultiple())
//        {
//            dropdown1.selectByValue("blue");
//            dropdown1.selectByIndex(3);
//            System.out.printf("Dropdown is multiselect and selected value is");
//        }
//        else
//        {
//            dropdown1.selectByValue("green");
//            System.out.printf("Dropdown is singleselect");
//        }
//
////        Check sorted list with sir, looking like a multiselect but it is not
////        but when i select it, it is only selecting 1 value, if i presss control and select it is selecting multiple values
//
//
////        Date picker 1
//
//        String datepickerfield1xpath = "//p[normalize-space()='Date Picker 1 (mm/dd/yyyy):']//input[@id='datepicker']";
//
//        click(datepickerfield1xpath);
//
//        String datepickercpath = "//table[contains(@class, 'datepicker-calendar')]";
//
//        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(datepickercpath)));
//
//        WebElement dateinput = driver.findElement(By.xpath("//table[contains(@class, 'ui-datepicker-calendar')]//a[normalize-space()='15']"));
//
//        dateinput.click();
//
////        verify the date selection
////        This is also not working check with sir
//
//        WebElement datefield = driver.findElement(By.xpath(datepickerfield1xpath));
//
//        String dateselected = datefield.getAttribute("value");
//
//        System.out.printf("Selected date is" + dateselected);
//
////        Selecting date from any month and year in the calender
//
//        click(datepickerfield1xpath);
//
//        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(datepickercpath)));
//
//        while (true)
//        {
//            WebElement currentmonthelemet = driver.findElement(By.xpath("//span[contains(@class, 'ui-datepicker-month')]"));
//           String currentmonthselected =  currentmonthelemet.getText();
//
//           if (currentmonthselected.equals("October"))
//           {
//               break;
//           }
//           else
//           {
//               driver.findElement(By.xpath("//a//span[text()='Next']")).click();
//
//           }
//
//        }
//
//        String datetoselect = "//div[@id='ui-datepicker-div']//tr//a[@data-date='30']";
//
//        driver.findElement(By.xpath(datetoselect)).click();

//        Date picker 2

        String datepicker2xpath = "//p[contains(text(), 'Date Picker 2  (dd/mm/yyyy) : ')]//input[@id='txtDate']";

        driver.findElement(By.xpath(datepicker2xpath)).click();

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ui-datepicker-div']")));

        WebElement datepickerelement = driver.findElement(By.xpath("//select[contains(@class, 'ui-datepicker-month')]"));

        Select datepicker2nd = new Select(datepickerelement);

        datepicker2nd.selectByVisibleText("Oct");

        driver.findElement(By.xpath("//a[text()='10']")).click();

        WebElement yearpicker = driver.findElement(By.xpath("//select[contains(@class, 'ui-datepicker-year')]"));

        Select yearpicker1 = new Select(yearpicker);

        yearpicker1.selectByValue("2023");


//        Date Picker 3: (Select a Date Range), check with sir

//        String startdatexpath = "//label[contains(text(), 'Date Picker 3: (Select a Date Range)')]/following-sibling::div//input[@id='start-date']";
//
//        driver.findElement(By.xpath(startdatexpath)).click();
//
//        webpagewaitmethod(startdatexpath);


//        to click on link
//       WebElement linkelement =  driver.findElement(By.xpath("//div[@id='blog-pager']//a[contains(text(), 'Home')]"));
//
//        String originalwindowhandle = driver.getWindowHandle();
//
//        Actions action = new Actions(driver);
//
//       action.keyDown(Keys.CONTROL).click(linkelement).keyUp(Keys.CONTROL).perform();
//
//
//       Set<String> allwindowhandles = driver.getWindowHandles();
//
//       for (String currentwidnowhandle : allwindowhandles)
//       {
//           if (!currentwidnowhandle.equals(originalwindowhandle))
//           {
//               driver.switchTo().window(currentwidnowhandle);
//               break;
//           }
//       }
//
//       driver.switchTo().window(originalwindowhandle);

//       Clicking on Subscribe to: Comments (Atom)

        String commentslinkxpath = "//div//a[normalize-space()='Comments (Atom)']";

        WebElement commentslinkelement = driver.findElement(By.xpath(commentslinkxpath));


        Actions action2 = new Actions(driver);

        action2.keyDown(Keys.CONTROL).click(commentslinkelement).keyUp(Keys.CONTROL).perform();

        String originallinkwindowhandle = driver.getWindowHandle();

        Set<String> allwindowhandles1 = driver.getWindowHandles();

        for (String currentwindowhandle1 : allwindowhandles1)
        {
            if (!currentwindowhandle1.equals(originallinkwindowhandle))
            {
                driver.switchTo().window(currentwindowhandle1);
                break;
            }
        }

        driver.switchTo().window(originallinkwindowhandle);

//        File upload

        String fileuploadXpath = "//h2[contains(text(),'Upload Files')]/following-sibling::div//input[@id='singleFileInput']";

        WebElement fileuplaodelement = driver.findElement(By.xpath(fileuploadXpath));

        fileuplaodelement.sendKeys("C:\\Users\\Dell\\OneDrive\\Pictures\\Camera Roll\\20230929_181940_01.jpg");




















































//        quitmethod();















    }
}
