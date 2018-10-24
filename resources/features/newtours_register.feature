#Author:santiago_pipe@hotmail.com
@Login1
Feature: Newtours Register Functionality Feature
  In order to ensure Register Functionality works,
  I want to run the cucumber test to verify it is working

  Background: 
    Given Lukas opens the Newtours register page

  @SmokeTest
  Scenario Outline: Register to Newtours
    When he enters the contact information
      | firstName   | lastName   | phone   | email   |
      | <firstName> | <lastName> | <phone> | <email> |
    When he enters the mailing information
      | address1   | address2   | city   | state   | postalCode   | country   |
      | <address1> | <address2> | <city> | <state> | <postalCode> | <country> |
    And he enters the user information
      | username   | password   | confirmPass   |
      | <username> | <password> | <confirmPass> |
		Then he sees the message Note: Your user name is "<username>"
    Examples: 
      | firstName | lastName | phone   | email                   | address1    |address2 | city   | state   | postalCode   | country   | username  | password   | confirmPass|
      | Santiago  | Alzate   |31244122 |santiago.alzate@gmail.com|calle 12#assq|         |medellin|antioquia|     45678    |  Colombia |santialzate| alzate112  |alzate112   |
      
