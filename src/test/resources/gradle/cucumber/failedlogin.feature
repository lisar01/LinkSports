Feature: Login feature

  Scenario: Login with a non existent user
    Given A user not saved in db
    When I login with the user
    Then I should get http status BAD REQUEST for login