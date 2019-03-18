package com.karlin.testing.acceptance.test.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {
                "src/test/resources/features/gettestcase.feature"
        },
        glue = "com.karlin.testing.acceptance.test.glue",
        plugin = {"pretty" , "html:target/reports/gettest", "json:target/reports/getTest.json"},
        tags = {"@acpttest"}

)



public class GetTest extends AbstractTestNGCucumberTests {

      //  public String baseuri = "https://jsonplaceholder.typicode.com";

}
