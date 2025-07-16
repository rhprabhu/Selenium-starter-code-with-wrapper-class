// Test runner for running tests using TestNg
package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(features = "src/test/resources/Features",
        glue = {""},
        tags = "@HomePage",  //Specify tags to run related test cases. Leave blank to run all test cases. Examples: @HomePage,@Debug1,@SmokeTest
        dryRun = false,  // Set to true to dry run the test cases (Does not run actual test cases)
        snippets = CAMELCASE,
        plugin = {"pretty", "html:target/cucumberReports/report.html", "json:target/cucumberReports/cucumber.json"}) // cucumber built-in test report plugin

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}