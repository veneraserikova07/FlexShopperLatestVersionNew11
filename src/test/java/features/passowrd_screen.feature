@password
Feature: As an existing customer, I should be able to enter the password in the password screen

  Background:
    Given User login to the application
    And user in the pop screen
  Scenario Outline: Existing Customer lands in Home Page as logged in user
    And User enters a "<email>" existing address
    And User clicks Continue button
    And User lands on Password screen
    When User enters an valid "<password>" password
    And User clicks on Sign In button
    Then User lands in the Home page as logged in user "<header>"
    Examples:
    |email              |password |header         |
    |nann40547@gmail.com|test123  |Ashley Zzelkova|

  Scenario Outline: Existing Customer can not land in Home Page as logged in user with invalid password
    And User enters a "<email>" existing address
    And User clicks Continue button
    And User lands on Password screen
    When User enters an invalid "<password>"
    And User clicks on Sign In button
    Then User should see "<errorMsg>" message
    Examples:
      |email               |  password               |  errorMsg                                                           |
      |nann40547@gmail.com |  test                   |  Invalid email or password: please check your details and try again |
      |nann40547@gmail.com |  123test                |  Invalid email or password: please check your details and try again |
      |nann40547@gmail.com |  a_B%%%%%%%%as          |  Invalid email or password: please check your details and try again |
      |nann40547@gmail.com |  a.a@abc@abc@ab         |  Invalid email or password: please check your details and try again |

  Scenario Outline: Existing Customer can not land in Home Page as logged in user without invalid password
    And User enters a "<email>" existing address
    And User clicks Continue button
    And User lands on Password screen
    When User enters an invalid "<password>" fld
    And User clicks on Sign In button
    Then user should see "<errorMsg>"
    Examples:
    |email                   |password|errorMsg|
    |nann40547@gmail.com     |        |Required|





























































