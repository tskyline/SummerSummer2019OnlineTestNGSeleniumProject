package test.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FramePractice
{
    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    @Test(description = "iFrame example")
    public void test1()
    {
        driver.findElement(By.linkText("iFrame")).click();
        driver.switchTo().frame("mce_0_ifr");
        //since element is inside frame. Selenium can not find this.
        //we just switched to the frame
        /*
        which one to use?index?,id?,name?,WebElement?
        1.id or name <iframe id="mce_0_ifr" name="some_frame">
        2.WebElement driver.findElement(By.cssSelector("iframe[class='some_frame']"));
        3.index[iframe1,iframe2,iframe3...]
         */
        WebElement inputArea=driver.findElement(By.id("tinymce"));
        Assert.assertEquals(inputArea.getText(),"Your content goes here.");
        BrowserUtils.wait(2);
        inputArea.clear();
    }

    @Test(description = "nested frames")
    public void test2()
    {
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
        WebElement content=driver.findElement(By.tagName("body"));
        System.out.println(content.getText());

        driver.switchTo().defaultContent();//come back to original content

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement content1=driver.findElement(By.tagName("body"));
        System.out.println(content1.getText());
    }
}
