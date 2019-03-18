$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/gettestcase.feature");
formatter.feature({
  "name": "get request cucumber test acceptest",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@acpttest"
    }
  ]
});
formatter.scenario({
  "name": "As a user get the data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@acpttest"
    }
  ]
});
formatter.step({
  "name": "an accept type of \"application/json\"",
  "keyword": "Given "
});
formatter.match({
  "location": "ClientSteps.an_accept_type_of(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user makes the request to get \"/posts\" get endpoint",
  "keyword": "When "
});
formatter.match({
  "location": "ClientSteps.the_user_makes_the_request_to_get_get_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "API should return \"200\" response",
  "keyword": "Then "
});
formatter.match({
  "location": "ClientSteps.api_should_return_response(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the API should return a \"application/json;charset\u003dutf-8\" media type",
  "keyword": "And "
});
formatter.match({
  "location": "ClientSteps.the_API_should_return_a_media_type(String)"
});
formatter.result({
  "status": "passed"
});
});