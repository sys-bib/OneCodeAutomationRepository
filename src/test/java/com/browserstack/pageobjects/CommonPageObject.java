package com.browserstack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;


public class CommonPageObject {
    private WebDriver webDriver;

    private String selectedProductName;

    public CommonPageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.selectedProductName = "";
    }

    private By firstProductName = By.xpath("//*[@id=\"1\"]/p");

    private By firstProductAddToCartButton = By.xpath("//*[@id=\"1\"]/div[4]");

    private By cartPane = By.className("float-cart__content");

    private By productCartText = By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]");

    public void selectFirstProductName() {
        String firstProduct = webDriver.findElement(firstProductName).getText();
        setSelectedProductName(firstProduct);
    }

    public void clickAddToCartButton() {
        webDriver.findElement(firstProductAddToCartButton).click();
    }

    public void waitForCartToOpen() {
        new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartPane));
    }

    public String getProductCartText() {
        return webDriver.findElement(productCartText).getText();
    }

    public void setSelectedProductName(String selectedProductName) {
        this.selectedProductName = selectedProductName;
    }

    public String getSelectedProductName() {
        return selectedProductName;
    }

    public void getConsoleErrorLog() {
        Set<String> logtyp = webDriver.manage().logs().getAvailableLogTypes();
        for (String s : logtyp) {
            System.out.println(logtyp);
        }
        LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry);
        }
    }
}
