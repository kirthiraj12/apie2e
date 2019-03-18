package com.karlin.testing.acceptance.test.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {
                "src/test/resources/features/SmokeTestCase.feature"
        },
        glue = "com.karlin.testing.acceptance.test.glue",
        plugin = {"pretty" , "html:target/reports/smoketest", "json:target/reports/smokeTest.json"},
        tags = {"@acpttest"}

)
public class SmokeTest extends AbstractTestNGCucumberTests {

      //  public String baseuri = "https://jsonplaceholder.typicode.com";

}
