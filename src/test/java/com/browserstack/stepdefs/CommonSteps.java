package com.browserstack.stepdefs;

import com.browserstack.pageobjects.CommonPageObject;
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
        driver = new RemoteWebDriver(
                new URL("https://hub.browserstack.com/wd/hub"), capabilities);
        commonPage = new CommonPageObject(driver);
        percy = new Percy(driver);
    }

    @Given("^I am on the website '(.+)'$")
    public void I_am_on_the_website(String url) throws Throwable {
        driver.get(url);
        Thread.sleep(2000);
    }

    @When("^I click on 'Logo' button")
    public void I_click_on_logo_button() throws Throwable {
        commonPage.selectFirstProductName();
        commonPage.clickAddToCartButton();
        Thread.sleep(2000);
    }

    @Then("the product should be added to cart")
    public void product_should_be_added_to_cart() {
        commonPage.waitForCartToOpen();
        Assert.assertEquals(commonPage.getSelectedProductName(), commonPage.getProductCartText());
    }

    @Then("the page title should contain '(.+)'$")
    public void page_title_should_contain(String expectedTitle) {
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

    @After
    public void teardown(Scenario scenario) throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

    @Then("Capture percy with name '(.+)'$")
    public void capture_percy_with_name(String capture_title) {
        percy.snapshot(capture_title);
    }
}
