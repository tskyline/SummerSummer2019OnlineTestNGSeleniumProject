package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class CalendarEventsPage extends BasePage
{
    @FindBy(css= "[title='Crate Calendar event']")
    public WebElement createCalendarEvent;

    public void clicktoCreateCalendarEvent()
    {
        BrowserUtils.waitForVisibility(createCalendarEvent,5);
        BrowserUtils.waitForClickablility(createCalendarEvent, 5);
        createCalendarEvent.click();
    }


}
