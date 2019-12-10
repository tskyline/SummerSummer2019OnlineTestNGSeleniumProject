package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Driver;

public class CreateCarPage extends BasePage
{
    @FindBy(css="[id^='custom_entity_type_LicensePlate']")
    public WebElement licensePlate;

    @FindBy(name="custom_entity_type[Driver]")
    public WebElement driverElement;

    @FindBy(name="custom_entity_type[Location]")
    public WebElement locationElement;

    @FindBy(name="custom_entity_type[ChassisNumber]")
    public WebElement chassisNumberElement;

    @FindBy(name="custom_entity_type[ModelYear]")
    public WebElement modelYearElement;

    @FindBy(name="custom_entity_type[LastOdometer]")
    public WebElement lastOdometerElement;

    @FindBy(css="div[id*='FuelType']")
    public WebElement fuelTypeElement;

    @FindBy(css = "[class='btn btn-success action-button']")
    public WebElement saveAndClose;

    //if this locator doesn't work, use [id^='uniform-custom_entity_type_Logo_file'] > span[class='action']
    @FindBy(name = "custom_entity_type[Logo][file]")
    public WebElement logoElement;

    public WebElement selectTags(String tagName)
    {
        String locator="//label[text()='"+tagName+"']/preceding-sibling::input[@type='checkbox']";
        WebElement checkBox= Driver.getDriver().findElement(By.xpath(locator));

        BrowserUtils.waitForVisibility(checkBox,10);
        BrowserUtils.waitForClickablility(checkBox,10);
        if (!checkBox.isSelected())
            checkBox.click();

        return checkBox;
    }

    /**
     * Select fuel type by visible text
     *
     * @param fuelType - Diesel, Electric, Hybrid
     *  <p>
     *  usage: CreateCarPage createCarPage = new CreateCarPage();
     *  <p>
     *  to select gasoline type
     *  createCarPage.selectFuelType("Diesel"); - if you want to select Diesel as fuel type
     */
    public void selectFuelType(String fuelType)
    {
        String locator = "//div[@class='select2-result-label' and text()='" + fuelType + "']";
        BrowserUtils.waitForClickablility(fuelTypeElement, 15);
        fuelTypeElement.click();
        WebElement fuelTypeSelectionElement = Driver.getDriver().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(fuelTypeSelectionElement, 15);
        fuelTypeSelectionElement.click();
    }

    /**
     * This method will upload a file
     * File from your computer!
     * @param pathToTheFile that you want to upload
     */
    public void uploadLogo(String pathToTheFile){
        BrowserUtils.waitForVisibility(logoElement, 15);
        logoElement.sendKeys(pathToTheFile);
    }
}
