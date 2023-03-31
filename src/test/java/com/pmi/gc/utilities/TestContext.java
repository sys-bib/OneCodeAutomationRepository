package com.pmi.gc.utilities;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class TestContext {

	public WebDriver webDriver;

	public TestContext() throws MalformedURLException {
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, String> bstackOptions = new HashMap<>();
		bstackOptions.putIfAbsent("source", "cucumber-java:sample-sdk:v1.1");
		capabilities.setCapability("bstack:options", bstackOptions);
		webDriver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), capabilities);
		webDriver.manage().window().maximize();
	}
}