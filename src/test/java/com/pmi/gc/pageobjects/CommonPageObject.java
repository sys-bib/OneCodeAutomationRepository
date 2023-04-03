package com.pmi.gc.pageobjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.percy.selenium.Percy;

public class CommonPageObject {
	private WebDriver webDriver;
	private Percy percy;

	public CommonPageObject(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.webDriver.manage().window().maximize();
		this.percy = new Percy(webDriver);
	}

	public void selectMenuNavigation(String menu_name) {
		new WebDriverWait(webDriver, Duration.ofSeconds(2))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='" + menu_name + "'])[1]")))
				.click();
	}

	public boolean isElementExists(String elementType, String className) {
		By elementPath = By.xpath("//" + elementType + "[@class='" + className + "']");
		WebElement element = new WebDriverWait(webDriver, Duration.ofSeconds(2))
				.until(ExpectedConditions.visibilityOfElementLocated(elementPath));
		return element.isDisplayed();
	}

	public void cookiesButton(String cookies_button) {
		if (cookies_button == "I AGREE TO ALL") {
			new WebDriverWait(webDriver, Duration.ofSeconds(2))
					.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))).click();
		}

	}

	public void fillTheForm(String fieldName, String fieldValue) {
		webDriver.findElement(By.name(fieldName)).sendKeys(fieldValue);
	}

	public void checkTheForm(String fieldName, String expectedValue) {
		WebElement fieldElement = webDriver.findElement(By.name(fieldName));
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(fieldElement));
		String actualValue = fieldElement.getAttribute("value");
		Assert.assertEquals(actualValue, expectedValue);
	}

	public void clickButton(String elementType, String buttonText) {
		WebElement buttonElement = webDriver
				.findElement(By.xpath("//" + elementType + "[text()='" + buttonText + "']"));
		new WebDriverWait(webDriver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(buttonElement)).click();
	}

	public void OpenUrl(String url) {
		webDriver.get(url);
	}

	public void PercyCapture(String capture_title) {
		percy.snapshot(capture_title);
	}
}
