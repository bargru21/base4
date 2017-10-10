package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Bartek on 2017-10-07.
 */
public class MainPage {
    private final WebDriver driver;

    @FindBy(linkText = "Log In")
    private WebElement loginButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method clicks login button from main page
     *
     * @return return a new page object representing the destination
     */
    public Login clickLogin() {
        loginButton.click();
        return new Login(driver);
    }

    /**
     * Method opens main page
     *
     * @return return the current page object
     */
    public MainPage openMainPage() {
        driver.navigate().to("https://getbase.com/");
        return this;
    }
}
