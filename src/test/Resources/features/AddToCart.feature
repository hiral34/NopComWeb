Feature: Add to Cart button must be displayed on all featured products
  @addToCart
  Scenario: All the featured products on the home page must have a add to cart button underneath each product
    When user should see add to cart button on all featured products
    Then user should be able to add the product to the cart
