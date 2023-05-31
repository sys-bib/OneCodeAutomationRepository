package com.onecode.gc;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "com.pmi.gc.stepdefs",
        features = "src/test/resources/features/pwh.org/Ambassador.feature",
        plugin = {
                "pretty",
                "html:reports/tests/cucumber/cucumber-pretty.html",
                "testng:reports/tests/cucumber/testng/cucumber.xml",
                "json:reports/tests/cucumber/json/cucumberTestReport.json"
        }
)
public class PwhRunWebDriverTest extends AbstractTestNGCucumberTests {}
