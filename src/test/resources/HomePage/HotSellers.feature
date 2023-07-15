Feature: Search functionality

  Scenario: Add single product directly from Hot Sellers section
    Given I am on the LUMA homepage
    When I add "Gray" "Hero Hoodie" in "M" size to cart
    Then I should see "You added Hero Hoodie to your shopping cart." notification
