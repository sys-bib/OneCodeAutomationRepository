package com.pmi.gc.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import com.pmi.gc.pageobjects.CommonPageObject;
import com.pmi.gc.utilities.TestContext;

public class PmiScienceSteps {
	TestContext testContext;
	private CommonPageObject commonPage;

	public PmiScienceSteps(TestContext context) {
		testContext = context;
		commonPage = new CommonPageObject(testContext.webDriver);
	}

	@Then("I click on {string} button in section Get in Touch")
	public void i_click_on_button_in_section(String button_text) throws Throwable {
		commonPage.clickContactUsButton();
		Thread.sleep(2000);
	}

	@And("I fill in {string} with {string}")
	public void i_fill_in_with(String fieldName, String fieldValue) throws Throwable {
		commonPage.ContactUsFormFill(fieldName, fieldValue);
		Thread.sleep(1000);
	}

	@And("The {string} field should contain {string}")
	public void the_field_should_contain(String fieldName, String expectedValue) throws Throwable {
		// Add code to check that the given field contains the expected value
		commonPage.ContactUsFormCheck(fieldName, expectedValue);
		Thread.sleep(1000);
	}
}