Feature: Shopping Cart Checkout

  Scenario: User adds a product to the cart and successfully completes the checkout
    Given the user is logged in
    When the user searches for "Palm Treo Pro" in the search bar
    And the user selects a quantity of "2" for the product
    And the user moves to the shopping cart page
    Then the product quantity in the cart should be "2"
    And the user captures the price of the product
    And the user proceeds to the checkout page
    When the user enters the billing address details
    And the user enters the delivery details
    And the user selects a delivery method
    And the user verifies the captured price on the checkout page
    And the user enters the payment method
    And the user confirms the order
    Then a success message should be displayed
    And the user verifies the order ID in the Order History page
  Scenario: User tries to checkout without selecting a product
    Given the user is logged in
    When the user moves to the shopping cart page
    Then the cart should be empty
    And the user cannot proceed to the checkout page

  Scenario: User selects a quantity greater than available stock
    Given the user is logged in
    When the user searches for "Palm Treo Pro" in the search bar
    And the user selects a quantity of "10" for the product
    Then an error message should indicate insufficient stock

  Scenario: User enters invalid billing address
    Given the user is logged in
    When the user searches for "Product" in the search bar
    And the user selects a quantity of "1" for the product
    And the user moves to the shopping cart page
    And the user proceeds to the checkout page
    When the user enters an invalid billing address
    Then an error message should be displayed

  Scenario: User selects an invalid delivery method
    Given the user is logged in
    When the user searches for "Palm Treo Pro" in the search bar
    And the user selects a quantity of "5" for the product
    And the user moves to the shopping cart page
    And the user proceeds to the checkout page
    When the user enters the billing address details
    And the user enters the delivery details
    And the user selects an invalid delivery method
    Then an error message should be displayed

  Scenario: User tries to checkout with an empty cart
    Given the user is logged in
    When the user searches for "Palm Treo Pro" in the search bar
    And the user selects a quantity of "4" for the product
    And the user moves to the shopping cart page
    And the user removes all items from the cart
    Then the cart should be empty
    And the user cannot proceed to the checkout page
