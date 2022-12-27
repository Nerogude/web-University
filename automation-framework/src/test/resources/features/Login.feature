@login @regression

Feature: WebDriver University - Login Page

  Background:
    Given I access the webdriver university login page

    @smoke
  Scenario: Validate Successful Login - Specific Data
    When I enter a specific username webdriver
    And I enter a specific password webdriver123
    And I click on the login button
    Then I should be presented with a successful login validation message

  Scenario:  Validate Unsuccessful Login - Specific Data
    When I enter a specific username webdriver
    And I enter a specific password password123
    And I click on the login button
    Then I should be presented with an unsuccessful login validation message


  Scenario Outline:  Validate - Successful & Unsuccessful Login
    When I enter a specific username <username>
    And I enter a specific password <password>
    And I click on the login button
    Then I should be presented with the following login validation message <loginValidationMessage>

    Examples:
      | username  | password     | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | webdriver1   | validation failed      |
      | joe blogs | password1    | validation failed      |

