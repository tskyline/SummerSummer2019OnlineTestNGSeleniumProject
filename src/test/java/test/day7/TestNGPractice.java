package test.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice
{
    @Test
    public void test()
    {
        Assert.assertEquals("apple","apple","Word is not correct");

    }

    @Test(description = "verify that heading is displayed")
    public void verifyTestAutoPractice()
    {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        WebElement heading=driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
        Assert.assertTrue(heading.isDisplayed(),"element is not visible");
        driver.quit();
    }
}
