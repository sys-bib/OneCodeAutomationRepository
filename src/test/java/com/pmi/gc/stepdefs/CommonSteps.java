package com.pmi.gc.stepdefs;

import com.pmi.gc.pageobjects.CommonPageObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.testng.Assert;
import io.percy.selenium.Percy;

public class CommonSteps {
	private WebDriver driver;
	private CommonPageObject commonPage;
	private Percy percy;

	@Before
	public void setUp() throws MalformedURLException {
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, String> bstackOptions = new HashMap<>();
		bstackOptions.putIfAbsent("source", "cucumber-java:sample-sdk:v1.1");
		capabilities.setCapability("bstack:options", bstackOptions);
		driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), capabilities);
		driver.manage().window().maximize();
		commonPage = new CommonPageObject(driver);
		percy = new Percy(driver);
	}

	@Given("^I am on the website '(.+)'$")
	public void I_am_on_the_website(String url) throws Throwable {
		driver.get(url);
		Thread.sleep(2000);
		commonPage.getConsoleErrorLog();
		Thread.sleep(2000);
	}

	//HOW DO I TURN THIS METHOD REUSABLE FOR DIFFERENT CASES?
	//SHOULD IT HAVE PARAMETERS?
	@Then("^I verify the existence of the '(.+)'$")
	public void verify_the_existence_of(String element) throws Throwable {
		if(element.contains("logo")) {
			Boolean isLogoDisplayed = commonPage.isLogoExists();
			Assert.assertTrue(isLogoDisplayed);
		}
		if(element.contains("banner")) {
			Boolean isBannerDisplayed = commonPage.isBannerExists();
			Assert.assertTrue(isBannerDisplayed);
		}
	}

	@Then("^I click on navigation button '(.+)'$")
	public void I_click_on_navigation_button(String nav_name) throws Throwable {
		commonPage.selectMenuNavigation(nav_name);
		Thread.sleep(2000);
	}

	@Then("^I search the text '(.+)'$")
	public void I_search_the_text(String text) throws Throwable {
		commonPage.scienceSearchFunction(text);
		Thread.sleep(3000);
		int countResult = commonPage.scienceSearchGetResultCount();
		Assert.assertEquals(countResult > 0, true);
	}

	@After
	public void teardown(Scenario scenario) throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Then("^Capture percy with name '(.+)'$")
	public void capture_percy_with_name(String capture_title) throws Exception {
		percy.snapshot(capture_title);
	}
	
	@Then("^I click on cookies button '(.+)'$")
	public void clickOnCookiesButton(String cookies_button) throws Exception  {
		commonPage.cookiesButton(cookies_button);
		Thread.sleep(2000);
	}

	@When("I fill in {string} with {string}")
	public void fillFormField(String fieldName, String fieldValue) throws Exception {
		commonPage.ContactUsFormFill(fieldName, fieldValue);
		Thread.sleep(1000);
	}

	@Then("the {string} field should contain {string}")
	public void checkFormField(String fieldName, String expectedValue) throws Exception {
		commonPage.ContactUsFormCheck(fieldName, expectedValue);
		Thread.sleep(1000);
	}
	
	public CommonPageObject getCommonPage() {
		return commonPage;
	}

	public void setCommonPage(CommonPageObject commonPage) {
		this.commonPage = commonPage;
	}

	public void clickButton(String button) {
		commonPage.clickContactUsButton(button);
		
	}

}