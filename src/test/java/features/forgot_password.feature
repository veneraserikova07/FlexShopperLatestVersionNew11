Feature: As user I should be able to change the password

  Background:
    Given User forgot the password
    And User is in the PASSWORD screen
    When User clicks on forgot password link
    And  User lands on Forgot Password screen

  Scenario: User with full information
    Given the user has an account with email and phone
    When user lands in Forgot Password screen
    Then User can see the email
    And user can see the phone

  Scenario: User with email and phone number
    Given the user has an account with email only
    When user lands in Forgot Password screen
    Then User can see the email

  Scenario: User lands in email screen by clicking Return to Password Sign In button
    And User clicks to Return to Password Sign In button
    Then user sees email screen

  Scenario: User lands in code screen
    And User clicks to Continue button
    Then User sees Security code field

  Scenario: User lands in ------- by clicking NO code received? link
    And User clicks Send email to button
    And User clicks Continue button
    And User clicks  to  NO code received? link
    Then User lands to Reset Password screen

  Scenario: User lands in ---------- by clicking NO code received? link
    And User clicks Send SMS text with code to button
    And User clicks Continue button
    And User clicks  to  NO code received? link
    Then User lands to Reset Password screen















