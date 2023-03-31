package com.pmi.gc.stepdefs;

import com.pmi.gc.pageobjects.CommonPageObject;
import com.pmi.gc.utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CommonSteps {
	public CommonPageObject commonPage;
	TestContext testContext;

	public CommonSteps(TestContext context) {
		testContext = context;
		commonPage = new CommonPageObject(testContext.webDriver);
	}

	@Given("^I am on the website '(.+)'$")
	public void I_am_on_the_website(String url) throws Throwable {
		commonPage.OpenUrl(url);
		Thread.sleep(2000);
		commonPage.getConsoleErrorLog();
		Thread.sleep(2000);
	}

	// HOW DO I TURN THIS METHOD REUSABLE FOR DIFFERENT CASES?
	// SHOULD IT HAVE PARAMETERS?
	@Then("I verify the existence of the element with tag {string} and class {string}")
	public void  i_verify_the_existence_of_the_element_with_tag_and_class(String elementType, String elementClassName) throws Throwable {
		Boolean isElementExist = commonPage.isElementExists(elementType, elementClassName);
		Assert.assertTrue(isElementExist);
	}

	@Then("I click on navigation button {string}")
	public void I_click_on_navigation_button(String nav_name) throws Throwable {
		commonPage.selectMenuNavigation(nav_name);
		Thread.sleep(2000);
	}

	@Then("I search the text {string}")
	public void I_search_the_text(String text) throws Throwable {
		commonPage.scienceSearchFunction(text);
		Thread.sleep(3000);
		int countResult = commonPage.scienceSearchGetResultCount();
		Assert.assertEquals(countResult > 0, true);
	}

	@Then("^Capture percy with name '(.+)'$")
	public void capture_percy_with_name(String capture_title) throws Exception {
		commonPage.PercyCapture(capture_title);
	}

	@Then("I click on {string} cookies button")
	public void i_click_on_cookies_button(String cookies_button) throws Exception {
		commonPage.cookiesButton(cookies_button);
		Thread.sleep(2000);
	}
}