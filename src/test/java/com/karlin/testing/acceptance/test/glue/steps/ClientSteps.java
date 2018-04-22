package com.karlin.testing.acceptance.test.glue.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:applicationContext.xml")
public class ClientSteps {

    @Autowired
    com.karlin.testing.acceptance.test.glue.ClientFactory ClientFactory;

   // When the user makes the request to get "https://jsonplaceholder.typicode.com/posts" get endpoint
    //And the API should return a "application/json" media type

    public String id;
    public Response actualResponse;
    public MediaType acceptType;
    public MediaType contentType;
    public Map<String, String> queryParams = new HashMap<>();

    @Given("^an content type of \"([^\"])\"$")
    public void an_content_type_of(String contentType){
        this.contentType = MediaType.valueOf(contentType);

    }

    @Given("^an accept type of \"([^\"]*)\"$")
    public void an_accept_type_of(String acceptType) throws Throwable {
        this.acceptType = MediaType.valueOf(acceptType);

    }

    @When("^the user makes the request to get \"([^\"]*)\" get endpoint$")
    public void the_user_makes_the_request_to_get_get_endpoint(String arg1) throws Throwable {
            // Write code here that turns the phrase above into concrete actions

    }

    @Then("^API should return \"([^\"]*)\" response$")
    public void api_should_return_response(String responseCode) throws Throwable {
        if (!Objects.equals(actualResponse.getStatus(), responseCode)) {
            throw new RuntimeException("Failed : Http Error Code" + actualResponse.getStatus());
        }
    }


}
