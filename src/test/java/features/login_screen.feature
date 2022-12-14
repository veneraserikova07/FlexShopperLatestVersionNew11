@login
Feature: As user I should be able to login

  Background:
    Given User wants to login to the application
    And User is in the pop3 email screen

    Scenario Outline: Existing Customer - User lands in password screen
    When User enters a valid "<email>" existing address
    And User clicks on CONTINUE button
    Then User lands on PASSWORD screen
      Examples:
      |email              |
      |nann40547@gmail.com|

   Scenario Outline: New Customer - User lands in Profile Info screen
     When User enters a valid "<email>" non-existing address
    And User clicks on CONTINUE button
    Then User lands on Profile Info screen
    Examples:
    |email           |
    |abcde@gmail.com |
    Scenario Outline: Login fail - with an invalid email
    When User enters an invalid "<email>" address
    And User clicks on CONTINUE button
    And User clicks on Welcome to
    Then User sees "<errorMsg>" message
    Examples:
      |  email                  |  errorMsg              |
      |  @abc@flexshopper.com   |  Invalid email address |
      |  @flexshopper           |  Invalid email address |
      |  abc@a                  |  Invalid email address |
      |  a.a@abc@abc@ab         |  Invalid email address |
      |                         |  Invalid email address |






