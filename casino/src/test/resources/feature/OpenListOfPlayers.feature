Feature: Opening List of Players

  Scenario: Open the list of players
    Given I open the login page
    When I login as user
    And  I click Players button
    Then The list of players is displayed