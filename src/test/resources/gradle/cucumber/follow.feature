# new feature
# Tags: optional
    
Feature: Follow user feature
    
Scenario: Logged in the system
    Given A logged user and a user to follow
    When I follow that user
    Then I should appear in his followers list