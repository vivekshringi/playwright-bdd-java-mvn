@home
Feature: Verify Coffee page where all different type of coffees are shown to add in the card

  Scenario Outline: The User performs double click on any coffee name translate the name in chinese
    Given I open the coffee shop online
    When I double click on "<Coffee>"
    Then The coffee name should be changed from "<Coffee>" to "<ChineseName>"
    Examples:
      |    Coffee             | ChineseName |
      |    Espresso           |   特浓咖啡   |
      |    Espresso Macchiato |   浓缩玛奇朵 |
      |    Cappuccino         |   卡布奇诺   |
      |    Mocha              |   摩卡      |


  Scenario:The User hovers on any coffee, it highlights the coffee with changed border color
    Given I open the coffee shop online
    And I hover on "Cappuccino"
    Then "Cappuccino" Coffee card border color should be changed to "rgb(218, 165, 32)"


  Scenario: The User can cancel the promo offer after adding three coffee in the cart
    Given I open the coffee shop online
    When I order a "Espresso" Coffee
    And I order a "Cappuccino" Coffee
    And I order a "Mocha" Coffee
    Then I get a promo offer to select a "Mocha" coffee in "$4"
    When I skip the offer
    And Promo coffee offer is not added in my cart and it shows "3" items


  Scenario: The user can add promo offer after adding three coffees in the cart
    Given I open the coffee shop online
    When I order a "Espresso" Coffee
    And I order a "Cappuccino" Coffee
    And I order a "Mocha" Coffee
    Then I get a promo offer to select a "Mocha" coffee in "$4"
    When I accept the offer
    And Promo coffee offer is added in my cart and it shows "4" items