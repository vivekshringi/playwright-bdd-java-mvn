@cart
Feature: Cart Operations
  Rule: Updating cart using right click
    Background:
      Given I opened the coffee shop online
      And I checked "Cappuccino" price, cart status and total amount on menu page

    Example: Adding Coffee using right click
      When I right click on "Cappuccino"
      When I clicked "Yes" to add in the cart
      Then I should see that one "Cappuccino" is added into cart
      And  I should see that Total Price is not same and increased by "Cappuccino" Price

    Example: Cancel Adding Coffee using right click
      When I right click on "Cappuccino"
      When I clicked "No" to add in the cart
      Then I should see that no "Cappuccino" is added into cart
      And  I should see that Total Price is equal to "$0.00"

  Rule: Traditional way to update the items in the cart
    Background:
      Given I opened the coffee shop online
      And I checked "Espresso" price, cart status and total amount on menu page

    Example: Check if default home page is displayed as expected
      Then I should see that no "Espresso" is added into cart
      And  I should see that Total Price is equal to "$0.00"

    Example: Check if I can add a coffee to the online cart
      When I ordered "Espresso"
      Then I should see that one "Espresso" is added into cart
      And  I should see that Total Price is not same and increased by "Espresso" Price
      When I hover on total price
      Then I can see cart overview with "1" "Espresso"
