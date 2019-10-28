package test.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class NavigationPractice
{
    public static void main(String[] args)
    {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://google.com");
        driver.navigate().to("http://amazon.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }
}
