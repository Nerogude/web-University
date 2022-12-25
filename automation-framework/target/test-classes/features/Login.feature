@login

Feature: WebDriver University - Login Page

  Scenario: Validate Successful Login - Specific Data
    Given I access the webdriver university login page
    When I enter a specific username "webdriver"
    And I enter a specific password webdriver123
    And I click on the login button
    Then I should be presented with a successful login validation message

  Scenario:  Validate Unsuccessful Login - Specific Data
    Given I access the webdriver university login page
    When I enter a specific username "webdriver"
    And I enter a specific password password123
    And I click on the login button
    Then I should be presented with an unsuccessful login validation message

