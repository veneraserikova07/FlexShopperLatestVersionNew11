
Feature: As user I should be able to change the password

#Assert forgot password screen

  Background:
  Given user lands ann app
    And user on pop up screen
    And user enter existing email "nann40547@gmail.com" address
    And user clicks continue button
    And user lands on password screen
    And user clicks forgot password link

  Scenario: User with full information lands on forgot password screen
    Then user should see firstText "How would you like to reset your password? You can verify by email or request a text to be sent to the mobile number linked to your account."
    And user should see secondText "Please choose one of the options below:"
    And user should be able to see text "Send email to:" of radiobutton for email
    And user should be able to see text "Send SMS text with code to:" of radiobutton for text message
    And user should be able to click on continue button


  #verify Return to Password Sign In button functionality

    Scenario: User with full information by clicking Return to password Sign In button should be able to return tomPassword screen
  And user clicks Return to Password Sign In link
  Then user should see psdScreen

@wip
   #verify email forgot password
  Scenario: User should be able to get password to email
  And user clicks sent Email to radio button
  And user clicks Continue button
  And code is sent using check email to insert code text box
  Then user should see we sent you code message
  And user should get code



    #verify No code received button functionality
  Scenario:  user
    And user clicks sent Email to radio button
    And user clicks Continue button
  And user clicks No Code received? button
  Then user should see reset password screen




    #verify login with old password after password was resetted
  Scenario:

    And user clicks sent Email to radio button
    And user clicks Continue button
    And code is sent using check email to insert code text box
    Then user should see we sent you code message
    And user should get code
  And user clicks submit button
  And user enter reset "test123" password
  And user  clicks save changes
    And user lands on app
    And user on pop up screen
    And user enter existing email "nann40547@gmail.com" address
    And user clicks continue button
    And user lands on password screen
    And user enters new "test123"password
  And user should see dashboard page



  Scenario: Old password/ invalid scenario
    And user clicks sent Email to radio button
    And user clicks Continue button
    And code is sent using check email to insert code text box
    Then user should see we sent you code message
    And user should get code
    And user clicks submit button
    And user enter reset password
    And user  clicks save changes
    And user lands on app
    And user on pop up screen
    And user enter existing email "nann40547@gmail.com" address
    And user clicks continue button
    And user lands on password screen
    And user enters old  password
    And user should see error message












  #assert code screen




  #verify sms forgot password (may be available through google voice api)


























