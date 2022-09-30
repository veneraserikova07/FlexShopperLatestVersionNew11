@login
Feature: As an existing customer, I should be able to enter the password in the password screen

  Background:
    Given User login to the application
    And user in the pop screen
    And User enters a "nann40547@gmail.com" existing address
    And User clicks Continue button
    And User lands on Password screen

  Scenario: Existing Customer lands in Home Page as logged in user
    When User enters an valid "test123" password
    And User clicks on Sign In button
    Then User lands in the Home page as logged in user "Ashley Zzelkova"

  Scenario Outline: Existing Customer can not land in Home Page as logged in user with invalid password
    When User enters an invalid "<password>"
    And User clicks on Sign In button
    Then User should see "<errorMsg>" message
    Examples:
      |  password               |  errorMsg                                                           |
      |  test                   |  Invalid email or password: please check your details and try again |
      |  123test                |  Invalid email or password: please check your details and try again |
      |  a_B%%%%%%%%as          |  Invalid email or password: please check your details and try again |
      |  a.a@abc@abc@ab         |  Invalid email or password: please check your details and try again |

  Scenario: Existing Customer can not land in Home Page as logged in user without invalid password
    When User enters an invalid "" empty field
    And User clicks on Sign In button
    Then User should be able  see "Required" message






