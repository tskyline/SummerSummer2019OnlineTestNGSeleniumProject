package test.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUpPractice
{
    private WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
    }

    @Test(description = "click OK on pop up message")
    public void test1()
    {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement((By.xpath("//button[2]"))).click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        BrowserUtils.wait(2);
    }
    @Test(description = "click on cancel on pop up message")
    public void test2()
    {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement((By.xpath("//button[2]"))).click();
        BrowserUtils.wait(2);
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        BrowserUtils.wait(2);
        System.out.println(driver.findElement(By.id("result")).getText());

    }

    @Test(description = "click on button3, enter some text and click")
    public void test3()
    {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement((By.xpath("//button[3]"))).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().sendKeys("Hey Hey Hey");
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("result")).getText());

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
