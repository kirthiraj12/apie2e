package com.karlin.testing.acceptance.test.test;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.PickleEventWrapper;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.ITest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * This class handles updating the TestNG test name based on the Cucumber Scenario name.
 */
public class CustomAbstractTestNGCucumberTests extends AbstractTestNGCucumberTests implements
        ITest {

    private List<String> testNameList = Collections.emptyList();
    private String testName;

    /**
     * This function is automatically called when running a set of tests scenarios locally. It sets
     * the TestNG test names to use the cucumber test names.
     */
    @BeforeClass
    public void prepareTestScenarioNames() {
        testNameList = Arrays.stream(scenarios())
                .map(x -> ((PickleEventWrapper) x[0]).getPickleEvent().pickle.getName())
                .collect(Collectors.toList());
    }

    /**
     * This function should be called in the @DataProvider function of any Test Suite. It will allow
     * TestNG to set the cucumber test name as its own.
     *
     * @param dataProviderScenarios List of scenarios from the data provider.
     */
    void prepareTestScenarioNamesFromDataProvider(Object[][] dataProviderScenarios) {
        testNameList = Arrays.stream(dataProviderScenarios)
                .map(x -> ((PickleEventWrapper) x[0]).getPickleEvent().pickle.getName())
                .collect(Collectors.toList());
    }

    @BeforeMethod
    public void updateTestName() {
        testName = testNameList.isEmpty() ? "" : testNameList.remove(0);
    }

    @Override
    public String getTestName() {
        return testName;
    }
}