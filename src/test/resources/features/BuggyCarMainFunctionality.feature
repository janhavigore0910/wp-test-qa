Feature: Buggy Car Main Functionality
Description: The purpose of this test is to verify User home page details are displayed successfully.

  Background: : User is Logged In
    Given Buggy Cars Rating Home Page is visible to user
    When User submits Username and password
    Then User should be logged in

  Scenario Outline: Verify User home page & "<Link>" page is displayed correctly
    Given User is on the Home Page
    When All the links and details are displayed correctly
    Then User clicks on "<Link>"
    And Verifies the "<Link>" page is loaded correctly
    And User should logout

    Examples:
    |Link        |
    |Popular Make|