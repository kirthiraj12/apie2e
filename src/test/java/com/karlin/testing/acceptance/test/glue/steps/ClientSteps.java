package com.karlin.testing.acceptance.test.glue.steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karlin.testing.acceptance.test.glue.specs.GetClientSpecification;
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
import org.testng.Assert;

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
    public String message;

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
        GetClientSpecification specification = GetClientSpecification.create()
                .withId(id)
                .withPath(arg1)
                .withAcceptType(acceptType)
                .withContentType(contentType);

        actualResponse=ClientFactory.getClientFor(specification).makeRequest();

        System.out.println(specification);
        System.out.println(actualResponse);

    }

    @Then("^API should return \"([^\"]*)\" response$")
    public void api_should_return_response(int responseCode) throws Throwable {

       // String jsonString = actualResponse.readEntity(String.class);
       // System.out.println(jsonString);

      //  if (!Objects.equals(actualResponse.getStatus(), responseCode)) {
      //      throw new RuntimeException("Failed : Http Error Code is :  " + actualResponse.getStatus());
      //  }

        if (actualResponse.getStatus() != responseCode) {
            throw new RuntimeException("Failed : Http Error Code is :  " + actualResponse.getStatus());

        }

    }
    @Then("^the API should return a \"([^\"]*)\" media type$")
    public void the_API_should_return_a_media_type(String arg1) throws Exception {
    //    if (!Objects.equals(actualResponse.getMediaType().toString(), arg1)) {
        if (!(Objects.equals(arg1, actualResponse.getMediaType().toString()))) {
            System.out.println(arg1);
            System.out.println(actualResponse.getMediaType());
            throw new RuntimeException("failed: media does not match: " + actualResponse.getMediaType());

        }
    }

    @Then("^Validate the response message \"([^\"]*)\"$")
    public void theAPIShouldReturnMessage(String message) throws Throwable {

        String jsonString = actualResponse.readEntity(String.class);
        System.out.println(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        if(null == jsonString)
        {
            Assert.fail("Test failed: Actual json response returned null string");

        }

        else {

            JsonNode actualObj = mapper.readTree(jsonString);
            if (!actualObj.has("message"))

            {
                Assert.fail("Group Node does not have field message");
            }
                else
                {
                    Assert.assertEquals(actualObj.get("message").textValue(),message);
                }

            }
        }





}
