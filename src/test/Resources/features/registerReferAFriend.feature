Feature: Registered User should be able to refer product to a friend
  @registeredReferAFriend
  Scenario: Registered User should be able to refer a friend a product
    Given User is on Home page and clicks to register
    When user registers and clicks on refer a friend button
    And enters and fills in refer a friend details
    Then he should be able to see Your message sent message
