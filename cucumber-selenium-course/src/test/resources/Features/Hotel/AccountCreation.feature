Feature: Hotel Account Creation

  @regression
  Scenario: Create hotel account
    Given The user loaded the hotel main page
    When The user clicks Sign in button
      And The user fills in email and selects Create an account
      And The user fills in the registration form
      And The user press register
    Then The user should see the account created

  @regression
  Scenario Outline: Create accounts for multiple users
    Given The user loaded the hotel main page
    When The user clicks Sign in button
    And The user fills in email and selects Create an account
    And The user fills in first name "<firstName>" and surname "<surname>" with password "<password>"
    And The user press register
    Then The user should see the account created

    Examples:
      | firstName | surname | password |
      | TestA     | UserA   | Pass123  |
      | TestB     | UserB   | Pass456  |
      | TestC     | UserC   | Pass789  |
