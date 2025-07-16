package StepsDefinitions;

import Pages.UtilityFunctions;
import Pages.Configuration;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class StepsDefinitions2 {
    UtilityFunctions baseFunctions = new UtilityFunctions();
    HomePage homePage = new HomePage();

    public StepsDefinitions2() {
        PageFactory.initElements(Configuration.driver, this);
    }

    @Given("sample statement")
    public void sampleStatement() {
        // add code here
    }

    @And("sample statement 2")
    public void sampleStatement2() {
        // add code here
    }

    @Then("sample statement 3")
    public void sampleStatement3() {
        // add code here
    }

    @When("sample statement 4")
    public void sampleStatement4() {
        // add code here
    }
}
