package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class MouseActions {

    @Test
    void mouseActions()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        Actions action = new Actions(driver);

        WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));

        action.moveToElement(element).perform();

        WebElement doubleclick = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

        action.doubleClick(doubleclick).perform();

//        action.contextClick(doubleclick).perform();

        WebElement source = driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));

        WebElement destination =driver.findElement(By.xpath("//parent::div[@id='droppable']"));

        action.dragAndDrop(source, destination).perform();
    }

    @Test
    void multiSelectDropdown()
    {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.testmuai.com/selenium-playground/select-dropdown-demo/");

        WebElement dropdownelement = driver.findElement(By.xpath("//select[@id='multi-select' and @name='States']"));

        Select dropdown = new Select(dropdownelement);
        System.out.println(dropdown.isMultiple());

        List<WebElement> alloptions = dropdown.getOptions();
        for (WebElement option : alloptions)
        {
            dropdown.selectByVisibleText(option.getText());
        }


    }
}
