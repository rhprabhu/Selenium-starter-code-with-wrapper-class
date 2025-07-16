@SmokeTest
@HomePage
Feature: Home Page features

  Scenario: Access Wikipedia home page and verify
    Given user loads Wikipedia URL in browser
    Then Wikipedia homepage is displayed
    When user enters 'test' in Wikipedia search box
    When user clicks on search icon in Wikipedia homepage
    And waits for 5 seconds
    When user refreshes current page
    When user navigates back to previous page