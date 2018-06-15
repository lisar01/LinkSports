Feature: Login feature

  Scenario: Login with and user saved
    Given An admin user saved in db
    When I login with admin user
    Then I should get Login exitoso message