package test.day9;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGReview
{
    WebDriver driver;
    //Whatever is common among tests, can go into @before and @after method
    @BeforeMethod
    public void setup()
    {
        driver= BrowserFactory.getDriver("chrome");
        System.out.println("Before Method");
    }

    @AfterMethod
    public void teardown()
    {
        System.out.println("After Method");
        driver.quit();
    }

    @Test(description = "verify title of google",priority = 2)
    public void test1()
    {
        System.out.println("Test 1");
        driver.get("http://google.com");
        Assert.assertEquals(driver.getTitle(),"Google");
    }

    @Test(description = "verify title of apple",priority = 1)
    public void test2()
    {
        System.out.println("Test 2");
        driver.get("http://apple.com");
        Assert.assertEquals(driver.getTitle(),"Apple","Title is not correct");
    }

    @DataProvider(name="testData")
     public static Object [][] testData()
    {
        return new Object[][]{{"http://apple.com","Apple"},{"http://google.com","Google"}};
    }

    @Test(dataProvider = "testData")
    public void testWithDataProvider(String url,String title)
    {
        driver.get(url);
        Assert.assertEquals(driver.getTitle(),title);
    }
}
