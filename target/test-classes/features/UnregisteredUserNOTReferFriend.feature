Feature: Non Registered User should NOT be able to refer product to a friend
  @UnregisterNOTRefer
  Scenario: Unregistered user should NOT be able to refer a friend a product
    Given User chooses Products page
    When user clicks on refer a friend button
    And enters and fills in refer a friend details
    Then user should see Only registered user able to refer message
