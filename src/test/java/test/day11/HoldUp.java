package test.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class HoldUp
{
    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    @Test(description = "implicitWait")
    public void test1()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.tagName("button")).click();
        WebElement finish=driver.findElement(By.id("finish"));
        Assert.assertEquals("Hello World!",finish.getText());
    }

    @Test(description = "explicitWait")
    public void test2()
    {
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 1")).click();
        driver.findElement(By.tagName("button")).click();
        //explicit wait
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement username=driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("tomsmith");
        driver.findElement(By.id("pwd")).sendKeys("SuperSecretPassword");
        WebElement submit=driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Secure Area","Run for your life");

    }

    @Test
    public void test3()
    {
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();
        WebDriverWait wait=new WebDriverWait(driver,10);

        WebElement overlayScreen=driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        //wait until overlay screen disappear
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));
    }
}
