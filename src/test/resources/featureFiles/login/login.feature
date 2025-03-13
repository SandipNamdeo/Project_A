Feature: Login into flight search website
  This is a test description

  Scenario: Login Flow
    Given User opens "https://parabank.parasoft.com/parabank/index.htm" website
    Then User verifies if homepage is opened or not with "ParaBank | Welcome | Online Banking"
    When User enters value in "username" text field as "test@example.com"
    When User enters value in "password" text field as "Welcome@123"
    When User click on "Log In" button
    Then User verifies the "The username and password could not be verified." text is displayed
