package com.pmi.gc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.*;
import com.pmi.gc.stepdefs.CommonSteps;


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
public class PmiScienceRunWebDriverTest extends AbstractTestNGCucumberTests {
	private CommonSteps commonSteps = new CommonSteps();

	@Given("^I am on the website '(.+)'$")
	public void I_am_on_the_website(String url) throws Throwable {
		commonSteps.I_am_on_the_website(url);
	}

	@Then("^Capture percy with name '(.+)'$")
	public void capture_percy(String capture_title) throws Throwable  {
		commonSteps.capture_percy_with_name(capture_title);
	}

	@Then("^I click on cookies button '(.+)'$")
	public void I_click_on_i_agree_to_all_button(String cookies_button) throws Throwable {
		commonSteps.clickOnCookiesButton(cookies_button);
	}

	@Then("^I verify the existence of the'(.+)'$\"")
	public void I_verify_the_existence_of_the_logo(String element) throws Throwable {
		commonSteps.verify_the_existence_of(element);
	}

	@Then("^I verify the existence of the banner on the homepage$")
	public void I_verify_the_existence_of_the_banner(String element) throws Throwable {
		commonSteps.verify_the_existence_of(element);
	}

	@Then("^I click on navigation button '(.+)'$")
	public void I_click_on_navigation_button(String nav_name) throws Throwable {
		commonSteps.I_click_on_navigation_button(nav_name);
	}

	@Then("^I click on {string} button in section 'Get In Touch'")
	public void I_click_on_contact_us_button(String button) throws Throwable {
		commonSteps.clickButton(button);
	}

	@When("I fill in {string} with {string}")
	public void i_fill_in_with(String fieldName, String fieldValue) throws Throwable {
		// Add code to fill in the given field with the given value
		commonSteps.fillFormField(fieldName, fieldValue);
	}

	@Then("the {string} field should contain {string}")
	public void the_field_should_contain(String fieldName, String expectedValue) throws Throwable {
		// Add code to check that the given field contains the expected value
		commonSteps.checkFormField(fieldName, expectedValue);
	}

}
