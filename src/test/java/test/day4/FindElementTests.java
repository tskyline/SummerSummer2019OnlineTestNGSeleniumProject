package test.day4;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;


public class FindElementTests
{
    public static void main(String[] args)
    {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.navigate().to("http://practice.cybertekschool.com/forgot_password");
        WebElement button=driver.findElement(By.id("form_submit"));
        String expected=driver.getTitle();
        button.click();
        BrowserUtils.wait(2);
        String actual=driver.getTitle();

        if(actual.equals(expected))
            System.out.println("passed");
        else
            System.out.println("failed");

        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("tuna@me.com", Keys.ENTER); //sendkeys is used for entering data,ENTER to click enter

        BrowserUtils.wait(2);
        String url=driver.getCurrentUrl();
        if(url.equals("http://practice.cybertekschool.com/email_sent"))
            System.out.println("Passed email page");

        WebElement conf =driver.findElement(By.name("confirmation_message"));
        String exp="Your e-mail's been sent!";
        if(exp.equals(conf.getText()))
            System.out.println("Confirmation message displayed");


        driver.quit();
    }
}
