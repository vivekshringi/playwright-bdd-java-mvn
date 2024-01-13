Feature: Order Coffee

  Scenario: Check default home page
    Given I am on the COFFEE homepage
    And I checked "Espresso" price, cart status and total amount on menu page
    Then I should see that no "Espresso" is added into cart
    And  I should see that Total Price is equal to "$0.00"

  Scenario: Adding Coffee
    Given I am on the COFFEE homepage
    And I checked "Espresso" price, cart status and total amount on menu page
    When I ordered "Espresso"
    Then I should see that one "Espresso" is added into cart
    And  I should see that Total Price is not same and increased by "Espresso" Price
    When I hover on total price
    Then I can see cart overview with "1" "Espresso"

  Scenario: Double click on coffee name translate to chinese
    Given I am on the COFFEE homepage
    When I double clicked "Espresso"
    Then The coffee name should be changed from "Espresso" to "特浓咖啡"

  Scenario: Hovering on Coffee card plays an animation
    Given I am on the COFFEE homepage
    And I hover on "Cappuccino"
    Then "Cappuccino" Coffee card border color should be changed to "rgb(218, 165, 32)"

  Scenario: Adding Coffee using right click
    Given I am on the COFFEE homepage
    And I checked "Cappuccino" price, cart status and total amount on menu page
    When I right click on "Cappuccino"
    When I clicked "Yes" to add in the cart
    Then I should see that one "Cappuccino" is added into cart
    And  I should see that Total Price is not same and increased by "Cappuccino" Price

  Scenario: Cancel Adding Coffee using right click
    Given I am on the COFFEE homepage
    And I checked "Cappuccino" price, cart status and total amount on menu page
    When I right click on "Cappuccino"
    When I clicked "No" to add in the cart
    Then I should see that no "Cappuccino" is added into cart
    And  I should see that Total Price is equal to "$0.00"

  Scenario: Ordering on every three coffees, user gets one coffee in half price
    Given I am on the COFFEE homepage
    When I ordered "Espresso"
    And I ordered "Cappuccino"
    And I ordered "Mocha"
    Then I get one "Mocha" coffee in "$4" offer to select
    When I skip the offer
    And Promo coffee is not added in my cart and it shows "3" items

  Scenario: Ordering on every three coffees, user gets one coffee in half price
    Given I am on the COFFEE homepage
    When I ordered "Espresso"
    And I ordered "Cappuccino"
    And I ordered "Mocha"
    Then I get one "Mocha" coffee in "$4" offer to select
    When I accept the offer
    And Promo coffee is added in my cart and it shows "4" items