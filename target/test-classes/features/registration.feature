Feature: User should able to register successfully, So that he can use all user feature from our website
  @test
  Scenario: User should able to register
    Given user is on register page
    When  user enters all registration details
    Then user should able to register successfully


