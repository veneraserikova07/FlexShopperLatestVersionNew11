@wip
Feature: As an existing customer I should be able to land to home Page

  Background:
    Given User wants to login to the application
    And User is in the pop3 email screen
    When User enters a valid email address
    And User clicks on CONTINUE button
    Then User lands on PASSWORD screen

    Scenario: Existing Customer lands in Home Page as logged in user
      When User enters an valid password
      And User clicks on Sign In button
      Then User lands in the Home page as logged in user


      Scenario: Existing Customer can not land in Home Page as logged in user with invalid password
        When User enters an invalid password
      And User clicks on Sign In button
        Then User should sees an error message


        Scenario: Existing Customer can not land in Home Page as logged in user without password
          When User doesn't enter password
       And User clicks on Sign In button
          Then user sees an error message


