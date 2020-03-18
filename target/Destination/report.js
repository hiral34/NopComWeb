$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/Resources/features/MenuHover.feature");
formatter.feature({
  "line": 1,
  "name": "Menu Hover ability",
  "description": "",
  "id": "menu-hover-ability",
  "keyword": "Feature"
});
formatter.before({
  "duration": 16018869200,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "To hover the mouse over choosen menu and see if there are any submenu then try clicking on choosen subdivision of menu.",
  "description": "",
  "id": "menu-hover-ability;to-hover-the-mouse-over-choosen-menu-and-see-if-there-are-any-submenu-then-try-clicking-on-choosen-subdivision-of-menu.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@MenuHover"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "User on Home page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "he hovers on \"Electronics\" and clicks on \"Others\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "he should be on \"others\" page",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepDefs.userOnHomePage()"
});
formatter.result({
  "duration": 764211800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Electronics",
      "offset": 14
    },
    {
      "val": "Others",
      "offset": 42
    }
  ],
  "location": "MyStepDefs.heHoversOnAndClicksOn(String,String)"
});
formatter.result({
  "duration": 2652479400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "others",
      "offset": 17
    }
  ],
  "location": "MyStepDefs.heShouldBeOnPage(String)"
});
formatter.result({
  "duration": 16085700,
  "status": "passed"
});
formatter.after({
  "duration": 145500,
  "status": "passed"
});
});