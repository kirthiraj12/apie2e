Feature: get request cucumber test

  Scenario: As a user get the data
    Given an accept type of "application/json"
    When the user makes the request to get "/posts" get endpoint
    Then API should return "200" response
    And the API should return a "application/json" media type