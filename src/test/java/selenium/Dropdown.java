package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Dropdown {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//        To handle dropdown we make use of select class

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
        Select s = new Select(dropdown);
        s.selectByIndex(0);
        s.selectByValue("germany");
        s.selectByVisibleText("Canada");

        System.out.println("All available options are");

        List<WebElement> options = s.getOptions();

        for (WebElement option : options)
        {
            System.out.println(option.getText());
        }
    }


}
