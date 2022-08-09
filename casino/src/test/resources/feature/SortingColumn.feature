Feature: Sorting Column

  Scenario: Sorting list of players
    Given I open the login page
    When I login as user
    And  I click Players button
    Then The list of players is displayed
    When I click External ID button
    Then External ID column is sorted
