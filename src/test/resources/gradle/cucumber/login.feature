Feature: Login feature

  Scenario: Login with and user saved
    Given
    When I login with admin user
    Then I should get Login exitoso message