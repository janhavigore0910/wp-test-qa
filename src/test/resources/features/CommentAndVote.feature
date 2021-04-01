Feature: Comment and Vote for Buggy Car
Description: The user will comment, vote and verify later

  Background: : User is Logged In
    Given Buggy Cars Rating Home Page is visible to user
    When User submits Username and password
    Then User should be logged in

  Scenario Outline: User will comment, vote and verify later
    Given User is on the Home Page
    And User clicks on "<Link>"
    When User selects buggy car "<Car>"
    And User enter comment "<Comment>"
    And User clicks on vote
    Then User verifies the comment "<Comment>"
    And User should logout

    Examples:
    |Link          |Car                |Comment    |
    |Overall Rating|Guilia Quadrifoglio|Amazing car|