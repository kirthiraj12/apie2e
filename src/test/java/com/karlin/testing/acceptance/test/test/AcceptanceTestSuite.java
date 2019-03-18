package com.karlin.testing.acceptance.test.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.PickleEventWrapper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {
                "src/test/resources/features"
        },
        glue = {
                "com.karlin.testing.acceptance.test.glue"
        },
        plugin = {
                "pretty",
                "html:target/reports/AcceptanceTestSuite",
                "json:target/reports/AcceptanceTestSuite.json"
        }
)
public class AcceptanceTestSuite extends AbstractTestSuite {

    @DataProvider
    public Object[][] scenarios() {
        if(this.testNGCucumberRunner == null) {
            return new Object[0][0];
        }

        Object[][] scenarios = this.testNGCucumberRunner.provideScenarios();

        List<Object[]> orderedScenarios = Arrays
                .stream(scenarios)
                .sorted(
                        (Object[] lhs, Object[] rhs) -> {
                            AcceptanceTags lhsTag = extractTag(lhs);
                            AcceptanceTags rhsTag = extractTag(rhs);
                            return lhsTag.compareTo(rhsTag);
                        }
                )
                .collect(Collectors.toList());

        // Set the scenario names to be used as the testng test names
        prepareTestScenarioNamesFromDataProvider(orderedScenarios.toArray(new Object[][]{}));

        return orderedScenarios.toArray(new Object[][]{});
    }

    private AcceptanceTags extractTag(Object[] elements) {
        return AcceptanceTags.fromString(
                ((PickleEventWrapper) elements[0]).getPickleEvent().pickle.getTags().get(0).getName()
        );
    }
}