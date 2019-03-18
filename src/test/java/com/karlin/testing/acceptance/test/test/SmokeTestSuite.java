package com.karlin.testing.acceptance.test.test;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.PickleEventWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.DataProvider;

import static com.karlin.testing.acceptance.test.test.AcceptanceTags.SMOKE_TAG;

@CucumberOptions(
        features = {
                "src/test/resources/features"
        },
        glue = {
                "com.karlin.testing.acceptance.test.glue"
        },
        plugin = {
                "pretty",
                "html:target/reports/SmokeTestSuite",
                "json:target/reports/SmokeTestSuite.json"
        }
)
public class SmokeTestSuite extends AbstractTestSuite {

    @DataProvider
    public Object[][] scenarios() {
        if(this.testNGCucumberRunner == null) {
            return new Object[0][0];
        }

        Object[][] scenarios = this.testNGCucumberRunner.provideScenarios();

        List<Object[]> filteredScenarios = Arrays
                .stream(scenarios)
                .filter(scenario -> {
                    PickleEventWrapper wrapper = (PickleEventWrapper) scenario[0];
                    return wrapper.getPickleEvent().pickle.getTags().stream()
                            .anyMatch(tag -> tag.getName().equals(SMOKE_TAG.toString()));
                })
                .collect(Collectors.toList());

        // Set the scenario names to be used as the testng test names
        prepareTestScenarioNamesFromDataProvider(filteredScenarios.toArray(new Object[][]{}));

        return filteredScenarios.toArray(new Object[][]{});
    }
}

