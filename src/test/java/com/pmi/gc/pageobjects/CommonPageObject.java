package com.pmi.gc.pageobjects;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class CommonPageObject {
	private WebDriver webDriver;
	private Actions actions;

	public CommonPageObject(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.webDriver.manage().window().maximize();
		this.actions = new Actions(webDriver);
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

	public boolean isLogoExists() {
		By logoPath = By.xpath("//img[@class='cmp-logo']");
		WebElement logo = new WebDriverWait(webDriver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(logoPath));
		return logo.isDisplayed();
	}

	public Boolean isBannerExists() {
		By bannerPath = By.xpath("//div[@class='cmp-carousel__content']");
		WebElement banner = new WebDriverWait(webDriver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(bannerPath));
		return banner.isDisplayed();
	}

	public void cookiesButton(String cookies_button) {
		if(cookies_button == "I AGREE TO ALL") {
			new WebDriverWait(webDriver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(By.xpath("onetrust-accept-btn-handler")))
			.click();
		}

	}

	public void ContactUsFormFill(String fieldName, String fieldValue) {
		//fill "Your Name" field
		if(fieldName.contains("Your name")) {
			WebElement nameInput = webDriver.findElement(By.id("form-text-1017293783"));
			nameInput.sendKeys(fieldValue);
		} 

		//fill "Organization" field
		if(fieldName.contains("Organization")) {
			WebElement organization = webDriver.findElement(By.id("form-text-756778686"));
			organization.sendKeys(fieldValue);
		}

		//fill "Email Address" field
		if(fieldName.contains("Email address")) {
			WebElement emailInput = webDriver.findElement(By.id("form-text-1693707664"));
			emailInput.sendKeys(fieldValue);
		}

		//fill "Your Message" field
		if(fieldName.contains("Your Message")) {
			WebElement messageInput = webDriver.findElement(By.id("form-text-188716062"));
			messageInput.sendKeys(fieldValue);
		}
	}

	public void ContactUsFormCheck(String fieldName, String expectedValue) {
		// Find the element corresponding to the given field name
        WebElement fieldElement = null;
      		if(fieldName.contains("Your name")) {
      			fieldElement = webDriver.findElement(By.id("form-text-1017293783"));
      		} 

      		//fill "Organization" field
      		if(fieldName.contains("Organization")) {
      			fieldElement = webDriver.findElement(By.id("form-text-756778686"));
      		}

      		//fill "Email Address" field
      		if(fieldName.contains("Email address")) {
      			fieldElement = webDriver.findElement(By.id("form-text-1693707664"));
      		}

      		//fill "Your Message" field
      		if(fieldName.contains("Your Message")) {
      			fieldElement = webDriver.findElement(By.id("form-text-188716062"));
      		}
        
        // Wait until the element is visible and enabled
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(fieldElement));
        wait.until(ExpectedConditions.elementToBeClickable(fieldElement));
        
        // Get the value of the element
        String actualValue = fieldElement.getAttribute("value");
        
        // Check that the actual value matches the expected value
        assertEquals(expectedValue, actualValue);
		
	}

	public void clickContactUsButton(String button) {
		WebElement contactUsButton = webDriver.findElement(By.xpath("//div[3]/a[@href='/en/contact/']"));
		actions.moveToElement(contactUsButton).click().perform();
	}
}
