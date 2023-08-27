Feature: Registration Functionality

  Scenario: User Creates an account only with mandatory fields
    Given User navigates to Register Account page
    When User enters the below fields
      | firstName | Arun   |
      | lastname  | World  |
      | telephone | 123466 |
      | password  |  12345 |
    And User selects privacy policu
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User Creates an account with all field
    Given User navigates to Register Account page
    When User enters the below fields
      | firstName | Arun   |
      | lastname  | World  |
      | telephone | 123466 |
      | password  |  12345 |
    And User selects yes for newzletter
    And User selects privacy policu
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User Creates a duplicate account
    Given User navigates to Register Account page
    When User enters the below fields with duplicate
      | firstName | Arun   |
      | lastname  | World  |
      | email     | arunworld@gmail.com | 
      | telephone | 123466 |
      | password  |  12345 |
    And User selects yes for newzletter
    And User selects privacy policu
    And User clicks on continue button
    Then User should get a proper warning about duplicate email

  Scenario: User Creates an account without filling any details
    Given User navigates to Register Account page
    When User dont enter any details into fields
    And clicks on Continue button
    Then User should get proper warning messages for every mandatory field
