package com.onecode.gc;

import io.cucumber.testng.*;

@CucumberOptions(
        glue = "com.onecode.gc.stepdefs",
        features = "src/test/resources/features/iris.app.pertamina.com",
        plugin = {
                "pretty",
                "html:reports/tests/cucumber/cucumber-pretty.html",
                "testng:reports/tests/cucumber/testng/cucumber.xml",
                "json:reports/tests/cucumber/json/cucumberTestReport.json"
        }
)
public class IrisRunWebDriverTest extends AbstractTestNGCucumberTests {}

