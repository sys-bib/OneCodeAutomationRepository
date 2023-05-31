package com.onecode.gc.stepdefs;

import com.onecode.gc.pageobjects.CommonPageObject;
import com.onecode.gc.utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class MasterIrisSteps {
    TestContext testContext;
    private CommonPageObject commonPage;
    private WebDriver driver;

    public MasterIrisSteps(TestContext context) {
        testContext = context;
        commonPage = new CommonPageObject(testContext.webDriver);
        driver = testContext.webDriver;
    }

    @Given("access website {string}")
    public void accessWebsiteHttpsLocalhost(String url) throws InterruptedException {
        commonPage.OpenUrl(url);
        Thread.sleep(2000);
    }

    @Then("login")
    public void login() {
        commonPage.login();
    }


    @Then("access master entitas pertamina")
    public void accessMasterEntitasPertamina() {
        commonPage.aksesmasterep();
    }

    @Then("click button add entitas pertamina")
    public void clickButtonAddEntitasPertamina() {
        commonPage.clickbtnnewep();
    }

    @When("i fill in the column hsh with{string}")
    public void iFillInTheColumnHshWith(String fieldValue) {
        commonPage.fillhsh(fieldValue);
    }

    @And("choose hsh")
    public void chooseHsh() {
        commonPage.enterhsh();
    }

    @And("i fill in the column kodeperusahaan with {string}")
    public void iFillInTheColumnKodeperusahaanWithKodeTes(String fieldValue) {
        commonPage.fillep(fieldValue);
    }

    @And("i fill in the column namaperusahaan with {string}")
    public void iFillInTheColumnNamaperusahaanWithNamaTes(String fieldValue) {
        commonPage.fillnp(fieldValue);
    }

    @Then("i click submit")
    public void iClickSubmit() {
        commonPage.clicksubmit();
    }

}
