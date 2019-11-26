package test.day14;

import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTest
{
    @Test
    public void Test1()
    {
        String url= ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        BrowserUtils.wait(2);
        Driver.close();
    }
}
