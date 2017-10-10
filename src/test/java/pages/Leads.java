package pages;

import helpers.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Bartek on 2017-10-04.
 */
public class Leads {
    private final WebDriver driver;

    @FindBy(id = "leads-new")
    private WebElement addLeadButton;

    @FindBy(id = "lead-first-name")
    private WebElement leadFirstNameInputField;

    @FindBy(id = "lead-last-name")
    private WebElement leadLastNameInputField;

    @FindBy(css = ".controls #lead-company-name")
    private WebElement leadCompanyNameInputField;

    @FindBy(css = ".edit-buttons button")
    private WebElement saveButton;

    @FindBy(css = "#details .status .lead-status")
    private WebElement leadStatus;

    @FindBy(css = "li[id^='lead-']")
    private WebElement editLead;

    @FindBy(css = "li[id^='lead-']")
    List<WebElement> leads;

    public Leads(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method adds new Lead
     *
     * @return return the current page object
     */
    public Leads addNewLead() {
        Wait.waitForElement(addLeadButton);
        addLeadButton.click();
        return this;
    }

    /**
     * Method writes First Name for new Lead
     *
     * @param firstName first name
     * @return return the current page object
     */
    public Leads setLeadFirstName(String firstName) {
        Wait.waitForElement(leadFirstNameInputField);
        leadFirstNameInputField.sendKeys(firstName);
        return this;
    }

    /**
     * Method writes Last Name for new Lead
     *
     * @param lastName last name
     * @return return the current page object
     */
    public Leads setLeadLastName(String lastName) {
        leadLastNameInputField.sendKeys(lastName);
        return this;
    }

    /**
     * Method writes Company Name for new Lead
     *
     * @param companyName company name
     * @return return the current page object
     */
    public Leads setLeadCompanyName(String companyName) {
        leadCompanyNameInputField.sendKeys(companyName);
        return this;
    }

    /**
     * Method clicks save button
     *
     * @return return the current page object
     */
    public Leads clickSave() {
        saveButton.click();
        return this;
    }

    /**
     * Method gets current Lead status
     *
     * @return Lead status as String
     */
    public String getLeadStatus() {
        Wait.waitForElement(leadStatus);
        return leadStatus.getText();
    }

    /**
     * Method opens Lead details to edit
     *
     * @return return the current page object
     */
    public Leads editLead() {
        Wait.waitForAllElements(leads);
        editLead.click();
        return this;
    }
}
