@home
Feature: Coffee Page special operations

  Scenario Outline: Double click on coffee name translate to chinese
    Given I opened the coffee shop online
    When I double clicked "<Coffee>"
    Then The coffee name should be changed from "<Coffee>" to "<ChineseName>"
    Examples:
      |    Coffee             | ChineseName |
      |    Espresso           |   特浓咖啡   |
      |    Espresso Macchiato |   浓缩玛奇朵 |
      |    Cappuccino         |   卡布奇诺   |
      |    Mocha              |   摩卡      |


  Scenario: Hovering on Coffee card plays an animation
    Given I opened the coffee shop online
    And I hover on "Cappuccino"
    Then "Cappuccino" Coffee card border color should be changed to "rgb(218, 165, 32)"


  Scenario: Ordering on every three coffees, user gets one coffee in half price
    Given I opened the coffee shop online
    When I ordered "Espresso"
    And I ordered "Cappuccino"
    And I ordered "Mocha"
    Then I get one "Mocha" coffee in "$4" offer to select
    When I skip the offer
    And Promo coffee is not added in my cart and it shows "3" items


  Scenario: Ordering on every three coffees, user gets one coffee in half price
    Given I opened the coffee shop online
    When I ordered "Espresso"
    And I ordered "Cappuccino"
    And I ordered "Mocha"
    Then I get one "Mocha" coffee in "$4" offer to select
    When I accept the offer
    And Promo coffee is added in my cart and it shows "4" items