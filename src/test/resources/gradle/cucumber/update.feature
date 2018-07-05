Feature: Update feature

  Scenario: Update a user
    Given A user
    When I update that user
    Then I should update the user in db and get it back