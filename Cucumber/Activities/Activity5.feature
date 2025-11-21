@activity5
Feature: Login Test

  Scenario Outline: Testing Login with Example
    Given User is on the login page
    When User enters "<Usernames>" and "<Passwords>"
    And clicks the submit button
    Then User should see message "Invalid credentials"

  Examples:
    | Usernames    | Passwords   |
    | wrongUser1   | wrongPass1  |
    | demo         | demo123     |
    | testuser     | 12345       |
