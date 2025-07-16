@Debug1
Feature: Debug 1

  Scenario: Sample Scenario name 1
    Given user loads URL 'https://www.google.com/' in browser
    And user waits until current URL contains 'www.google.com'
    Then current tab URL contains 'www.google.com'
    And waits for 5 seconds

  Scenario: Sample Scenario name 2
    Given user loads URL 'https://www.google.com/' in browser
    Then current tab URL contains 'www.wikipedia.org'
    And waits for 2 seconds