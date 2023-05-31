package com.onecode.gc.stepdefs;

import com.onecode.gc.pageobjects.CommonPageObject;
import com.onecode.gc.utilities.TestContext;
import io.cucumber.java.en.And;
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
	}

	@Then("I verify the existence of the element with tag {string} and class {string}")
	public void i_verify_the_existence_of_the_element_with_tag_and_class(String elementType, String elementClassName)
			throws Throwable {
		Boolean isElementExist = commonPage.isElementExists(elementType, elementClassName);
		Assert.assertTrue(isElementExist);
	}

	@Then("I click on navigation button {string}")
	public void I_click_on_navigation_button(String nav_name) throws Throwable {
		commonPage.selectMenuNavigation(nav_name);
		Thread.sleep(2000);
	}

	@Then("Capture percy with name {string}")
	public void capture_percy_with_name(String capture_title) throws Exception {
		commonPage.PercyCapture(capture_title);
	}

	@Then("I click on {string} cookies button")
	public void i_click_on_cookies_button(String cookies_button) throws Exception {
		commonPage.cookiesButton(cookies_button);
		Thread.sleep(2000);
	}

	@Then("I click on button with html tag {string} that contains text {string}")
	public void i_click_on_button(String html_tag, String button_text) throws Throwable {
		commonPage.clickButton(html_tag, button_text);
		Thread.sleep(5000);
	}

	@And("I fill in {string} with {string}")
	public void i_fill_in_with(String fieldName, String fieldValue) throws Throwable {
		commonPage.fillTheForm(fieldName, fieldValue);
		Thread.sleep(1000);
	}

	@And("The {string} field should contain {string}")
	public void the_field_should_contain(String fieldName, String expectedValue) throws Throwable {
		// Add code to check that the given field contains the expected value
		commonPage.checkTheForm(fieldName, expectedValue);
		Thread.sleep(1000);
	}
	//pwh step
	@And("I fill with xpath {string} with {string}")
	public void i_fill_with_xpath(String fieldXpath, String fieldValue) throws Throwable {
		commonPage.fillTheForm(fieldXpath, fieldValue);
		Thread.sleep(500);
	}
	@And("I fill with id {string} with {string}")
	public void i_fill_with_id(String fieldId, String fieldValue) throws Throwable {
		commonPage.fillFieldById(fieldId, fieldValue);
		Thread.sleep(500);
	}
	@And("I click on button by id {string}")
	public void I_click_on_button_by_id(String button_name) throws Throwable {
		commonPage.clickButtonById(button_name);
		Thread.sleep(3000);
	}
	@And("I click on button by class {string}")
	public void I_click_on_button_by_class(String button_class) throws Throwable {
		commonPage.clickButtonByClass(button_class);
		Thread.sleep(1000);
	}
	@And("accept js allert")
	public void accept_js_allert()throws Throwable{
		commonPage.clickConfirmationButton();
		Thread.sleep(17000);
	}
	@And("Click user search")
	public void click_user_search() throws Throwable{
		commonPage.userSearch();
		Thread.sleep(5000);
	}
	@And("Click text by contains text {string} that contains text {string}")
	public void click_text_by_contains_text(String html_tag, String text_name) throws Throwable{
		commonPage.clickContainText(html_tag, text_name);
	}

}