package com.pmi.gc;

import io.cucumber.testng.*;

@CucumberOptions(
        glue = "com.pmi.gc.stepdefs",
        features = "src/test/resources/features/pmiscience.com",
        plugin = {
                "pretty",
                "html:reports/tests/cucumber/cucumber-pretty.html",
                "testng:reports/tests/cucumber/testng/cucumber.xml",
                "json:reports/tests/cucumber/json/cucumberTestReport.json"
        }
)
public class PmiScienceRunWebDriverTest extends AbstractTestNGCucumberTests {}
