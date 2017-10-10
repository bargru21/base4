package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Bartek on 2017-10-10.
 */
public class DriverFactory {
    protected static WebDriver driver;

    public DriverFactory() {
        initialize();
    }

    private void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }

    private void createNewDriverInstance() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    public static WebDriver getDriver() {
        return driver;
    }
}