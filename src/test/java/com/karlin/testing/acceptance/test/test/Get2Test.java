package com.karlin.testing.acceptance.test.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {
                "src/test/resources/features/gettestcase1.feature"
        },
        glue = "com.karlin.testing.acceptance.test.glue",
        plugin = {"pretty" , "html:target/reports/gettest1", "json:target/reports/getTest1.json"},
        tags = {"@acpttest"}

)

public class Get2Test extends AbstractTestNGCucumberTests {

}
