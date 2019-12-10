package test.vytrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.TestBase;


public class CalendarEventsTest extends TestBase
{

    @Test(description = "Verify that page subtitle is equals to 'All Calendar Events'")
    public void test1(){
        extentTest=extentReports.createTest("Verify that page subtitle is equals to 'All Calendar Events");
        LoginPage loginPage1 = new LoginPage();
        loginPage1.login("storemanager85", "UserUser123");
        loginPage1.navigateTo("Activities", "Calendar Events");
        String expectedSubtitle = "All Calendar Events";
        String actualSubTitle = loginPage1.getPageSubTitle();
        Assert.assertEquals(actualSubTitle, expectedSubtitle);

        extentTest.pass("Verified that page subtitle'All Calendar Events' is displayed ");
    }
}
