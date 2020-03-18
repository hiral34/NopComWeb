Feature: Menu Hover ability
  @MenuHover
  Scenario: To hover the mouse over choosen menu and see if there are any submenu then try clicking on choosen subdivision of menu.
    Given User on Home page
    When he hovers on "Electronics" and clicks on "Others"
    Then he should be on "others" page