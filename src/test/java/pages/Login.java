package pages;

import helpers.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Bartek on 2017-10-07.
 */
public class Login {
    private final WebDriver driver;

    @FindBy(id = "user_email")
    private WebElement email;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(css = ".controls button")
    private WebElement login;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method writes email
     *
     * @param string email address
     * @return return the current page object
     */
    public Login writeEmail(String string) {
        Wait.waitForElement(email);
        email.sendKeys(string);
        return this;
    }

    /**
     * Method writes password
     *
     * @param string password
     * @return return the current page object
     */
    public Login writePassword(String string) {
        password.sendKeys(string);
        return this;
    }

    /**
     * Method logs user in
     */
    public void login() {
        login.click();
    }
}
