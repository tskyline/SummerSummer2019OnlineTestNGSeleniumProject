package test.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class FileUploading
{
    private WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
    }

    @Test(description = "verify that file was uploaded")
    public void test1()
    {
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/TK/Desktop/hebele");
        driver.findElement(By.id("file-submit")).click();
        String up=driver.findElement(By.id("uploaded-files")).getText();
        System.out.println(up);
        Assert.assertEquals(up,"hebele","wrong file name");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
