package test.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class xpath
{
    public static void main(String[] args)
    {
        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.get("http://login1.nextbasecrm.com/?login=yes");
        driver.findElement(By.className("login-btn")).click();
        BrowserUtils.wait(2);
        WebElement warningMessage=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]"));
        //Absolute Xpath
        System.out.println(warningMessage.getText());
        driver.quit();


    }
}
