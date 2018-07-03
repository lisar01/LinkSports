Feature: Search feature

  Scenario: Search user by sport
    Given Three users in db
    When I search for Tenis players
    Then I should get only two users from db