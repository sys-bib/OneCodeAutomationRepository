package com.pmi.gc.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class CommonPageObject {
	private WebDriver webDriver;

	public CommonPageObject(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.webDriver.manage().window().maximize();
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

//	public void waitForSubMenuDropDown() {
//		new WebDriverWait(webDriver, Duration.ofSeconds(30))
//				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(firstMenuName));
//	}

	public void getConsoleErrorLog() {
		LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
		for (LogEntry logEntry : logEntries) {
			System.out.println(logEntry);
		}
	}
}
