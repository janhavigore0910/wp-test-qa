Feature: User vote for Buggy Car
  Description: The user will vote and verify later

  Background: : User is Logged In
    Given Buggy Cars Rating Home Page is visible to user
    When User submits Username and password
    Then User should be logged in

  Scenario Outline: User will vote and verify later
    Given User is on the Home Page
    And User clicks on "<Link>"
    When User selects buggy car "<Car>"
    And User clicks on vote
    Then User verifies the vote
    And User should logout

    Examples:
      |Link          |Car                |
      |Overall Rating|Rally 037          |