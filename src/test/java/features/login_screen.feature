@login
Feature: As user I should be able to login

  Background:
  Given User wants to login to the application
  And User is in the pop3 email screen

  Scenario: Existing Customer - User lands in password screen
    When User enters a valid email address
    And User clicks on CONTINUE button
    Then User lands on PASSWORD screen


    Scenario: New Customer - User lands in Profile Info screen
      When User enters a valid email address doesn't exists in email
      And User clicks on CONTINUE button
      Then User lands on Profile Info screen

      Scenario: User can not login with an invalid email address
      When User enters an invalid email address
        And User clicks on CONTINUE button
        And User clicks welcomepage
        Then User sees an error message


        Scenario: User can not login without email address
          When User enters an invalid email address without email
          And User clicks on CONTINUE button
          Then User sees errorr message







