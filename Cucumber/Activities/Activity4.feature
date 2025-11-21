@activity4
Feature: Login Test

  Scenario: Testing Login without Examples
    Given User is on the login page
    When User enters "admin" and "password"
    And clicks the submit button
    Then User should see message "Welcome Back, admin"
