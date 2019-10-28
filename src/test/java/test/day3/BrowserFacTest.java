package test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserFactory;

public class BrowserFacTest
{
    public static void main(String[] args) throws InterruptedException
    {

        WebDriver driver =BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(3000);
        System.out.println(driver.getPageSource());
        driver.quit();


    }
}
