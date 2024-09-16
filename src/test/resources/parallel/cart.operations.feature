@cart
Feature: The Coffee user updates different coffee orders in the shopping cart
  Rule: The user opens the coffee page and checks the details of Cappuccino coffee
    Background:
      Given I open the coffee shop online
      And I check "Cappuccino" price, cart status and total amount on home page

    Example: The user can add a coffee in the cart using right click
      When I right click on "Cappuccino"
      When I clicked "Yes" to add in the cart
      Then I should see that one "Cappuccino" is added into cart
      And  I should see that Total Price is not the same and increased by "Cappuccino" Coffee Price

    Example: The user can cancel the coffee order on confirmation popup after adding a coffee using right click
      When I right click on "Cappuccino"
      When I clicked "No" to add in the cart
      Then I should see that no "Cappuccino" is added into cart
      And  I should see that Total Price is equal to "$0.00"

  Rule: The user opens the coffee page and checks the details of Espresso coffee
    Background:
      Given I open the coffee shop online
      And I check "Espresso" price, cart status and total amount on home page

    Example: Verify if user is on home page when opening the application
      Then I should see that no "Espresso" is added into cart
      And  I should see that Total Price is equal to "$0.00"

    Example: Verify if user can adds his favourite coffee in the shopping cart
      When I order a "Espresso" Coffee
      Then I should see that one "Espresso" is added into cart
      And  I should see that Total Price is not the same and increased by "Espresso" Coffee Price
      When I hover on total price
      Then I can see cart overview with "1" "Espresso"
