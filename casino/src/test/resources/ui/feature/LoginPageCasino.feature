Feature: Login Page Casino

  Scenario: Login with valid credentials
    Given I open the login page
    Then Login page is opened
    When I login as user
    Then User is logged
