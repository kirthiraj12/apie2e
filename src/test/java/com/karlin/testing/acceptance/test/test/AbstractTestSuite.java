package com.karlin.testing.acceptance.test.test;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public abstract class AbstractTestSuite extends CustomAbstractTestNGCucumberTests {

    TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(
            alwaysRun = true
    )
    public void setUpClass() throws Exception {
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(
            groups = {"cucumber"},
            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios"
    )
    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper)
            throws Throwable {

        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());

    }

    public abstract Object[][] scenarios();

    @AfterClass(
            alwaysRun = true
    )
    public void tearDownClass() throws Exception {
        if(this.testNGCucumberRunner != null) {
            this.testNGCucumberRunner.finish();
        }
    }

}