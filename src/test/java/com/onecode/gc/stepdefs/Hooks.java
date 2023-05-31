package com.onecode.gc.stepdefs;

import com.onecode.gc.utilities.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
	public WebDriver driver;
	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void setUp() {
		driver = testContext.webDriver;
	}

	@After
	public void teardown(Scenario scenario) throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}