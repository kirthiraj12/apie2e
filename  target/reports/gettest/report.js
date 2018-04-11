$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/gettestcase.feature");
formatter.feature({
  "name": "get request cucumber test",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "As a user get the data",
  "description": "",
  "keyword": "Scenario"
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
  "location": "ClientSteps.api_should_return_response(String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat com.karlin.testing.acceptance.test.glue.steps.ClientSteps.api_should_return_response(ClientSteps.java:51)\n\tat ✽.API should return \"200\" response(src/test/resources/features/gettestcase.feature:6)\n",
  "status": "failed"
});
formatter.step({
  "name": "the API should return a \"application/json\" media type",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});