package test.vytrack;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.TestBase;

public class SmokeTest extends TestBase
{
    @DataProvider(name="Navigation Info")
    public Object[][] navigationInfo()
    {
        return new Object[][]
                {
                        {"Dashboards","Dashboard","Dashboard"},
                        {"Dashboards","Manage Dashboards","All Manage Dashboards"},
                        {"Fleet","Vehicles","All Cars"},
                        {"Customers","Accounts","All Accounts"}
                };
    }

    @Test(dataProvider = "Navigation Info")
    public void smokeTest(String modulName,String subModulName, String pageSubtitle)
    {
        extentTest=extentReports.createTest("Verify that page subtitle is equals to "+pageSubtitle);
        LoginPage loginPage=new LoginPage();
        loginPage.login("storemanager85","UserUser123");
        loginPage.navigateTo(modulName,subModulName);
        Assert.assertEquals(loginPage.getPageSubTitle(),pageSubtitle);
        extentTest.pass("Verified that page subtitle "+pageSubtitle+" is displayed ");
    }
}
