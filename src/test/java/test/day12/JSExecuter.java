package test.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class JSExecuter
{
    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    @Test(description = "")
    public void test1()
    {
        JavascriptExecutor js= (JavascriptExecutor) driver;
     for (int i=0;i<10;i++)
        {
            js.executeScript("window.scrollBy(0,500);");
            BrowserUtils.wait(1);
        }
    }

    @Test(description = "Scrolling with Jsexecuter to specific element")
    public void test2()
    {
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link=driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(2);

        JavascriptExecutor js= (JavascriptExecutor) driver;
        //once the link element will be visible it will stop scrolling
        //argument[0]= first webElement after comma(link)
        js.executeScript("arguments[0].scrollIntoView(true)",link);
        BrowserUtils.wait(2);
    }

    @Test(description = "Click with JS executor")
    public void test3()
    {
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        WebElement link=driver.findElement(By.partialLinkText("Example 1"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",link);
        BrowserUtils.wait(2);

    }

    @Test(description = "enter text with JSExecutor")
    public void test4()
    {
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement name=driver.findElement(By.name("full_name"));
        WebElement email=driver.findElement((By.name("email")));
        WebElement sub=driver.findElement(By.name("wooden_spoon"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value','John Smith')",name);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value','John@Smith.com')",email);

        BrowserUtils.wait(2);
        js.executeScript("arguments[0].click()",sub);
        BrowserUtils.wait(2);


    }

}
