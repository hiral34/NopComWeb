Feature: Product comparison
  @product_compare
  Scenario: User should be able to compare two different products successfully.
    Given User is on Products Page
    When user clicks two products and presses product compare buttons
    Then he should be on product comparison page and his chosen products must be displayed for comparison
