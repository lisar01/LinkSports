Feature: Signup feature

  Scenario: Signup a user
    Given An user
    When I Register that user
    Then I should get Registro exitoso message