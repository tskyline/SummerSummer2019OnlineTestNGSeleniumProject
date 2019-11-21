package test.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestsForTagNameLocator
{
    public static void main(String[] args)
    {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    //<a href="/autocomplete">Autocomplete</a>
        WebElement tag=driver.findElement(By.tagName("h1"));

        System.out.println(tag.getText());
        driver.quit();
    }
}
