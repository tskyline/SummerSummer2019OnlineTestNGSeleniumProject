package test.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching
{
    WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
    }
    @Test
    public void test1()
    {
        driver.findElement(By.linkText("New tab")).click();
        BrowserUtils.wait(3);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Practice","Title is wrong");
    }

    @Test(description = "verify that ")
    public void test2()
    {
        driver.findElement(By.linkText("New tab")).click();
        String oldWindow=driver.getWindowHandle();
        BrowserUtils.wait(5);
        Set<String> windowHandles=driver.getWindowHandles();
        //list-a data structure
        //set-also a data structure but doesn't allow for duplicates.need a loop to read the data
        // will return getWindowHandles
        for (String windowHandle:windowHandles )
        {
            if(!windowHandle.equals(oldWindow))
                driver.switchTo().window(windowHandle);
        }
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Fresh tab","title is wrong");
        //we can build a function that can jump in between windows
        String pageTitle="Practice";
        for (String windowHandle:windowHandles )
        {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(pageTitle))
            break;
        }
        System.out.println(driver.getTitle());

    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
