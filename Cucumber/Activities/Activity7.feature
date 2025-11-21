@activity7
Feature: Login Test - Reporting Enhancement

  Scenario: Testing Login for Reporting
    Given User is on the login page
    When User enters "admin" and "password"
    And clicks the submit button
    Then User should see message "Welcome Back, admin"
