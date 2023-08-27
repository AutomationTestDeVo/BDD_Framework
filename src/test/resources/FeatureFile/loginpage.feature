Feature: Login Fuctionality

  Scenario Outline: Login with valid credential
    Given User navigates to login page
    When User Enters valid email address <username> into email field
    And User has Entered valid password <password> into password field
    And Clicks on Login button
    Then User gets successfully logged in

    Examples: 
      | username         						| password   |
      | seletesting@yopmail.com  		| helloworld |
      | hello1@gmail.com 						| helloworld |
      | hello2@gmail.com 						| helloworld |

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters invalid password "1234567890" into password filed
    And clicks on login button
    Then User should get a warning message about credentials mismatch

  Scenario: Login with valid email address and invalid password
    Given User navigates to login page
    When User enters valid email address "hello@gmail.com" into email field
    And User enters invalid password "1234567890" into password filed
    And clicks on login button
    Then User should get a warning message about credentials mismatch

  Scenario: Login with invalid email and valid login password
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters valid password "helloworld" into password filed
    And clicks on login button
    Then User should get a warning message about credentials mismatch

  Scenario: Login without any credentials
    Given User navigates to login page
    When User do not enters any email address into email field
    And User do not enters any password into password field
    And clicks on login button
    Then User should get a warning message about credentials mismatch
