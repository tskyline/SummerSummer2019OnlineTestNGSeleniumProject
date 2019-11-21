package test.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class CheckBoxes
{
    private WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("Checkboxes")).click();
    }

    @Test
    public void test1()
    {
        List<WebElement> checkbox=driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (WebElement each:checkbox)
        {
            if(each.isEnabled()&&!each.isSelected())
                each.click();

        }
    }

    @AfterMethod
    public void close()
    {
        driver.quit();
    }
}
