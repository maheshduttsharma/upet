Feature: Signup

  Scenario: signup on upet
    Given user is on the upet signup page and fill the information
    When clicks the signup button
    Then user is taken to the dashboard
    And user upload the profile picture