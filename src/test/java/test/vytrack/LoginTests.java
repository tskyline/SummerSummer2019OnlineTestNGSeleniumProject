package test.vytrack;

import org.testng.Assert;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import test.TestBase;
import utils.BrowserUtils;
import utils.Driver;

public class LoginTests extends TestBase
{

    @Test(description = "Verify that page title is a 'Dashboard'")
    public void test1()
    {
        //create page object
        LoginPage loginPage = new LoginPage();
        //call login method
        //provide username and password
        loginPage.login("storemanager85", "UserUser123");
        //verification stage
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
    }

    @Test(description = "top menu")
    public void test2()
    {
        LoginPage loginPage = new LoginPage();
        //call login method
        //provide username and password
        loginPage.login("storemanager85", "UserUser123");
        BrowserUtils.wait(5);
        BasePage page=new BasePage();
        page.navigateTo("Fleet","Vehicles");
        BrowserUtils.wait(2);
    }
}
