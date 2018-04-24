Feature: IGA website functional test

  Background:
    Given IGA home page

  @IGA
  Scenario: Checking login page is available
    When I click My account
    Then the login page is up

  @IGA
  Scenario: Checking login page is available
    When I click My account
    Then the login page is up
