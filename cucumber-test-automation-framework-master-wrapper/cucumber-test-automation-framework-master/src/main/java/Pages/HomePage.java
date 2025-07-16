package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Pages.Configuration.driver;
import static Pages.Configuration.testdata;
import static org.testng.Assert.assertTrue;
import Pages.UtilityFunctions;

public class HomePage {
    UtilityFunctions utilityFunctions = new UtilityFunctions();
    @FindBy(xpath = "//*[@id='www-wikipedia-org']")
    WebElement wikipediaHomePage;
    @FindBy(xpath = "//*[@id='searchInput']")
    WebElement wikipediaHomePageSearchBox;
    @FindBy(xpath = "//*[@id='search-form']//button")
    WebElement wikipediaHomePageSearchIcon;

    public HomePage() {
        PageFactory.initElements(Configuration.driver, this);
    }

    public void openHomePageURL() {
        utilityFunctions.openUrl(testdata.getProperty("WikipediaURL"));
    }

    public void IsWikipediaHomepageDisplayed() {
        utilityFunctions.isElementDisplayed(wikipediaHomePage);
    }

    public void enterTextInSearchBox(String keyword) {
        utilityFunctions.enterText(wikipediaHomePageSearchBox, keyword);
    }

    public void clickOnSearchIcon() {
        utilityFunctions.clickButton(wikipediaHomePageSearchIcon);
    }
}
