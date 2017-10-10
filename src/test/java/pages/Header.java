package pages;

import helpers.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Bartek on 2017-10-04.
 */
public class Header {
    private final WebDriver driver;

    @FindBy(id = "nav-leads")
    private WebElement leadsTab;

    @FindBy(id = "user-dd")
    private WebElement avatar;

    @FindBy(linkText = "Settings")
    private WebElement settings;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method opens Leads tab
     *
     * @return return the current page object
     */
    public Header clickLeadsTab() {
        Wait.waitForElement(leadsTab);
        leadsTab.click();
        return this;
    }

    /**
     * Method clicks avatar
     *
     * @return return the current page object
     */
    public Header clickAvatar() {
        avatar.click();
        return this;
    }

    /**
     * Method clicks settings
     *
     * @return return a new page object representing the destination
     */
    public Settings clickSettings() {
        settings.click();
        return new Settings(driver);
    }
}
