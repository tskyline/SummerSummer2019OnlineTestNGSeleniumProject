package test.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class warmup
{
    public static void main(String[] args)
    {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://cybertekschool.com/");
        //how to find all links?
        //every link has a tag name <a>
        List<WebElement> links=driver.findElements(By.xpath("//a"));
        System.out.println("Number of links: "+links.size());

        //to print all the links in the list
        for (WebElement elements:links)
        {
            if(!elements.getText().isEmpty())
            System.out.println(elements.getText());
        }
        System.out.println();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement css=driver.findElement(By.cssSelector("#disappearing_button"));
        System.out.println(css.getText());
        driver.quit();
    }
}
