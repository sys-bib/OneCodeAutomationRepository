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


    @Given("access master entitas pertamina")
    public void accessMasterEntitasPertamina() {
        commonPage.aksesmasterep();
    }

    @Then("click button add entitas pertamina")
    public void clickButtonAddEntitasPertamina() {
        commonPage.clickbtnnewmaster();
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


    @Then("check success submit")
    public void checkSuccessSubmit() {
        commonPage.assertsuccesssumbit();
    }

    @Given("access master fungsi")
    public void accessMasterFungsi() {
        commonPage.aksesmasterfungsi();
    }


    @Then("click button add fungsi")
    public void clickButtonAddFungsi() {
        commonPage.clickbtnnewmaster();
    }


    @When("i fill in the column entitas pertamina with{string}")
    public void iFillInTheColumnEntitasPertaminaWithBadak(String fieldValue) {
        commonPage.filldep(fieldValue);
    }

    @And("choose ep")
    public void chooseEp() {
        commonPage.enterep();
    }

    @And("i fill in the column namafungsi with {string}")
    public void iFillInTheColumnNamafungsiWithTestinfungsi(String fieldValue) {
        commonPage.fillnamafungsi(fieldValue);
    }


    @And("i fill in the column deskripsi with {string}")
    public void iFillInTheColumnDeskripsiWithTesdeskripsi(String fieldValue) {
        commonPage.filldeskripsi(fieldValue);
    }

    @Given("access master pic fungsi")
    public void accessMasterPicFungsi() {
        commonPage.aksesmasterpf();
    }


    @Then("click button add pic fungsi")
    public void clickButtonAddPicFungsi() {
        commonPage.clickbtnnewmaster();
    }

    @When("i fill in the column dnamafungsi with{string}")
    public void iFillInTheColumnDnamafungsiWithMarketing(String fieldValue) {
        commonPage.fillnf(fieldValue);
    }

    @And("choose nf")
    public void chooseNf() {
        commonPage.enternf();
    }

    @And("i fill in the column namapic with {string}")
    public void iFillInTheColumnNamapicWithTestingpic(String fieldValue) {
        commonPage.fillnamapic(fieldValue);
    }

    @And("i fill in the column notelp with {string}")
    public void iFillInTheColumnNotelpWith(String fieldValue) {
        commonPage.fillnotelp(fieldValue);
    }

    @And("i fill in the column email with {string}")
    public void iFillInTheColumnEmailWithTestingTesCom(String fieldValue) {
        commonPage.fillemail(fieldValue);
    }
    
    @Given("access master interest")
    public void accessMasterInterest() {
        commonPage.aksesmasterinterest();
    }

    @Then("click button add interest")
    public void clickButtonAddInterest() {
        commonPage.clickbtnnewmaster();
    }

    @When("i fill in the column nama interest with {string}")
    public void iFillInTheColumnNamaInterestWithTesInterest(String fieldValue) {
        commonPage.fillnamainterest(fieldValue);
    }

    @And("i fill in the column order with {string}")
    public void iFillInTheColumnOrderWith(String fieldValue) {
        commonPage.fillorder(fieldValue);
    }

    @Given("access master kementrianlembaga")
    public void accessMasterKementrianlembaga() {
        commonPage.aksesmasterkl();
    }

    @Then("click button add kementrianlembaga")
    public void clickButtonAddKementrianlembaga() {
        commonPage.clickbtnnewmasterkl();
    }

    @Then("i fill in the column nama kementrianlembaga with {string}")
    public void iFillInTheColumnNamaKementrianlembagaWithTesInterest(String fieldValue) {
        commonPage.fillnamakl(fieldValue);
    }

    @Given("access master kesiapanproyek")
    public void accessMasterKesiapanproyek() {
        commonPage.aksesmasterkp();
    }

    @Then("click button add kesiapanproyek")
    public void clickButtonAddKesiapanproyek() {
        commonPage.clickbtnnewmaster();
    }

    @When("i fill in the column nama kesiapanproyek with {string}")
    public void iFillInTheColumnNamaKesiapanproyekWithTesKesiapanProyek(String fieldValue) {
        commonPage.fillnamakp(fieldValue);
    }

    @And("i fill in the column orderkp with {string}")
    public void iFillInTheColumnOrderkpWith(String fieldValue) {
        commonPage.fillorderkp(fieldValue);
    }

    @Given("access master streambusiness")
    public void accessMasterStreambusiness() {
        commonPage.aksesmastersb();
    }

    @Then("click button add streambusiness")
    public void clickButtonAddStreambusiness() {
        commonPage.clickbtnnewmaster();
    }

    @When("i fill in the column nama streambusiness with {string}")
    public void iFillInTheColumnNamaStreambusinessWithTesStreamBusiness(String fieldValue) {
        commonPage.fillnamasb(fieldValue);
    }

    @Given("access master targetmitra")
    public void accessMasterTargetmitra() {
        commonPage.aksesmastertm();
    }

    @Then("click button add targetmitra")
    public void clickButtonAddTargetmitra() {
        commonPage.clickbtnnewmaster();
    }

    @When("i fill in the column nama targetmitra with {string}")
    public void iFillInTheColumnNamaTargetmitraWithTesTargetMitra(String fieldValue) {
        commonPage.fillnamatm(fieldValue);
    }
}
