#Author:santiago_pipe@hotmail.com
@Login
Feature: Newtours Login Functionality Feature
  In order to ensure Login Functionality works,
  I want to run the cucumber test to verify it is working

  Background: 
    Given lukas open Login Newtours

  @SmokeTest @LoginPass
  Scenario: Login to Newtours
    When he enter his username and password
      | username     | password |
      | santiago8112 | santi112 |
    And he does click on button sign in
    Then he validate tag "SIGN-OFF"

  @LoginFail
  Scenario Outline: Login to Newtours Fail
    When he enter his username and password
      | username   | password   |
      | <username> | <password> |
    And he does click on button sign in
    Then he validate tag "SIGN-OFF"

    Examples: 
      | username     | password |
      | santi122     | santi112 |
      |              | santi112 |
      | santiago8112 |          |
      |              |          |
