package test.day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class LocatorReview
{
    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }


    @Test
    public void test1()
    {
        //[type='checkbox']:nth-of-type(index number)
        driver.findElement(By.linkText("Checkboxes")).click();
        WebElement checkbox1=driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));
                                                                         //will find 1st checkbox
        Assert.assertFalse(checkbox1.isSelected(),"checkbox 1 is selected");
    }

}
