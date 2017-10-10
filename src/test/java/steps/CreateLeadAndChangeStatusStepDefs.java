package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.Header;
import pages.Leads;
import pages.MainPage;
import pages.Settings;

import java.util.List;

/**
 * Created by Bartek on 2017-10-07.
 */
public class CreateLeadAndChangeStatusStepDefs extends DriverFactory {
    private MainPage mainPage = new MainPage(driver);
    private Header header = new Header(driver);
    private Leads leads = new Leads(driver);
    private Settings settings = new Settings(driver);
    private PropertyReader propertyReader = new PropertyReader();
    private String tokenV1 = propertyReader.property().getProperty("tokenV1");
    private String tokenV2 = propertyReader.property().getProperty("tokenV2");
    private String username = propertyReader.property().getProperty("username");
    private String password = propertyReader.property().getProperty("password");

    @Before("@clearLeads")
    @After("@clearLeads")
    public void deleteAllLeads() {
        Response response1 = RestAssured.given().auth().oauth2(tokenV2)
                .contentType("application/json")
                .get("https://api.getbase.com/v2/leads")
                .andReturn();
        JsonPath jsonPath = new JsonPath(response1.getBody().asString());
        List<Integer> leadId = jsonPath.get("items.data.id");
        for (int id : leadId) {
            Response response2 = RestAssured.given().auth().oauth2(tokenV2)
                    .contentType("application/json")
                    .delete("https://api.getbase.com/v2/leads/" + id)
                    .andReturn();
        }

        Response response3 = RestAssured.given()
                .contentType("application/json")
                .header("X-FutureSimple-Token", tokenV1)
                .body("{\"status\":{\"id\":2261244,\"name\":\"New\",\"account_id\":709703,\"created_at\":\"2017-10-04T19:12:25Z\",\"updated_at\":\"2017-10-10T17:13:57Z\",\"is_new\":true,\"is_unqualified\":false,\"position\":-100000,\"has_original_name\":false,\"locale_key\":null,\"leads_count\":0}}")
                .put("https://app.futuresimple.com/apis/leads/api/v1/statuses/2261244.json")
                .andReturn();
    }

    @Given("^User is logged in$")
    public void userIsLoggedIn() {
        mainPage.openMainPage()
                .clickLogin()
                .writeEmail(username)
                .writePassword(password)
                .login();
    }

    @When("^User goes to Leads tab$")
    public void userGoesToLeadsTab() {
        header.clickLeadsTab();
    }

    @And("^User creates new Lead$")
    public void userCreatesNewLead(List<String> table) {
        leads.addNewLead()
                .setLeadFirstName(table.get(0))
                .setLeadLastName(table.get(1))
                .setLeadCompanyName(table.get(2))
                .clickSave();
    }

    @Then("^Newly created Lead should have \"([^\"]*)\" status$")
    public void newlyCreatedLeadShouldHaveStatus(String arg0) {
        Assert.assertEquals("Wrong default status visible!", arg0, leads.getLeadStatus());
    }

    @When("^User edits Lead status$")
    public void userEditsLeadStatus() {
        header.clickAvatar()
                .clickSettings()
                .clickCustomizeLeads()
                .clickLeadStatuses()
                .clickEditNewStatus()
                .writeNewStatusName()
                .clickSave();
    }

    @Then("^Status should be properly changed to \"([^\"]*)\"$")
    public void statusShouldBeProperlyChangedTo(String arg0) {
        header.clickLeadsTab();
        leads.editLead();
        Assert.assertEquals("Wrong status visible after edit!", arg0, leads.getLeadStatus());
    }
}
