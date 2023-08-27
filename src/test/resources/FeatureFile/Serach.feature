Feature: Search Functionality

  Scenario: User search for a valid product
    Given User open the application
    When User enters valid product "HP" into Search box field
    And User clicks on seach button
    Then User should get valid product displayed in search results

  Scenario: User Search for an invalid product
    Given User open the application
    When User enters invalid product "Honda" into search box field
    And User clicks on seach button
    Then user should get a message about no product matching

  Scenario: User serach without any product
    Given User open the application
    When User do not enter any product name into search box field
    And User clicks on seach button
    Then user should get a message about no product matching
