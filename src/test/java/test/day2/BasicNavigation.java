package test.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Clock;

public class BasicNavigation
{
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();

        //to max browser
        driver.manage().window().maximize();

        driver.get("http://google.com");

        //to navigate to different page within same browser
        /*
        URL can be passed as an object
        or as a String
         */
        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);
        //to comeback one page
        driver.navigate().back();

        String url=driver.getCurrentUrl();
        System.out.println(url);
        //selenium cannot close browser automatically
        //for this we use
        driver.quit();



    }
}
