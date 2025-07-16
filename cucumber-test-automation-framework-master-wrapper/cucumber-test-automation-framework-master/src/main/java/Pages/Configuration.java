package Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

// Configuration class handles the setup and teardown of the WebDriver.
// Constructor to initialize PageFactory elements.
public class Configuration {

    // WebDriver instance used across the application.
    public Configuration() {
        PageFactory.initElements(Configuration.driver, this);
    }

    // WebDriver instance used across the application.
    public static WebDriver driver;

    // Properties object to store test data.
    public static Properties testdata;

    // Properties object to store configuration data.
    public static Properties config;

    // Sets up the WebDriver and initializes properties before each test scenario.
    @Before
    public void setUp() throws Exception {
        initialiseProperties();
        if (config.getProperty("browser").equals("Chrome")) {
            WebDriverManager.chromedriver().clearDriverCache().setup();
            ChromeOptions options = getChromeOptions();
            driver = new ChromeDriver(options);
        } else if (config.getProperty("browser").equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless"); // Uncomment to run in headless mode
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--allow-running-insecure-content");
            driver = new FirefoxDriver(options);
        } else if (config.getProperty("browser").equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = getEdgeOptions();
            driver = new EdgeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // Provides Edge-specific browser options.
    private static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless"); // Uncomment to run in headless mode
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-setuid-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        return options;
    }

    // Provides Chrome-specific browser options.
    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // Uncomment to run in headless mode
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-setuid-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        return options;
    }

    // Tears down the WebDriver after each test scenario.
    // Takes a screenshot if the scenario fails and attaches it to the report.
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Takes a screenshot and attaches it to the report if the scenario fails.
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            System.out.println(driver.getCurrentUrl()); // Prints the URL of the failed page.
        }
        // driver.quit(); // Uncomment to quit the WebDriver after each scenario.
    }

    // Initializes the properties files for test data and configuration.
    public void initialiseProperties() throws IOException {
        testdata = new Properties();
        FileInputStream ip1 = new FileInputStream("src/test/resources/testdata.properties");
        testdata.load(ip1);

        config = new Properties();
        FileInputStream ip2 = new FileInputStream("src/test/resources/config.properties");
        config.load(ip2);
    }
}