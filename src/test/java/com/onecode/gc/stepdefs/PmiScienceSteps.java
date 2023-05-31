package com.onecode.gc.stepdefs;

import io.cucumber.java.en.Then;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.onecode.gc.pageobjects.CommonPageObject;
import com.onecode.gc.utilities.TestContext;

public class PmiScienceSteps {
	TestContext testContext;
	private CommonPageObject commonPage;
	private WebDriver webDriver;

	public PmiScienceSteps(TestContext context) {
		testContext = context;
		commonPage = new CommonPageObject(testContext.webDriver);
		webDriver = testContext.webDriver;
	}

	public void scienceSearchFunction(String search_text) {
		By searchIconPath = By.xpath("(//div[@class='search-icon icon-size__default'])[1]");
		ExpectedConditions.visibilityOfElementLocated(searchIconPath);
		new WebDriverWait(webDriver, Duration.ofSeconds(3))
				.until(ExpectedConditions.elementToBeClickable(searchIconPath)).click();
		webDriver.findElement(By.xpath("(//input[@class='cmp-search__input'])[1]")).sendKeys(search_text);
		new WebDriverWait(webDriver, Duration.ofSeconds(3))
				.until(ExpectedConditions.elementToBeClickable(searchIconPath)).click();
	}

	public int scienceSearchGetResultCount() {
		String searchResult = webDriver.findElement(By.className("cmp-pmi-search-tabs__filter-results-value"))
				.getText();
		int resultCount = Integer.parseInt(searchResult.split(" ")[0]);
		return resultCount;
	}

	@Then("I search the text {string}")
	public void I_search_the_text(String text) throws Throwable {
		this.scienceSearchFunction(text);
		Thread.sleep(3000);
		int countResult = this.scienceSearchGetResultCount();
		Assert.assertEquals(countResult > 0, true);
	}
}