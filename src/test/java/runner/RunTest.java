package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import steps.DriverFactory;

/**
 * Created by Bartek on 2017-10-07.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
        glue = {"steps"},
        plugin = {"pretty"},
        strict = true,
        monochrome = true,
        tags = {"@test1"}
)
public class RunTest {
    @AfterClass
    public static void tearDown() {
        DriverFactory.getDriver().quit();
    }
}
