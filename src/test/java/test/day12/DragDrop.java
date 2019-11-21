package test.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragDrop
{
    @Test
    public void test1()
    {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
       // driver.manage().window().maximize();
        driver.findElement(By.cssSelector("button[title='Accept Cookies']")).click();
        Actions action=new Actions(driver);

        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droptarget"));
        BrowserUtils.wait(2);
        action.dragAndDrop(drag,drop).pause(200).build().perform();
        BrowserUtils.wait(2);
        System.out.println(drop.getText());
        driver.quit();
    }
}
