package test.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class RadioButtons
{
    private WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("Radio Buttons")).click();
    }
    @Test(description = "Verify that blue button is selected")
    public void test1()
    {
        //to go to radio buttons page

        WebElement blueButton=driver.findElement(By.id("blue"));
        boolean isSelected=blueButton.isSelected();
        Assert.assertTrue(isSelected);

    }

    @Test(description = "Verify that red button is not selected")
    public void test2()
    {

        WebElement redButton=driver.findElement(By.id("red"));
        boolean isSelected=redButton.isSelected();
        Assert.assertFalse(isSelected);

    }

    @Test(description = "verify that greenbutton is not clickable")
    public void test3()
    {
        WebElement greenButton=driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
    }
    @Test(description = "Click on all radio buttons")
    public void test4()
    {
        //how to find all radio buttons
        List<WebElement> radioButtons=driver.findElements(By.cssSelector("input[type='radio']"));
        for (WebElement each:radioButtons)
        {
            if(each.isEnabled()&&!each.isSelected())
            {
                each.click();
                System.out.println("Button " + each.getAttribute("id") + " clicked");
            }else
                System.out.println("Button " + each.getAttribute("id") + " was not clicked");

        }
    }
    @AfterMethod
    public void close()
    {
        driver.quit();
    }

}
