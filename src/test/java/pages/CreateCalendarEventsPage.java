package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCalendarEventsPage
{
    @FindBy(css = "[class='select2-chosen']")
    public WebElement owner;
}
