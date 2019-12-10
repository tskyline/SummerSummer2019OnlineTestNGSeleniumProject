package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.Driver;

public class LoginPage extends BasePage
{
    @FindBy(id="prependedInput")
    public WebElement userInput;

    @FindBy(id="prependedInput2")
    public WebElement passwordInput;




    public LoginPage()
    {//constructor is mandatory in order to use @FindBy annotation
    PageFactory.initElements(Driver.getDriver(),this);

    }

    public void login(String username,String password)
    {
        userInput.sendKeys(username);
        passwordInput.sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(2);
    }


}
