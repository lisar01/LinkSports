Feature: Gradle-Cucumber integration

  Scenario: Get request to Test controller
    When I do a GET request to Test controller
    Then I should get OK Response
