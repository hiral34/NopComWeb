$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/Resources/features/AddToCart.feature");
formatter.feature({
  "line": 1,
  "name": "Add to Cart button must be displayed on all featured products",
  "description": "",
  "id": "add-to-cart-button-must-be-displayed-on-all-featured-products",
  "keyword": "Feature"
});
formatter.before({
  "duration": 37791503300,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "All the featured products on the home page must have a add to cart button underneath each product",
  "description": "",
  "id": "add-to-cart-button-must-be-displayed-on-all-featured-products;all-the-featured-products-on-the-home-page-must-have-a-add-to-cart-button-underneath-each-product",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@addToCart"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "user should see add to cart button on all featured products",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "user should be able to add the product to the cart",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepDefs.userShouldSeeAddToCartButtonOnAllFeaturedProducts()"
});
formatter.result({
  "duration": 1765210000,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefs.userShouldBeAbleToAddTheProductToTheCart()"
});
formatter.result({
  "duration": 2752011800,
  "status": "passed"
});
formatter.after({
  "duration": 1555388800,
  "status": "passed"
});
});