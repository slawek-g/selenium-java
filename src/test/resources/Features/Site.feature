@TEST_AUTOMATION_PRACTICE
Feature: Test Automation

  @TC1
  Scenario Outline: Login with proper credentials
    Given user is on test automation page and use '<login>'
    And user is on inventory page
    Examples:
      | login                   |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |

  @TC2 @Negative
  Scenario: Login with incorrect credentials
    Given user is on test automation page and tries to login
    When user verifying automation homepage
    Then user get error message

  @TC3
  Scenario: Login with locked user
    When user is on test automation page and tries to login with specific login
    Then user get response

  @TC4
  Scenario Outline: Inventory page
    Given user is on test automation page and use 'standard_user'
    When user is on inventory page
    Then user is buying BackPack and Bike Light
    And user check his cart
    And fill all data, first name '<name>' surname '<surname>' and postal code '<postal>'
    And confirm total payment
    And finish order
    Examples:
      | name | surname | postal  |
      | John | Smith   | 123456  |
      | Will | Butch   | 5673    |
      | Buzz | Fizz    | 9999999 |
