Feature: Login feature

  Scenario: Login with a existent user
    Given An admin user saved in db
    When I login with admin user
    Then I should get http status OK for login