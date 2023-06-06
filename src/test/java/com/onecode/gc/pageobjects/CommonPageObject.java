package com.onecode.gc.pageobjects;

import io.percy.selenium.Percy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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
	//
	public void fillFieldById(String fieldId, String fieldValue) {
		webDriver.findElement(By.id(fieldId)).sendKeys(fieldValue);
	}
	public void clickButtonById(String buttonId) {
		WebElement buttonElement = webDriver
				.findElement(By.id(buttonId));
		new WebDriverWait(webDriver, Duration.ofSeconds(3))
				.until(ExpectedConditions.elementToBeClickable(buttonElement)).click();
	}
	public void clickButtonByClass(String buttonClass) {
		WebElement buttonElement = webDriver
				.findElement(By.className(buttonClass));
		new WebDriverWait(webDriver, Duration.ofSeconds(1))
				.until(ExpectedConditions.elementToBeClickable(buttonElement)).click();
	}
	public void clickContainText(String elementType, String buttonText) {
		WebElement textElement = webDriver
				.findElement(By.xpath("//" + elementType + "[contains(text()='" + buttonText + "')]"));
		new WebDriverWait(webDriver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(textElement)).click();
	}
	public void clickConfirmationButton()  {
		webDriver.switchTo().alert().accept();
	}
	public void userSearch(){
		webDriver.findElement(By.xpath("//*[@id='ctl03_ctl00_ctl00_ctl00_ctl00_ctl00_usersList_ctl00__1']/td[2]/div/a/span[2]")).click();
	}

	//iris
	public void login()
	{
		webDriver.findElement(By.xpath("//*[@id=\"kt_body\"]/div/div/div/div/div/div/form/div/button")).click();
	}
	//master ep
	public void aksesmasterep()
	{
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/span")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div[1]/a")).click();
	}
	public void clickbtnnewmaster()
	{
		webDriver.findElement(By.id("btnCreate")).click();
	}
	public void clickbtnnewmasterkl()
	{
		webDriver.findElement(By.id("kt_drawer_example_dismiss_button")).click();
	}
	public void fillhsh(String fieldValue)
	{
		webDriver.findElement(By.cssSelector(".select2-selection")).click();
		webDriver.findElement(By.cssSelector(".select2-search__field")).sendKeys(fieldValue);
	}
	public void enterhsh(){webDriver.findElement(By.cssSelector(".select2-search__field")).sendKeys(Keys.ENTER);}
	public void fillep(String fieldValue)
	{
		webDriver.findElement(By.id("kodePerusahaanInput")).sendKeys(fieldValue);
	}
	public void fillnp(String fieldValue)
	{
		webDriver.findElement(By.id("namaPerusahaanInput")).sendKeys(fieldValue);
	}
	public void clicksubmit()
	{
		webDriver.findElement(By.id("CreateSubmit")).click();
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
	}
	public void assertsuccesssumbit(){
		Assert.assertEquals(webDriver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]")).getText(),"Form has been successfully submitted!");
	}

	public void aksesmasterfungsi()
	{
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/span")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div[2]/a")).click();
	}
	public void filldep(String fieldValue)
	{
		webDriver.findElement(By.cssSelector(".select2-selection")).click();
		webDriver.findElement(By.cssSelector(".select2-search__field")).sendKeys(fieldValue);

	}
	public void enterep(){webDriver.findElement(By.cssSelector(".select2-search__field")).sendKeys(Keys.ENTER);}
	public void fillnamafungsi(String fieldValue)
	{
		webDriver.findElement(By.id("fungsiNameInput")).sendKeys(fieldValue);
	}
	public void filldeskripsi(String fieldValue)
	{
		webDriver.findElement(By.id("descriptionInput")).sendKeys(fieldValue);
	}
	public void aksesmasterpf()
	{
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/span")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div[3]/a")).click();
	}
	public void fillnf(String fieldValue)
	{
		webDriver.findElement(By.cssSelector(".select2-selection")).click();
		webDriver.findElement(By.cssSelector(".select2-search__field")).sendKeys(fieldValue);
	}
	public void enternf(){webDriver.findElement(By.cssSelector(".select2-search__field")).sendKeys(Keys.ENTER);}
	public void fillnamapic(String fieldValue)
	{
		webDriver.findElement(By.id("picNameInput")).sendKeys(fieldValue);
	}
	public void fillnotelp(String fieldValue)
	{
		webDriver.findElement(By.id("phoneInput")).sendKeys(fieldValue);
	}
	public void fillemail(String fieldValue)
	{
		webDriver.findElement(By.id("emailInput")).sendKeys(fieldValue);
	}
	public void aksesmasterinterest()
	{
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/span")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div[4]/a")).click();
	}
	public void fillnamainterest(String fieldValue)
	{
		webDriver.findElement(By.id("namaInput")).sendKeys(fieldValue);
	}
	public void fillorder(String fieldValue)
	{
		webDriver.findElement(By.id("orderInput")).sendKeys(fieldValue);
	}
	public void aksesmasterkl()
	{
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/span")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div[5]/a")).click();
	}
	public void fillnamakl(String fieldValue)
	{
		webDriver.findElement(By.id("lembagaName")).sendKeys(fieldValue);
	}
	public void aksesmasterkp()
	{
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/span")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div[6]/a")).click();
	}
	public void fillnamakp(String fieldValue)
	{
		webDriver.findElement(By.id("nama")).sendKeys(fieldValue);
	}
	public void fillorderkp(String fieldValue)
	{
		webDriver.findElement(By.id("orderSeq")).sendKeys(fieldValue);
	}
	public void aksesmastersb()
	{
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/span")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div[7]/a")).click();
	}
	public void fillnamasb(String fieldValue)
	{
		webDriver.findElement(By.id("namaInput")).sendKeys(fieldValue);
	}
	public void aksesmastertm()
	{
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/span")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div[8]/a")).click();
	}
	public void fillnamatm(String fieldValue)
	{
		webDriver.findElement(By.id("namaInput")).sendKeys(fieldValue);
	}

}