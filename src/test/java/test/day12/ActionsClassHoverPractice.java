package test.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class ActionsClassHoverPractice
{
    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    @Test(description = "verify all images")
    public void test1()
    {
        Actions action=new Actions(driver);
        WebElement image1=driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
        action.moveToElement(image1).perform();
        BrowserUtils.wait(3);
        for (int i = 1; i <= 3; i++) {
            action.moveToElement(driver.findElement(By.cssSelector(".figure:nth-of-type(" + i + ")"))).perform();
            BrowserUtils.wait(2);
            String name = driver.findElement(By.cssSelector(".figure:nth-of-type(" + i + ") h5")).getText();
            System.out.println(name);
            Assert.assertEquals(name, "name: user"+i);
        }
    }
}
