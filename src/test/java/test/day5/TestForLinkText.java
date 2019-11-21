package test.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestForLinkText
{
    public static void main(String[] args)
    {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        WebElement cheese=driver.findElement(By.linkText("Dynamic Content"));
        //it works only if tagName is "a"(link)
        System.out.println(cheese.getText());
        driver.quit();
    }

}
