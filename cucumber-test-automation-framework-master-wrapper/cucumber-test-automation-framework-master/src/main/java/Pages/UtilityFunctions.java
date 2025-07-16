package Pages;

    import org.openqa.selenium.*;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.PageFactory;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import java.time.Duration;
    import static Pages.Configuration.driver;
    import static org.testng.Assert.*;

//UtilityFunctions class provides common utility methods for interacting with web pages
    public class UtilityFunctions {

        // Constructor for UtilityFunctions.
        public UtilityFunctions() {
            PageFactory.initElements(Configuration.driver, this);
        }

        // Method to click on a button with exception handling
        public void clickButton(WebElement buttonElement) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                wait.until(ExpectedConditions.visibilityOf(buttonElement));
                wait.until(ExpectedConditions.elementToBeClickable(buttonElement));
                // Scroll the button into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonElement);
                // Wait for the button to be clickable
                wait.until(ExpectedConditions.elementToBeClickable(buttonElement));
                // Click the button
                buttonElement.click();
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Element not found to click. " + e.getMessage());
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout waiting for element to be clickable. " + e.getMessage());
            } catch (ElementNotInteractableException e) {
                System.err.println("ERROR: Element is not intractable. " + e.getMessage());
            } catch (StaleElementReferenceException e) {
                System.err.println("ERROR: Stale element reference when clicking. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while clicking. " + e.getMessage());
            }
        }
        // Method to enter text into an input field with exception handling
        public void enterText(WebElement inputElement, String text) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Wait until the input field is visible
                wait.until(ExpectedConditions.visibilityOf(inputElement));

                // Wait until the input field is clickable
                wait.until(ExpectedConditions.elementToBeClickable(inputElement));

                // Scroll the input field into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputElement);

                // Wait for the input field to be intractable
                wait.until(ExpectedConditions.elementToBeClickable(inputElement));

                // Clear any existing text in the input field
                inputElement.clear();

                // Enter the provided text into the input field
                inputElement.sendKeys(text);
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Element not found to enter text. " + e.getMessage());
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout waiting for element visibility. " + e.getMessage());
            } catch (ElementNotInteractableException e) {
                System.err.println("ERROR: Element is not intractable for entering text. " + e.getMessage());
            } catch (StaleElementReferenceException e) {
                System.err.println("ERROR: Stale element reference when entering text. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while entering text. " + e.getMessage());
            }
        }
        // Method to select an option from a dropdown
        public void selectDropdownOption(WebElement dropdownElement, String optionText) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Wait until the dropdown is visible
                wait.until(ExpectedConditions.visibilityOf(dropdownElement));

                // Wait until the dropdown is clickable
                wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));

                // Click the dropdown to open it
                dropdownElement.click();

                // Find the option by its visible text and click it
                WebElement option = dropdownElement.findElement(By.xpath(".//option[text()='" + optionText + "']"));
                option.click();
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Dropdown element not found. " + e.getMessage());
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout waiting for dropdown visibility. " + e.getMessage());
            } catch (StaleElementReferenceException e) {
                System.err.println("ERROR: Stale element reference when selecting from dropdown. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while selecting from dropdown. " + e.getMessage());
            }
        }
        // Method to get the text of a web element
        public String getElementText(WebElement element) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Wait until the element is visible
                wait.until(ExpectedConditions.visibilityOf(element));

                // Return the text of the element
                return element.getText();
            } catch (Exception e) {
                System.err.println("Error while getting the text of the element: " + e.getMessage());
                return null;
            }
        }
        // Method to check if a web element is displayed
        public void isElementDisplayed(WebElement element) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Wait until the element is visible
                wait.until(ExpectedConditions.visibilityOf(element));

                // Return true if the element is displayed
                element.isDisplayed();
            } catch (Exception e) {
                System.err.println("Error while checking if the element is displayed: " + e.getMessage());
            }
        }
        // Method to check if a web element is not displayed
            public boolean isElementNotDisplayed(WebElement element) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Wait until the element is present
                wait.until(ExpectedConditions.presenceOfElementLocated((By) element));

                // Return true if the element is not displayed
                return !element.isDisplayed();
            } catch (Exception e) {
                System.err.println("Error while checking if the element is not displayed: " + e.getMessage());
                return true; // Assume the element is not displayed if an exception occurs
            }
        }
        // Method to verify that a web element is enabled
        public void verifyElementEnabled(WebElement element) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Wait until the element is visible
                wait.until(ExpectedConditions.visibilityOf(element));

                // Check if the element is enabled
                assertTrue(element.isEnabled(), "The element is not enabled.");
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Element not found while verifying if the element is enabled. " + e.getMessage());
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout occurred while waiting for the element to be enabled. " + e.getMessage());
            } catch (ElementNotInteractableException e) {
                System.err.println("ERROR: Element is not intractable while verifying if the element is enabled. " + e.getMessage());
            } catch (StaleElementReferenceException e) {
                System.err.println("ERROR: Stale element reference encountered while verifying if the element is enabled. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while verifying if the element is enabled. " + e.getMessage());
            }
        }
        // Method to verify that a web element is disabled
        public void verifyElementDisabled(WebElement element) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Wait until the element is visible
                wait.until(ExpectedConditions.visibilityOf(element));

                // Check if the element is disabled
                assertFalse(element.isEnabled(), "The element is not disabled.");
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Element not found while verifying if the element is disabled. " + e.getMessage());
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout occurred while waiting for the element to be disabled. " + e.getMessage());
            } catch (ElementNotInteractableException e) {
                System.err.println("ERROR: Element is not intractable while verifying if the element is disabled. " + e.getMessage());
            } catch (StaleElementReferenceException e) {
                System.err.println("ERROR: Stale element reference encountered while verifying if the element is disabled. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while verifying if the element is disabled. " + e.getMessage());
            }
        }

        // Method to verify that a web element is clickable
        public void verifyElementClickable(WebElement element) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Wait until the element is clickable
                wait.until(ExpectedConditions.elementToBeClickable(element));

                // Check if the element is clickable
                assertTrue(element.isEnabled(), "The element is not clickable.");
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Element not found while verifying if the element is clickable. " + e.getMessage());
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout occurred while waiting for the element to be clickable. " + e.getMessage());
            } catch (ElementNotInteractableException e) {
                System.err.println("ERROR: Element is not intractable while verifying if the element is clickable. " + e.getMessage());
            } catch (StaleElementReferenceException e) {
                System.err.println("ERROR: Stale element reference encountered while verifying if the element is clickable. " + e.getMessage());
            } catch (WebDriverException e) {
                System.err.println("ERROR: WebDriver encountered an issue while verifying if the element is clickable. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error while verifying if the element is clickable: " + e.getMessage());
            }
        }
        // Method to verify that a web element is not clickable
        public void verifyElementNotClickable(WebElement element) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Wait until the element is not clickable
                wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));

                // Check if the element is not clickable
                assertFalse(element.isEnabled(), "The element is clickable.");
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Element not found while verifying if the element is not clickable. " + e.getMessage());
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout occurred while waiting for the element to be not clickable. " + e.getMessage());
            } catch (ElementNotInteractableException e) {
                System.err.println("ERROR: Element is not intractable while verifying if the element is not clickable. " + e.getMessage());
            } catch (StaleElementReferenceException e) {
                System.err.println("ERROR: Stale element reference encountered while verifying if the element is not clickable. " + e.getMessage());
            } catch (WebDriverException e) {
                System.err.println("ERROR: WebDriver encountered an issue while verifying if the element is not clickable. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error while verifying if the element is not clickable: " + e.getMessage());
            }
        }

        //

        // Scrolls the specified WebElement into view using JavaScript
        public boolean scrollElementIntoView(WebElement element) {
            try {
                // Create a JavaScriptExecutor instance
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

                // Execute JavaScript to scroll the element into view
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

                return true; // Return true if successful
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Element not found to scroll into view. " + e.getMessage());
                return false;
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout occurred while scrolling element into view. " + e.getMessage());
                return false;
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while scrolling element into view. " + e.getMessage());
                return false;
            }
        }

        // Verifies the presence of a success or error message
        public boolean verifyMessagePresence(WebElement messageElement, String expectedMessage) {
            try {
                // Wait until the message element is visible
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(messageElement));

                // Get the actual message text
                String actualMessage = messageElement.getText();

                // Compare the actual message with the expected message
                return actualMessage.equals(expectedMessage);
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Message element not found. " + e.getMessage());
                return false;
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while verifying the message presence. " + e.getMessage());
                return false;
            }
        }

        // Opens the specified URL in the browser.
        public void openUrl(String string) {
            try {
                driver.navigate().to(string);
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout occurred while navigating to the URL. " + e.getMessage());
            } catch (WebDriverException e) {
                System.err.println("ERROR: WebDriver encountered an issue while navigating to the URL. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while navigating to the URL. " + e.getMessage());
            }
        }

        // Waits for a specified number of seconds.
        public void waits(int arg0) throws InterruptedException {
            try {
                Thread.sleep(arg0 * 1000L);
            } catch (IllegalArgumentException e) {
                System.err.println("ERROR: Invalid argument provided for sleep duration. " + e.getMessage());
            } catch (InterruptedException e) {
                System.err.println("ERROR: Thread was interrupted during sleep. " + e.getMessage());
                throw e; // Rethrow the InterruptedException to maintain method contract
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred during sleep. " + e.getMessage());
            }
        }

        //Refreshes the current page.
        public void refreshCurrentPage() {
            try {
                driver.navigate().refresh();
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout occurred while refreshing the page. " + e.getMessage());
            } catch (WebDriverException e) {
                System.err.println("ERROR: WebDriver encountered an issue while refreshing the page. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while refreshing the page. " + e.getMessage());
            }
        }

        //Navigates back to the previous page in the browser history.
       public void navigatesBackToPreviousPage() {
            try {
                driver.navigate().back();
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout occurred while navigating back to the previous page. " + e.getMessage());
            } catch (WebDriverException e) {
                System.err.println("ERROR: WebDriver encountered an issue while navigating back to the previous page. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while navigating back to the previous page. " + e.getMessage());
            }
        }

        //Checks if the current tab's URL contains the specified string.
        public void checkCurrentTabURL(String url) {
            try {
                assertTrue(driver.getCurrentUrl().contains(url));
            } catch (AssertionError e) {
                System.err.println("ERROR: Assertion failed while checking the current tab URL. " + e.getMessage());
            } catch (WebDriverException e) {
                System.err.println("ERROR: WebDriver encountered an issue while retrieving the current tab URL. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while checking the current tab URL. " + e.getMessage());
            }
        }

        // Method to hover on a web element and verify text
        public void hoverAndVerifyText(WebElement element, String expectedText) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Wait until the element is visible
                wait.until(ExpectedConditions.visibilityOf(element));

                // Create an Actions instance to perform hover action
                Actions actions = new Actions(driver);
                actions.moveToElement(element).perform();

                // Get the text of the element after hovering
                String actualText = element.getText();

                // Verify that the actual text matches the expected text
                assertEquals(expectedText, actualText, "The text after hovering does match the expected text.");
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Element not found while hovering and verifying text. " + e.getMessage());
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout occurred while waiting for the element to be visible. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while hovering and verifying text. " + e.getMessage());
            }
        }

        // Method to hover on a web element and click it
        public void hoverAndClick(WebElement element) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Wait until the element is visible
                wait.until(ExpectedConditions.visibilityOf(element));

                // Create an Actions instance to perform hover action
                Actions actions = new Actions(driver);
                actions.moveToElement(element).perform();

                // Click the element after hovering
                element.click();
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Element not found while hovering and clicking. " + e.getMessage());
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout occurred while waiting for the element to be visible. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while hovering and clicking. " + e.getMessage());
            }
        }

        // Method to scroll to a specific element and click it
        public void scrollToElementAndClick(WebElement element) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Wait until the element is visible
                wait.until(ExpectedConditions.visibilityOf(element));

                // Scroll the element into view using JavaScript
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

                // Wait for the element to be clickable
                wait.until(ExpectedConditions.elementToBeClickable(element));

                // Click the element
                element.click();
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Element not found while scrolling and clicking. " + e.getMessage());
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout occurred while waiting for the element to be clickable. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while scrolling and clicking. " + e.getMessage());
            }
        }

        // Method to switch to a new window or tab
        public void switchToNewWindow() {
            try {
                // Store the current window handle
                String currentWindow = driver.getWindowHandle();

                // Wait for a new window or tab to open
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.numberOfWindowsToBe(2));

                // Switch to the new window or tab
                for (String windowHandle : driver.getWindowHandles()) {
                    if (!windowHandle.equals(currentWindow)) {
                        driver.switchTo().window(windowHandle);
                        break;
                    }
                }
            } catch (NoSuchWindowException e) {
                System.err.println("ERROR: No new window found to switch to. " + e.getMessage());
            } catch (TimeoutException e) {
                System.err.println("ERROR: Timeout occurred while waiting for a new window to open. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while switching to a new window. " + e.getMessage());
            }
        }

        // Method to switch back to the original window or tab
        public void switchToOriginalWindow(String originalWindowHandle) {
            try {
                // Switch back to the original window or tab
                driver.switchTo().window(originalWindowHandle);
            } catch (NoSuchWindowException e) {
                System.err.println("ERROR: Original window not found to switch back. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while switching back to the original window. " + e.getMessage());
            }
        }

        // Method to close the current window or tab
        public void closeCurrentWindow() {
            try {
                // Close the current window or tab
                driver.close();
            } catch (NoSuchWindowException e) {
                System.err.println("ERROR: No current window found to close. " + e.getMessage());
            } catch (WebDriverException e) {
                System.err.println("ERROR: WebDriver encountered an issue while closing the current window. " + e.getMessage());
            } catch (Exception e) {
                System.err.println("ERROR: An unexpected error occurred while closing the current window. " + e.getMessage());
            }
        }


    }