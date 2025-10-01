Feature: Login Functionality Test

  Scenario Outline: Check login is successful with valid credentials
    Given User is on Login Page
    When User enters <username> and <password>
    And User clicks on login button
    Then User should be redirected to the Home page
    Examples:
      | username |password |
      | Admin    | admin123|