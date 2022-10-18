
Feature: As user I should be able to change the password

  Background:
    Given user forgot the password

  # assert forgot password screen
  Scenario Outline: User with full information in the profile can see the email and the phone number provided
    When the user clicks on the Forgot Password link
    Then user should see firstText "<firstText>"
    And user should see secondText "<secondText>"
    And user should be able to see email "<email>"
    And user should be able to see text "<phoneNumber>"
      And user should be able to click on continue button
    Examples:
    |firstText                                                                                                                                    |secondText                             | email             | phoneNumber|
    | How would you like to reset your password? You can verify by email or request a text to be sent to the mobile number linked to your account.|Please choose one of the options below:|nann40547@gmail.com|xxx-xxx-3966|

  #verify Return to Password Sign In button functionality
  Scenario: User is able to return to the Email screen
    When the user clicks on the Forgot Password link
    And user clicks Return to Password Sign In link
    Then user should see email screen

    #verify No code received button functionality for Email
  Scenario Outline:  user with email should be able to click to No code received link
    When the user clicks on the Forgot Password link
    And user clicks sent Email to radio button
    And user clicks Continue button
    And user clicks on No Code received? button
    Then user should see forgot password screen with "<email>"
    And user should see forgot psd scr with "<phoneNumber>"
    Examples:
    |email                 |phoneNumber  |
    |nann40547@gmail.com   | xxx-xxx-3966|

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
      | nann40547@gmail.com |
    # Assert code screen - Code sent to Phone NUmber
  Scenario Outline: User with phone information in the profile should see the Code screen
    When the user clicks on the Forgot Password link
    And And user clicks sent SMS  to radio button
    And user clicks Continue button
    Then the user should land on the "We sent you a code" screen
    And the user should see the phoneNumber text: "<phoneNumber>"
    And user see Security Code field
    Examples:
      | phoneNumber  |
      | xxx-xxx-3966 |

     #verify No code received button functionality for Phone Number
  Scenario Outline:  user with Phone Number should be able to click to No code received link
    When the user clicks on the Forgot Password link
    And And user clicks sent SMS  to radio button
    And user clicks Continue button
    And user clicks on No Code received? button
    Then user should see forgot password screen with "<email>"
    And user should see forgot psd scr with "<phoneNumber>"
    Examples:
      |email                 |phoneNumber  |
      |nann40547@gmail.com   | xxx-xxx-3966|
   #verify email forgot password with Email
  Scenario: User should be able to receive the verification code in the email
    When the user clicks on the Forgot Password link
    And user clicks sent Email to radio button
    And user clicks Continue button
    And the user retrieves the verification code from the email and send to security code field
    And the user clicks on the submit button
    Then the user lands on the "Change Password" screen

    #verify login with new password after password was reseted (Positive)
  Scenario Outline: User can login with the new password
    Given User on Change Password Screen
    When  user enter reset "<newPassword>" password
    And user  clicks save changes
    And user clicks to sign out
    And user clicks sign in module
    And user clicks on Not You? Sign In or Apply Now link
    And user enter existing email "<email>"
    And user clicks continue btn
    And user lands on password scrn
    And user enter new "<newPassword>" password
    And user click sign in button
    Then user lands in the Home page as logged in user "<header>"
    Examples:
    |email                |newPassword|header         |
    |nann40547@gmail.com  |test123    |Ashley Zzelkova|


    #verify login with old password after password was reseted (Negative)
  Scenario Outline: User cannot login with the old password
    Given User on Change Password Screen
    When  user enter reset "<newPassword>" password
    And user  clicks save changes
    And user clicks to sign out
    And user clicks sign in module
    And user clicks on Not You? Sign In or Apply Now link
    And user enter existing email "<email>"
    And user clicks continue btn
    And user lands on password scrn
    And user enter old "<oldPassword>" psd
    And user click sign in button
    Then user can't login to dashboard page amd see error "<validationMessage>" message
    Examples:
      |  email              | oldPassword | validationMessage                                                   |newPassword|
      | nann40547@gmail.com | test1231     | Invalid email or password: please check your details and try again |test123    |


  Scenario Outline: User with phone information in the profile should see the "Code" screen
   # Given the user is on the "Forgot Password" screen
   #And the sent "Send SMS" radio button is selected
  # When the user clicks on the "Continue" button
   # Then the user lands on the "We sent you a code" screen
  #  And the user should see the text: "<firstText>"
  # And the user should see the text: "<secondText>"
  # And the user should see the email: "<phone>"

   Examples:
      | firstText           | secondText                         |   phone      |
      | We sent you a code  | Enter verification code we sent to | xxx-xxx-3966 |


  #verify sms forgot password (may be available through google voice api)











