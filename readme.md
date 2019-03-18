selenium-cucumber-java-maven

selenium-cucumber : Automation Testing Using Java

selenium-cucumber is a behavior driven development (BDD) approach
 to write automation test script to test Web. It enables you to write and execute automated acceptance/unit tests. It is cross-platform, open source and free. Automate your test cases with minimal coding. More Details

 Documentation

 Installation
 Predefined steps

 https://github.com/selenium-cucumber/selenium-cucumber-java-maven-example

mvn -DJmeterTestFile=Jmeter-Maven-Sample -DRampUp=40 -DLoopcount=20 -DThreadcount=30 verify

mvn -P acceptance-profile clean install

mvn -Dtest=SmokeTestSuite clean install -DfailNoTests=false -P acceptance-profile clean install

mvn --Dcucumber.options="--tags@smoke" -P acceptance-profile clean install

