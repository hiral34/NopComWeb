Feature: User should be able to see Products in High to Low order
  @ProdHighToLow
  Scenario: User should be see products in high to low order when high to low in the dropdown is selected
    Given User is on Products details page
    When user clicks on Sort High to Low dropdown
    Then User should see products in High to Low order
