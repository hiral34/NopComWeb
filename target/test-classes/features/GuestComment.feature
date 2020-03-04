Feature: Guest should be able to comment without signing in or register
  @guestComment
  Scenario: Guest user should be able to leave a comment on the site without the need to register or sign in.
    Given User is on Home Page and clicks News link
    When guest user fills in comments
    Then user should see his comment posted
