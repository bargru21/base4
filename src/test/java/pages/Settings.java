package pages;

import helpers.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Bartek on 2017-10-07.
 */
public class Settings {
    private final WebDriver driver;

    @FindBy(linkText = "Leads")
    private WebElement customizeLeads;

    @FindBy(linkText = "Lead Statuses")
    private WebElement leadStatuses;

    @FindBy(css = "#lead-status .named-object-lead:nth-child(1) .main-toolbar button")
    private WebElement editNewStatus;

    @FindBy(css = "#lead-status .named-objects-list .controls #name")
    private WebElement newStatusInputField;

    @FindBy(css = "#lead-status .named-object-lead:nth-child(1) button")
    private WebElement save;

    public Settings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method clicks Leads in Customize category
     *
     * @return return the current page object
     */
    public Settings clickCustomizeLeads() {
        Wait.waitForElement(customizeLeads);
        customizeLeads.click();
        return this;
    }

    /**
     * Method clicks Lead Statuses
     *
     * @return return the current page object
     */
    public Settings clickLeadStatuses() {
        leadStatuses.click();
        return this;
    }

    /**
     * Method clicks edit button near New status
     *
     * @return return the current page object
     */
    public Settings clickEditNewStatus() {
        editNewStatus.click();
        return this;
    }

    /**
     * Method writes New status name
     *
     * @return return the current page object
     */
    public Settings writeNewStatusName() {
        newStatusInputField.clear();
        newStatusInputField.sendKeys("Some New Status");
        return this;
    }

    /**
     * Method clicks save button to save changes for Lead Statuses
     *
     * @return return the current page object
     */
    public Settings clickSave() {
        save.click();
        return this;
    }
}
