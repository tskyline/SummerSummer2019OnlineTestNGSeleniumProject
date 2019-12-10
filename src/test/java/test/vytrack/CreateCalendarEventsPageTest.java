package test.vytrack;

import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.CreateCalendarEventsPage;
import pages.LoginPage;
import test.TestBase;

public class CreateCalendarEventsPageTest extends TestBase
{
    @Test
    public void test1()
    {
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();


    }
}
