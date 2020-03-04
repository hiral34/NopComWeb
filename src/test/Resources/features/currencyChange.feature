Feature: site user should be able to change the currency and product prices should reflect accordingly
  @currencyChange
  Scenario: User should be able to change the currency
    Given user is on home page
    When user selects a currency of his choice
    Then he should see prices reflecting in currency symbol
