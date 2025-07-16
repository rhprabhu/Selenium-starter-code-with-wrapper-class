package StepsDefinitions;

import Pages.UtilityFunctions;
import Pages.Configuration;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class StepsDefinitions1 {
    UtilityFunctions utilityFunctions = new UtilityFunctions();
    HomePage homePage = new HomePage();

    public StepsDefinitions1() {
        PageFactory.initElements(Configuration.driver, this);
    }

    @Given("user loads URL {string} in browser")
    public void userLoadsURLInBrowser(String arg0) {
        utilityFunctions.openUrl(arg0);
    }

    @And("waits for {int} seconds")
    public void waitsForSeconds(int arg0) throws InterruptedException {
        utilityFunctions.waits(arg0);
    }

    @Given("user loads Wikipedia URL in browser")
    public void userLoadsWikipediaURLInBrowser() {
        homePage.openHomePageURL();
    }

    @Then("Wikipedia homepage is displayed")
    public void wikipediaHomepageIsDisplayed() {
        homePage.IsWikipediaHomepageDisplayed();
    }

    @When("user enters {string} in Wikipedia search box")
    public void userEntersTestInWikipediaSearchBox(String keyword) {
        homePage.enterTextInSearchBox(keyword);
    }

    @When("user clicks on search icon in Wikipedia homepage")
    public void userClicksOnSearchIconInWikipediaHomepage() {
        homePage.clickOnSearchIcon();
    }

    @When("user refreshes current page")
    public void userRefreshesCurrentPage() {
        utilityFunctions.refreshCurrentPage();
    }

    @When("user navigates back to previous page")
    public void userNavigatesBackToPreviousPage() {
        utilityFunctions.navigatesBackToPreviousPage();
    }

    @Then("current tab URL contains {string}")
    public void currentTabURLContainsWwwGoogleCom(String url) {
        utilityFunctions.checkCurrentTabURL(url);
    }

    @And("user waits until current URL contains {string}")
    public void userWaitsUntilCurrentURLContainsWwwGoogleCom(String url) {
        utilityFunctions.checkCurrentTabURL(url);
    }
}
