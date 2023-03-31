package com.pmi.gc.pageobjects;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.percy.selenium.Percy;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class CommonPageObject {
	private WebDriver webDriver;
	private Actions actions;
	private Percy percy;

	public CommonPageObject(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.webDriver.manage().window().maximize();
		this.actions = new Actions(webDriver);
		this.percy = new Percy(webDriver);
	}

	public void selectMenuNavigation(String menu_name) {
		new WebDriverWait(webDriver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='" + menu_name + "'])[1]")))
				.click();
	}

	public void scienceSearchFunction(String search_text) {
		By searchIconPath = By.xpath("(//div[@class='search-icon icon-size__default'])[1]");
		ExpectedConditions.visibilityOfElementLocated(searchIconPath);
		new WebDriverWait(webDriver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(searchIconPath)).click();
		webDriver.findElement(By.xpath("(//input[@class='cmp-search__input'])[1]")).sendKeys(search_text);
		new WebDriverWait(webDriver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(searchIconPath)).click();
	}

	public int scienceSearchGetResultCount() {
		String searchResult = webDriver.findElement(By.className("cmp-pmi-search-tabs__filter-results-value"))
				.getText();
		int resultCount = Integer.parseInt(searchResult.split(" ")[0]);
		return resultCount;
	}

	public void getConsoleErrorLog() {
		LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
		for (LogEntry logEntry : logEntries) {
			System.out.println(logEntry);
		}
	}

	public boolean isElementExists(String elementType, String className) {
		By elementPath = By.xpath("//" + elementType + "[@class='" + className + "']");
		WebElement element = new WebDriverWait(webDriver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(elementPath));
		return element.isDisplayed();
	}

	public void cookiesButton(String cookies_button) {
		if (cookies_button == "I AGREE TO ALL") {
			new WebDriverWait(webDriver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(By.xpath("onetrust-accept-btn-handler"))).click();
		}

	}

	public void ContactUsFormFill(String fieldName, String fieldValue) {
		webDriver.findElement(By.name(fieldName)).sendKeys(fieldValue);
	}

	public void ContactUsFormCheck(String fieldName, String expectedValue) {
		// Find the element corresponding to the given field name
		WebElement fieldElement = webDriver.findElement(By.name(fieldName));
		// Wait until the element is visible and enabled
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(fieldElement));
		wait.until(ExpectedConditions.elementToBeClickable(fieldElement));
		// Get the value of the element
		String actualValue = fieldElement.getAttribute("value");
		// Check that the actual value matches the expected value
		assertEquals(expectedValue, actualValue);

	}

	public void clickContactUsButton() {
		WebElement contactUsButton = webDriver.findElement(By.xpath("(//a[@href='/en/contact/']//span)[3]"));
		actions.moveToElement(contactUsButton).click().perform();
	}

	public void OpenUrl(String url) {
		webDriver.get(url);
	}

	public void PercyCapture(String capture_title) {
		percy.snapshot(capture_title);
	}
}
