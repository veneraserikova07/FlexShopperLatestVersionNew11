@wip
Feature: As user I should be able to change the password

  Background:
    Given user without full information forgot the password

  # assert forgot password screen
  Scenario Outline: User without full information in the profile can see the email and the phone number provided
    When the user clicks on the "Forgot Password" link
    Then user should see firstText "<firstText>"
    And user should see secondText "<secondText>"
    And user should be able to see email "<email>"
    And user should be able to click on continue button
    Examples:
      |firstText                                                                                                                                    |secondText                             | email             |
      | How would you like to reset your password? You can verify by email or request a text to be sent to the mobile number linked to your account.|Please choose one of the options below:|abc_123@gmail.com|

    #verify Return to Password Sign In button functionality
  Scenario: User is able to return to the Email screen
    When the user clicks on the Forgot Password link
    And user clicks Return to Password Sign In link
    Then user should see email screen

     # Assert code screen - Code sent to Email
  Scenario Outline: User with phone information in the profile should see the Code screen
    When the user clicks on the Forgot Password link
    And user clicks sent Email to radio button
    And user clicks Continue button
    Then the user should land on the "We sent you a code" screen
    And the user should see the email text: "<email>"
    And user see Security Code field
    Examples:
      | email               |
      | abc_123@gmail.com   |

#verify No code received button functionality for Email
  Scenario Outline:  user with email should be able to click to No code received link
    When the user clicks on the Forgot Password link
    And user clicks sent Email to radio button
    And user clicks Continue button
    And user clicks on No Code received? button
    Then user should see forgot password screen with "<email>"
    Examples:
      |email             |
      |abc_123@gmail.com |
