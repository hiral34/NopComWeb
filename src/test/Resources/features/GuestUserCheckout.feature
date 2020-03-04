Feature: Guest User Should Able to Successfully Checkout
  @guestUserCheckout
  Scenario: Guest User should be able to checkout successfully with all mandatory details without the need to register first
    Given guest user adds product to basket
    When guest user fills in single sign on form
    And enters valid bank card details
    Then checkout as guest user and item ordered successfully
