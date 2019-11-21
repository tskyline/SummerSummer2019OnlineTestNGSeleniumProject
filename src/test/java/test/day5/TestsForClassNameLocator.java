package test.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestsForClassNameLocator
{
    public static void main(String[] args)
    {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement header=driver.findElement(By.className("h3"));
        System.out.println(header.getText());
        driver.quit();
    }
}
