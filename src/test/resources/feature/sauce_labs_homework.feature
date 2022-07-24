Feature: Login feature
  As a user,
  I would prefer to be able to log in
  So that I can purchase products

  Scenario: Log in and successful purchase
    Given I navigate to login page
    And I login with 'standard_user' and 'secret_sauce'
    Then I am successfully logged in
    Given I add item to cart
    Then I navigate to cart page
    When I verify item in cart
    Then I go to checkout
    Given I fill in 'Name', 'Last' and 'LV-1099'
    Then I go to checkout continue
    Given I verify data in checkout overview
    Then I go to finish page
    When I verify checkout done successfully
    Then I go back to home page

  Scenario Outline: Log in and error message verification
    Given I navigate to login page
    And I login with 'standard_user' and 'secret_sauce'
    Then I am successfully logged in
    Then I navigate to cart page
    Then I go to checkout
    Given I fill in '<name>', '<lastName>' and '<postalCode>'
    Then I go to checkout continue
    Then I verify '<error>' message
  Examples:
    | name  | lastName | postalCode | error |
    |       | Last     | LV-1099    | Error: First Name is required  |
    | Name  |          | LV-1099    | Error: Last Name is required   |
    | Name  | Last     |            | Error: Postal Code is required |
