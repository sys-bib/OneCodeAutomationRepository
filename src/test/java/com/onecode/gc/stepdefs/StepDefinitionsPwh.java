package com.onecode.gc.stepdefs;

import com.onecode.gc.pageobjects.CommonPageObject;
import com.onecode.gc.utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class StepDefinitionsPwh {

    TestContext testContext;
    private CommonPageObject commonPage;
    private WebDriver driver;

    public StepDefinitionsPwh(TestContext context) {
        testContext = context;
        commonPage = new CommonPageObject(testContext.webDriver);
        driver = testContext.webDriver;
    }


    @Given("User navigate to Project With Heart Sitefinity login page")
    public void user_navigate_to_Project_With_Heart_Sitefinity_login_page()  {
        driver.get("https://dev.pwh.org/Sitefinity/");
    }

    @And("User enters a valid username")
    public void user_enters_a_valid_username()  {
        driver.findElement(By.id("username")).sendKeys("ataufiq1@PMINTL.NET");
    }

    @And("User enters a valid password")
    public void user_enters_a_valid_password()  {
        driver.findElement(By.id("password")).sendKeys("Sampoerna!@#4");
    }

    @And("User click login button")
    public void user_click_login_button() throws InterruptedException  {
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(5000);
    }

    @When("User should be taken to self logout page")
    public void user_should_be_taken_to_self_logout_page()  {
        WebElement selfLogOut = driver.findElement(By.xpath("//*[contains(text(),'Login to manage the site')]"));
        Assert.assertTrue(selfLogOut.isDisplayed());
    }

    @Then("User click to self logout button")
    public void user_click_to_self_logout_button() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='ctl03_ctl00_ctl00_ctl00_ctl00_ctl00_selfLogoutButton']/strong")).click();
    }

    @And("User click confirmation button")
    public void user_click_confirmation_button()  {
        driver.switchTo().alert().accept();
    }

    @Then("User should be taken sitefinity dashboard page")
    public void user_should_be_taken_sitefinity_dashboard_page() throws InterruptedException {
        Thread.sleep(15000);
        WebElement dashboard = driver.findElement(By.xpath("//span[normalize-space()='Dashboard']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Dashboard']")));
        Assert.assertTrue(dashboard.isDisplayed());
    }

    @Given("Click administration menu")
    public void click_administration_menu() {
        driver.findElement(By.xpath("//span[normalize-space()='Administration']")).click();
    }
    @And("Go to users menu")
    public void go_to_users_menu() {
        driver.findElement(By.xpath("//span[normalize-space()='Users']")).click();
    }
    @And("Open search field")
    public void open_search_field() {
        driver.findElement(By.id("findUsersLink")).click();
    }
    @And("Fill search keyword")
    public void fill_search_keyword() throws InterruptedException {
        driver.findElement(By.id("filterText")).sendKeys("agam");
        Thread.sleep(3000);
    }
    @When("Click search button")
    public void click_search_button() throws InterruptedException {
        driver.findElement(By.id("A1")).click();
        Thread.sleep(3000);
    }
    @And("Click users according search keyword")
    public void click_users_according_search_keyword() {
        driver.findElement(By.xpath("//*[@id='ctl03_ctl00_ctl00_ctl00_ctl00_ctl00_usersList_ctl00__1']/td[2]/div/a/span[2]")).click();
    }
    @Then("User page should be open")
    public void user_page_should_be_open() {
        new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("editUserDialog")));
    }
    @And("Click organization profile section")
    public void click_organization_profile_section() throws InterruptedException{
        Thread.sleep(10000);
        driver.findElement(By.id("userEditDialog_ctl00_ctl00_profilesData_section_1_ctl00_ctl00_sectionTitleLabel")).click();
    }
    @Then("Validate country")
    public void validate_country() throws InterruptedException {
        Thread.sleep(5000);
        String country = driver.findElement(By.id("userEditDialog_ctl00_ctl00_profilesData_section_1_ctl00_ctl00_fields_ctl00_0_ctl00_0_ctl00_0_textBox_write_0")).getAttribute("value");
        System.out.println(country);
    }
    @And("Click back to users button")
    public void click_back_to_users_button() throws InterruptedException{
        driver.findElement(By.id("userEditDialog_ctl00_ctl00_lblBackToLink")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        driver.findElement(By.id("MainMenuPanel_ctl00_ctl00_backToLink")).click();
        Thread.sleep(3000);

    }
    @And("Click pages menu")
    public void click_pages_menu() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[normalize-space()='Pages']")).click();
    }
    @Then("pages menu should be open")
    public void pages_menu_should_be_open() throws InterruptedException {
        //new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.visibilityOfElementLocated(By.name("editUserDialog")));
        Thread.sleep(30000);
        WebElement pages = driver.findElement(By.xpath("//h1[@class='-sf-h-large -sf-fade-in'] [contains (text(), 'Pages')]"));
        Assert.assertTrue(pages.isDisplayed());
    }
    @When("Click donation page")
    public void click_donation_page() throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[normalize-space()='Donation']")).click();
        Thread.sleep(5000);
    }
    @And("Click edit at donation widget")
    public void click_edit_at_donation_widget() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_MainContent_ctl09_T']/ul/li[1]/a/span")));
        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_ctl09_T']/ul/li[1]/a/span")).click();
        Thread.sleep(10000);
    }
    @And("Choose whitelist mode")
    public void choose_whitelist_mode() throws InterruptedException {
        Thread.sleep(8000);
        driver.findElement(By.id("whitelist")).click();
    }
    @And("Choose blacklist mode")
    public void choose_blacklist_mode() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("blacklist")).click();
        Thread.sleep(5000);
    }
    @And("Choose whitelist country")
    public void choose_whitelist_country() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("div[ng-show='showWhiteList'] span[ng-hide='changeButtonText']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='All']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div[3]/div[1]/sf-items-filter/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div[3]/div[1]/sf-items-filter/input")).sendKeys("indonesia");
        Thread.sleep(8000);
        String wlCountryCheck = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[1]/div[1]/input")).getAttribute("checked");
        if (wlCountryCheck == null ) {
            driver.findElement(By.xpath("//div[contains(text(),'Indonesia')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[normalize-space()='Done selecting']")).click();
            System.out.print("white list country is set");
        } else {
            System.out.println("country is already selected");
            driver.findElement(By.xpath("//button[normalize-space()='Done selecting']")).click();

        }
    }
    @And("Choose blacklist country")
    public void choose_blacklist_country() throws InterruptedException {

        driver.findElement(By.cssSelector("div[ng-show='showBlackList'] span[ng-hide='changeButtonText']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='All']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div[3]/div[1]/sf-items-filter/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div[3]/div[1]/sf-items-filter/input")).sendKeys("indonesia");
        Thread.sleep(5000);
        String blCountryCheck = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[1]/div[1]/input")).getAttribute("checked");
        System.out.println(blCountryCheck);
        Thread.sleep(5000);
        if (blCountryCheck == null ) {
            driver.findElement(By.xpath("//div[contains(text(),'Indonesia')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[normalize-space()='Done selecting']")).click();
            System.out.print("black list country is set");
        } else {
            System.out.println("country is already selected");
            driver.findElement(By.xpath("//button[normalize-space()='Done selecting']")).click();

        }
    }
    @Then("Click save button")
    public void click_save_button() {
        driver.findElement(By.xpath("//button[@class='btn btn-primary pull-left ng-scope']")).click();
    }
    @And("Click publish button")
    public void click_publish_button() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='sf-button__content ng-star-inserted'][normalize-space()='Publish']")).click();
        Thread.sleep(5000);
    }
    @Then("Go to project with heart frontend")
    public void go_to_project_with_heart_frontend() {
        driver.get("https://dev.projectswithaheart.pconnect.biz/home");
        WebElement pwhDashboard = driver.findElement(By.xpath("//h2[normalize-space()='OUR MISSION']"));
        Assert.assertTrue(pwhDashboard.isDisplayed());
    }
    @And("Open donation page")
    public void Open_donation_page() {
        driver.findElement(By.id("ButtonDonateNow")).click();
    }
    @Then("Donation page should be open")
    public void donation_page_should_be_open() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");
        Thread.sleep(2000);
        //assert currency default, change value(IDR) to another currency if you want to test with another default currency base on country
        String value1 = driver.findElement(By.id("listCurrency")).getAttribute("value");
        Assert.assertEquals(value1, "IDR");
    }
    @And("Validate white list country donation")
    public void validate_white_list_country_donation() {
        WebElement donationButton = driver.findElement(By.className("switch"));
        try {
            Assert.assertTrue(donationButton.isDisplayed());
            System.out.print("Donation button is active");
        } catch (NoSuchElementException e) {
            System.out.println("Switch Donation element is not visible");
            Assert.assertTrue(false);
        }
    }
    @Then("Validate black list country donation")
    public void validate_black_list_country_donation() throws InterruptedException {
        //WebElement donationButton = driver.findElement(By.className("switch"));
        try {
            driver.findElement(By.xpath("//div[@class = 'row mb-3 px-3']"));
            Assert.assertTrue(false);
            System.out.println("Switch Donation element is visible");

        }
        catch(NoSuchElementException e) {
            System.out.println("Switch Donation element is not visible");
            Assert.assertTrue(true);
            System.out.print(true);

        }
    }
    @And("open donation page")
    public void open_donation_page() {
        driver.findElement(By.id("ButtonDonateNow")).click();
    }
    @And("Click amount of donation")
    public void click_amount_of_donation() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.id("DonationAmount10000_IDR")).click();
    }
    @Given("Click custom amount of donation")
    public void click_custom_amount_of_donation() throws InterruptedException {
        driver.findElement(By.id("DonationAmount0_IDR")).sendKeys("10000");
        Thread.sleep(5000);
    }
    @And("Click donate button")
    public void click_donate_button() throws InterruptedException {
        driver.findElement(By.xpath("//*[@ng-click='SubmitPayment()']")).click();
        Thread.sleep(20000);
    }
    @Then("Stripe page should be open")
    public void stripe_page_should_be_open() throws InterruptedException {
        driver.findElement(By.id("cardNumber")).sendKeys("4242424242424242");
        driver.findElement(By.id("cardExpiry")).sendKeys("1123");
        driver.findElement(By.id("cardCvc")).sendKeys("343");
        Thread.sleep(2000);
        driver.findElement(By.id("billingName")).sendKeys("test qa");
    }
    @And("Click subscribe button")
    public void click_subscribe_button() throws InterruptedException {
        driver.findElement(By.className("SubmitButton-IconContainer")).click();
        Thread.sleep(20000);
    }
    @Then("Donate process should be successfully")
    public void donate_process_should_be_successfully() throws InterruptedException {
        WebElement donateSuccess = driver.findElement(By.xpath("//*[@id='MainContent_C002_Col01']/div/div/h4[3]"));
        Assert.assertTrue(donateSuccess.isDisplayed());
    }
    @And("Go to donation history to validate donation")
    public void go_to_donation_history_to_validate_donation() throws InterruptedException {
        driver.findElement(By.id("ContentProfilePicture")).click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 450)");
        Thread.sleep(10000);
        driver.findElement(By.id("DonationHistoryMenuLabel")).click();
    }
    @Then("Donation history page should be open")
    public void donation_history_page_should_be_open() throws InterruptedException {
        Thread.sleep(3000);
        WebElement donationHistory = driver.findElement(By.xpath("//h3[contains (text(), 'Donation History')]"));
        Assert.assertTrue(donationHistory.isDisplayed());
    }
    @And("Last transaction donation amount should be same")
    public void last_transaction_donation_amount_should_be_same() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor sc = (JavascriptExecutor) driver;
        sc.executeScript("window.scrollBy(0, 100)");
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//*[@id='donation-section']/div/div[2]/div/div[1]/div/div[2]/div[1]/h2"));
        System.out.println(element.getText());
        Assert.assertEquals(element.getText(), "IDR 10000");
        Thread.sleep(2000);
    }
    @Given("open active projects page")
    public void open_active_projects_page() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='navbarDropdownMenuLink-1'] [contains(text(),'Projects')]"))).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@class='dropdown']//a[normalize-space()='Active']")).click();
        Thread.sleep(5000);
    }
    @And("active projects page should be open")
    public void active_projects_page_should_be_open() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='second-btn-full ng-scope']"));
    }
    @And("open_project")
    public void open_project() throws InterruptedException {
//        driver.findElement(By.id("period_select_range_btn")).click();
//        driver.findElement(By.xpath("//*[@id='selectPeriodRangePane']/form/input[1]")).sendKeys("indonesia");
//        Thread.sleep(3000);
//        driver.findElement(By.className("filter")).click();
//        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("//div[@id='prj_88393f6b-4558-4b0b-b715-e8551f298e0e']//p[@class='contenttopcorner ng-binding'][normalize-space()='Indonesia']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(30000);
        driver.findElement(By.xpath("//*[@id='prj_88393f6b-4558-4b0b-b715-e8551f298e0e']/div/a/div[2]/h4")).click();
    }
    @Then("project page should be open")
    public void project_page_should_be_open() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("detailproject")).isDisplayed();
    }
    @Given("click payroll donation button")
    public void click_payroll_donation_button() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 325)");
        Thread.sleep(15000);
        driver.findElement(By.xpath("//button[@class='tertiary-btn mt-2 active']")).click();
        Thread.sleep(10000);
    }
    @And("payroll donation page should be open")
    public void payroll_donation_page_should_be_open() throws InterruptedException {
        Thread.sleep(5000);
        String titleTab = driver.getTitle();
        Assert.assertEquals(titleTab, "Donation Payroll");
    }
    @And("validate company email")
    public void validate_company_email() throws InterruptedException {
        Assert.assertEquals(driver.findElement(By.id("ID_DonaturEmail")).getAttribute("value"), "ataufiq1@PMINTL.NET");
        Thread.sleep(2000);
    }
    @And("input amount donation")
    public void input_amount_donation() throws InterruptedException {
        driver.findElement(By.id("ID_DonationAmount")).sendKeys("10000");
        Thread.sleep(2000);
    }
    @And("input pmi employee id")
    public void input_pmi_employee_id() throws InterruptedException {
        driver.findElement(By.id("ID_EmployeeID")).sendKeys("testQA");
        Thread.sleep(2000);
    }
    @Given("term and conditions payroll donation")
    public void term_and_conditions_payroll_donation() throws InterruptedException {
        driver.findElement(By.id("CheckboxesFieldController_0")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("CheckboxesFieldController_1")).click();
        Thread.sleep(1000);
    }
    @And("Click submit payroll donation button")
    public void click_submit_payroll_donation_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
    }
    @Given("quit step")
    public void quit_step() {
        driver.quit();
    }

    @Given("Click ambassadors menu")
    public void click_ambassadors_menu() throws InterruptedException {
        driver.get("https://dev.projectswithaheart.pconnect.biz/home");
        Thread.sleep(7000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'ABOUT US')]"))).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(text(),'Ambassadors')]")).click();
    }
    @When("Ambassadors page should be open")
    public void ambassadors_page_should_be_open() {
        Assert.assertEquals("Ambassadors", driver.getTitle());
    }
    @And("Click join family button")
    public void click_join_family_button() throws InterruptedException{
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div[1]/div[1]/div/h3"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='primary-btn-full']")).click();
        Thread.sleep(5000);
    }
    @And("Fill your reason to join field")
    public void fill_your_reason_to_join_field() {
        for (int i = 0; i < 22; i++) {
            driver.findElement(By.xpath("//*[@id='ClosureAmbassadorForm']/div[2]/textarea")).sendKeys("This text for automation test");
        }
    }
    @And("Select your regional")
    public void select_your_regional() {
        driver.findElement(By.id("select2-selCountry-container")).click();
        WebElement regionalInput = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
        regionalInput.click();
        regionalInput.sendKeys("Indonesia");
        regionalInput.sendKeys(Keys.ENTER);

    }
    @And("Fill hour permonth to volunteer")
    public void fill_hour_permonth_to_volunteer() {
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("5");
    }
    @And("Fill language to speak")
    public void fill_language_to_speak() {
        driver.findElement(By.xpath("//input[@ng-model='RequestForm.Language']")).sendKeys("English");
    }
    @And("Which skill to volunteer")
    public void which_skill_to_volunteer() throws InterruptedException {
        driver.findElement(By.xpath("//input[@ng-model='RequestForm.Skills']")).sendKeys("Carpenter");
        Thread.sleep(3000);
    }
    @When("Click submit button")
    public void click_submit_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='second-btn-full']")).click();
        Thread.sleep(5000);
        Alert alertDialog = driver.switchTo().alert();
        String alertText = alertDialog.getText();
        System.out.println("Alert message: "+alertText);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
    }

    @Then("Check submit ambassador status")
    public void check_submit_ambassador_status() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("ContentProfilePicture")).click();
        Thread.sleep(5000);
        WebElement scrollElement = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div[1]/div/div[2]/h4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", scrollElement);
        Thread.sleep(5000);
        driver.findElement(By.id("ApprovalMenuLabel")).click();
        Thread.sleep(5000);
        WebElement pendingApprovalElement = driver.findElement(By.xpath("//*[@id='approval-section']/div/div[2]/div/div[2]/button"));
        Assert.assertEquals("UNDER REVIEW", pendingApprovalElement.getText());
        Thread.sleep(5000);
    }
    @And("Open sitefinity page")
    public void open_sitefinity_page() throws InterruptedException {
        driver.get("https://dev.projectswithaheart.pconnect.biz/Sitefinity");
        Thread.sleep(7000);
    }
    @And("Open ambassador content menu")
    public void open_ambassador_content_menu() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Content')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Ambassadors')]")).click();
        Thread.sleep(5000);
    }
    @And("Open project content menu")
    public void open_project_content_menu() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Content')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();
        Thread.sleep(5000);
    }
    @And("Open user ambassador")
    public void open_user_ambassador() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='adminAppWrapper']/sf-app/div/ng-component/div[2]/ng-component/sf-navigation-menu/header/sf-search")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("indonesia");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='adminAppWrapper']/sf-app/div/ng-component/div[2]/ng-component/div/main/sf-list/div/sf-loader-wrapper[1]/sf-tree/tree/tree-viewport/div/div/tree-node-collection/div/tree-node[2]/div/tree-node-wrapper/div/div/tree-node-content/div/div[1]/sf-component-loader/sf-main-field/div/div/div/span/span/b")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//*[@id='adminAppWrapper']/sf-app/div/ng-component/div[2]/ng-component/div/main/sf-list/div/sf-loader-wrapper[1]/sf-tree/tree/tree-viewport/div/div/tree-node-collection/div/tree-node[1]/div/tree-node-wrapper/div/div/tree-node-content/div/div[2]/sf-component-loader/sf-main-field/div/div/div")).click();
        Thread.sleep(7000);
    }
    @When("Choose reject")
    public void choose_reject() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='ApprovalStatus_2']")).click();
        Thread.sleep(500);

    }
    @And("Save ambassador changes")
    public void save_ambassador_changes() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='sf-button -action ng-star-inserted']")).click();
        Thread.sleep(5000);
    }
    @And("Reject ambassador validation")
    public void reject_ambassador_validation() throws InterruptedException {
        WebElement pendingApprovalElement = driver.findElement(By.xpath("//*[@id='approval-section']/div/div[2]/div/div[2]/button"));
        Assert.assertEquals("REJECTED", pendingApprovalElement.getText());
        Thread.sleep(5000);

    }
    @And("Terminate ambassador validation")
    public void terminate_ambassador_validation() throws InterruptedException {
        WebElement pendingApprovalElement = driver.findElement(By.xpath("//*[@id='approval-section']/div/div[2]/div/div[2]/button"));
        Assert.assertEquals("TERMINATED", pendingApprovalElement.getText());
        Thread.sleep(5000);

    }
    @And("Project content menu should be open")
    public void project_content_menu_should_be_open() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='adminAppWrapper']/sf-app/div/ng-component/div[2]/ng-component/div/main/div/div[1]/h1")).isDisplayed());
        Thread.sleep(2000);
    }

    @And("Search project")
    public void search_project() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='adminAppWrapper']/sf-app/div/ng-component/div[2]/ng-component/sf-navigation-menu/header")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("automation submit title");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }
    @And("Open submit project")
    public void open_submit_project() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='adminAppWrapper']/sf-app/div/ng-component/div[2]/ng-component/div/main/sf-list/div/sf-loader-wrapper[1]/sf-tree/tree/tree-viewport/div/div/tree-node-collection/div/tree-node[1]/div/tree-node-wrapper/div/div/tree-node-content/div/div[1]")).click();
        Thread.sleep(5000);
        WebElement h1 = driver.findElement(By.tagName("h1"));
        Thread.sleep(500);
        Assert.assertTrue(h1.isDisplayed());
        Thread.sleep(2000);
    }
    @And("Open the project")
    public void open_the_project() throws InterruptedException {
        driver.findElement(By.xpath("//b[text()=' Automation Submit title']")).click();
        Thread.sleep(5000);
        WebElement h1 = driver.findElement(By.tagName("h1"));
        Thread.sleep(2000);
        Assert.assertTrue(h1.isDisplayed());
    }
    @And("Click more options project")
    public void click_more_options_project() throws InterruptedException {
        driver.findElement(By.xpath("//i[@title='More Options']")).click();
        Thread.sleep(5000);
    }
    @And("Click delete project")
    public void click_delete_project() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='adminAppWrapper']/sf-app/div/ng-component/div[2]/ng-component/sf-edit-item-menu/sf-navigation-menu/header/div[1]/div[3]/sf-action-menu/sf-button[3]/div/div/div/div[11]")).click();
        Thread.sleep(5000);
    }
    @And("Confirm delete project")
    public void confirm_delete_project() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains (text(), 'Delete this project?')]")).isDisplayed());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='adminAppWrapper']/sf-app/div/ng-component/sf-modal-window/aside/footer/div/sf-button[1]/button/span")).click();
        Thread.sleep(5000);
    }
    @When("Click submit button and validate popup message")
    public void click_submit_button_and_validate_popup_message() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='second-btn-full']")).click();
        Thread.sleep(2000);
        Alert alertDialog = driver.switchTo().alert();
        String alertText = alertDialog.getText();
        System.out.println("Alert message: "+alertText);
        Assert.assertEquals("Your last request still under review", alertText);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='close']")).click();
        Thread.sleep(2000);
    }
    @When("Submit ambassadors form should be open")
    public void submit_ambassadors_form_should_be_open() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='becomeambassador']/div/div/div[1]/div/div[1]/h4")).isDisplayed());
    }
    @And("Login as approval")
    public void login_as_approval() throws InterruptedException {
        driver.get("https://dev.pwh.org/Sitefinity/");
        Thread.sleep(5000);
        driver.findElement(By.id("username")).sendKeys("admin@pmi.com");
        driver.findElement(By.id("password")).sendKeys("Sampoerna!@#4");
        Thread.sleep(500);
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(5000);
        String logoutPage = driver.getTitle();
        Thread.sleep(5000);
        if (logoutPage.equals("User Already Logged In")) {
            driver.findElement(By.xpath("//*[@id='ctl03_ctl00_ctl00_ctl00_ctl00_ctl00_selfLogoutButton']/strong")).click();
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
        } else {
            System.out.println("We are on Dashboard");
        }

    }
    @When("Login as user")
    public void login_as_user() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://dev.pwh.org/Sitefinity/");
        driver.findElement(By.id("username")).sendKeys("ataufiq1@PMINTL.NET");
        driver.findElement(By.id("password")).sendKeys("Sampoerna!@#4");
        Thread.sleep(3000);
        driver.findElement(By.id("loginButton")).click();
        String logoutPage = driver.getTitle();
        Thread.sleep(5000);
        if (logoutPage.equals("User Already Logged In")) {
            driver.findElement(By.xpath("//*[@id='ctl03_ctl00_ctl00_ctl00_ctl00_ctl00_selfLogoutButton']/strong")).click();
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
        } else {
            System.out.println("We are on Dashboard");
        }
//        driver.switchTo().alert().accept();
//        Thread.sleep(15000);
//        WebElement dashboard = driver.findElement(By.xpath("//span[normalize-space()='Dashboard']"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Dashboard']")));
//        Assert.assertTrue(dashboard.isDisplayed());
    }
    @And("Open project with heart homepage")
    public void open_project_with_heart_homepage() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://dev.projectswithaheart.pconnect.biz/home");
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = driver.findElement(By.id("ContentProfilePicture"));
        wait.until(ExpectedConditions.visibilityOf(element));
        Thread.sleep(5000);
    }
    @And("Open profile page")
    public void open_profile_page() throws InterruptedException{
        Thread.sleep(5000);
        driver.findElement(By.id("ContentProfilePicture")).click();
        Thread.sleep(5000);
    }
    @And("Go to approval page")
    public void go_to_approval_page() throws InterruptedException {
        driver.findElement(By.id("ContentProfilePicture")).click();
        Thread.sleep(5000);
        WebElement element2 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div[1]/div/div[2]/h4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element2);
        Thread.sleep(3000);
        driver.findElement(By.id("ApprovalMenuLabel")).click();
        Thread.sleep(5000);
    }
    @When("Approval page should be open")
    public void approval_page_should_be_open() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='approval-section']/div/h3")).isDisplayed());
    }
    @And("Click under review button")
    public void click_under_review_button() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div[1]/div/div[2]/h4"))).perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='approval-section']/div/div[2]/div/div[2]/button")).click();
        Thread.sleep(5000);
    }

    @And("Validate project status is revise")
    public void validate_project_status_is_revise() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div[1]/div/div[2]/h4"))).perform();
        Thread.sleep(5000);
        WebElement needRevision = driver.findElement(By.xpath("//*[@id='myproject-section']/div/div[1]/div/div[2]/button"));
        Thread.sleep(1000);
        Assert.assertEquals("NEED REVISION", needRevision.getText());
    }
    @And("Click need revise button")
    public void click_need_revise_button() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='myproject-section']/div/div[1]/div/div[2]/button")).click();
        Thread.sleep(3000);
    }
    @And("Click ok button to open revise form")
    public void click_ok_button_to_open_revise_form() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='reviseproject']/div/div/div[2]/button")).click();
        Thread.sleep(3000);
    }
    @And("Click submit button to submit revise project")
    public void click_sumbit_button_to_submit_revise_project() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='reviewproject']/div/div/div[2]/div/div/form/div[13]/button")).click();
        Thread.sleep(3000);
    }
    @And("Click submit button to submit revise closure project")
    public void click_sumbit_button_to_submit_revise_closure_project() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[16]/button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[16]/button")).click();
        Thread.sleep(3000);
    }
    @And("Click reject button")
    public void click_reject_button() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='reviewAmbassador']/div/div/div[2]/div/div/div[2]/div[4]/input"))).perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='reviewAmbassador']/div/div/div[2]/div/div/div[2]/div[8]/button[1]")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
    }
    @And("Click approve button")
    public void click_approve_button() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='reviewAmbassador']/div/div/div[2]/div/div/div[2]/div[4]/input"))).perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='reviewAmbassador']/div/div/div[2]/div/div/div[2]/div[8]/button[2]")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
    }
    @And("Open browser")
    public void open_browser() throws InterruptedException {
        Thread.sleep(2000);
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/main/java/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options);
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(240));
        driver.manage().window().maximize();
    }
    @And("Close browser")
    public void close_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @And("User logout")
    public void user_logout() throws InterruptedException {
        driver.get("https://dev.pwh.org/Sitefinity/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='T44556677002_ctl00_ctl00_ProfileImageHeader']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='T44556677002_ctl00_ctl00_logoutButton']")).click();
        Thread.sleep(5000);
//        driver.get("https://dev.pwh.org/Sitefinity/");
    }
    @When("Ambassador user validation")
    public void ambassador_user_validation() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(7000);
        driver.findElement(By.id("BestWorkMenuLabel")).click();
        Assert.assertTrue(driver.findElement(By.id("BestWorkMenuLabel")).isDisplayed());
        Thread.sleep(5000);
    }
    @When("Choose terminate")
    public void choose_terminate() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='ApprovalStatus_3']")).click();
        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
    }

    @Given("Open submit project page")
    public void open_submit_project_page() throws InterruptedException {
        driver.get("https://dev.projectswithaheart.pconnect.biz/home");
        Thread.sleep(7000);
        driver.findElement(By.xpath("//*[contains(text(),'SUBMIT A PROJECT')]")).click();
    }
    @When("Submit project page should be open")
    public void submit_project_page_should_be_open() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'PROJECT REQUEST FORM')]")).isDisplayed());
    }
    @And("Confirm and permission")
    public void confirm_and_permission() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='checkconfirmation']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='onbehalf']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='sec-onbehalf']/div[1]/span/span[1]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Agam.Taufiq@contracted.sampoerna.com");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
        Thread.sleep(1500);

    }
    @And("Project title")
    public void project_title() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(1800);
        driver.findElement(By.xpath("//input[@name='projecttitle']")).sendKeys("Automation Submit title12,.,");
    }
    @And("Project motivation and description")
    public void project_motivation_and_description() throws InterruptedException {
        for (int i = 0; i < 33; i++) {
            driver.findElement(By.xpath("//textarea[@name='projectmotivation']")).sendKeys("Test Project motivation");
        }
        Thread.sleep(500);
        for (int j = 0; j < 50; j++) {
            driver.findElement(By.xpath("//textarea[@name='projectdesc']")).sendKeys("Test Project description");
        }
        Thread.sleep(500);
    }
    @And("Project location")
    public void project_location() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150)", "");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='select2-selCountry-container']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("indonesia");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
    }
    @And("Estimate date")
    public void estimate_date() throws InterruptedException {
        driver.findElement(By.id("datepicker")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("datepicker")).sendKeys("0404");

    }
    @And("Project category and project type")
    public void project_category_and_project_type() throws InterruptedException {
        driver.findElement(By.id("cbProjectCategory")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//option[@value='care-support']")).click();
        Thread.sleep(500);
        driver.findElement(By.id("cbProjectType")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//option[@value='global']")).click();
        Thread.sleep(1000);
    }
    @And("Number and hour volunteers")
    public void number_and_hour_volunteers() throws InterruptedException{
        driver.findElement(By.xpath("//input[@ng-model='SubmitProjectForm.NumberOfVolunteers']")).sendKeys("4");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@ng-model='SubmitProjectForm.HoursRequiredByVolunteers']")).sendKeys("4");
        Thread.sleep(500);
    }
    @And("Beneficiaries and budget")
    public void beneficiaries_and_budget() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='numberbeneficiaries']")).sendKeys("4");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='estimatedbudget']")).sendKeys("4000");
        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }
    @And("Project documents upload")
    public void project_documents_upload() throws InterruptedException {
        driver.findElement(By.id("profilefiles")).sendKeys("C:\\Users\\tagam\\Desktop\\istockphoto-1.jpg");
        Thread.sleep(500);
        driver.findElement(By.id("imagefiles")).sendKeys("C:\\Users\\tagam\\Desktop\\istockphoto-2.jpg");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }
    @And("Sign")
    public void sign() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='SubmitProjectForm']/h4")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//canvas[@id='signature-canvas']")).click();
        WebElement signCanvas = driver.findElement(By.id("signature-canvas"));
        actions.dragAndDropBy(signCanvas, 5,20).build().perform();
        actions.dragAndDropBy(signCanvas, 20,10).build().perform();
        Thread.sleep(1500);

    }
    @Then("Submit")
    public void submit() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//button[@class='second-btn-full mx-1 ng-scope']"))).perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='second-btn-full mx-1 ng-scope']")).click();
        Thread.sleep(15000);
//        driver.switchTo().alert().accept();
//        Thread.sleep(7000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Thank you for submitting a project')]")).isDisplayed());
        Thread.sleep(1000);
        driver.quit();
    }

    @Given("Open approval page")
    public void open_approval_page() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div[1]/div/div[2]/h4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(5000);
        driver.findElement(By.id("ApprovalMenuLabel")).click();
        Thread.sleep(7000);
    }
    @When("Submit approval page should be open")
    public void submit_approval_page_should_be_open() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='approval-section']/div/h3")).isDisplayed());
        Thread.sleep(5000);
    }
    @And("Click approve project button")
    public void click_approve_project_button() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='approval-section']/div/div[2]/div/div[2]/button")).click();
        Thread.sleep(500);
    }
    @And("Project request form should be open")
    public void project_request_form_should_be_open() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'PROJECT REQUEST FORM')]")).isDisplayed());
    }
    @And("Comment approve project")
    public void comment_approve_project() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id='reviewproject']/div/div/div[2]/div/div/form/div[11]/label"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//textarea[@id='commentArea']")).sendKeys("approval comment");
    }
    @And("Comment revise project")
    public void comment_revise_project() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id='reviewproject']/div/div/div[2]/div/div/form/div[11]/label"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//textarea[@id='commentArea']")).sendKeys("revise comment");
    }
    @And("Click approve button on project request form")
    public void click_approve_button_on_project_request_form() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='reviewproject']/div/div/div[2]/div/div/form/div[15]/button[2]")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(7000);
    }
    @And("Click revise button on project request form")
    public void click_revise_button_on_project_request_form() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='reviewproject']/div/div/div[2]/div/div/form/div[15]/button[1]")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(7000);
    }
    @Then("Appoval is success")
    public void appoval_is_success() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div[1]/div/div[2]/h4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        driver.findElement(By.id("ProjectMenuLabel")).click();
        Thread.sleep(5000);
        WebElement elementApproval = driver.findElement(By.xpath("//*[@id='myproject-section']/div/div[1]/div/div[2]/button"));
        elementApproval.getText();
        Assert.assertEquals("COMPLETE PROJECT", elementApproval.getText());
    }

    @Given("Open my project page")
    public void open_my_project_page() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div[1]/div/div[2]/h4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(5000);
        driver.findElement(By.id("ProjectMenuLabel")).click();
        Thread.sleep(5000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    @When("My project page should be open")
    public void my_project_page_should_be_open() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='myproject-section']/div/h3")).isDisplayed());
    }
    @And("Open project to finalize")
    public void open_project_to_finalize() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id='myproject-section']/div/div[1]/div/div[2]/button")).click();
        Thread.sleep(3000);
    }
    @And("Fill final story")
    public void fill_final_story() throws InterruptedException {
        for (int k = 0; k < 33; k++) {
            driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[5]/div/textarea")).sendKeys("automate final story Share your experience of completing the project: How it helped, the process, emotion");
        }
        Thread.sleep(3000);
    }
    @And("Fill expense detail")
    public void fill_expense_detail() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[6]/div[1]/label"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='expenseReportList']/div[1]/table/tbody/tr[1]/td[1]/input")).sendKeys("22012023");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='expenseReportList']/div[1]/table/tbody/tr[1]/td[2]/textarea")).sendKeys("automate description");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='expenseReportList']/div[1]/table/tbody/tr[1]/td[3]/input")).sendKeys("40000000");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='expenseReportList']/div[1]/table/tbody/tr[1]/td[4]/input")).sendKeys("4000");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='expenseReportList']/div[1]/table/tbody/tr[1]/td[5]/textarea")).sendKeys("5505");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='expenseReportList']/div[1]/table/tbody/tr[1]/td[6]/textarea")).sendKeys("remark automate test");
        Thread.sleep(1000);
        WebElement reimbustElement = driver.findElement(By.xpath("//*[@id='expenseReportList']/div[2]/div[2]/button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", reimbustElement);
        Thread.sleep(3000);
    }
    @And("Fill reimbursement form")
    public void fill_reimbursement_form() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/section[3]/div[1]/div[2]/div/div[19]/div/div/div[2]/div/div/form/div[8]/div[1]/div[1]/input")).sendKeys("QA automate");
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[1]/section[3]/div[1]/div[2]/div/div[19]/div/div/div[2]/div/div/form/div[8]/div[1]/div[2]/input")).sendKeys("Bank Visa");
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[1]/section[3]/div[1]/div[2]/div/div[19]/div/div/div[2]/div/div/form/div[8]/div[2]/div[1]/textarea")).sendKeys("Automate adress");
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[1]/section[3]/div[1]/div[2]/div/div[19]/div/div/div[2]/div/div/form/div[8]/div[2]/div[2]/input[1]")).sendKeys("IBAN Code");
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[1]/section[3]/div[1]/div[2]/div/div[19]/div/div/div[2]/div/div/form/div[8]/div[2]/div[2]/input[2]")).sendKeys("SWIFT Code");
        Thread.sleep(500);
    }
    @And("Upload image")
    public void upload_image() throws InterruptedException {
        driver.findElement(By.id("imagefiles")).sendKeys("C:\\Users\\tagam\\Desktop\\istockphoto-1.jpg");
        Thread.sleep(500);
        driver.findElement(By.id("FileReimbursement")).sendKeys("C:\\Users\\tagam\\Desktop\\evidenceAutomate.pdf");
        Thread.sleep(500);
    }
    @Then("Digital sign")
    public void digital_sign() throws InterruptedException {
        WebElement submitElement = driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[10]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", submitElement);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        driver.findElement(By.id("signature-canvas")).click();
        WebElement signCanvas = driver.findElement(By.id("signature-canvas"));
        actions.dragAndDropBy(signCanvas, 0,25).build().perform();
        actions.dragAndDropBy(signCanvas, 20,0).build().perform();
        Thread.sleep(1500);
    }
    @Then("Click submit button to finalize")
    public void click_submit_button_to_finalize() throws InterruptedException {
        WebElement submitElement = driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[10]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", submitElement);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        driver.findElement(By.id("signature-canvas")).click();
        WebElement signCanvas = driver.findElement(By.id("signature-canvas"));
        actions.dragAndDropBy(signCanvas, 0,25).build().perform();
        actions.dragAndDropBy(signCanvas, 20,0).build().perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[15]/button")).click();
        Thread.sleep(7000);
        driver.switchTo().alert().accept();
        Thread.sleep(10000);
    }

    @And("Revise closure project")
    public void revise_closure_project() throws InterruptedException {
        WebElement closureScrollElement = driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[12]/h4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", closureScrollElement);
        Thread.sleep(1000);
        driver.findElement(By.id("commentArea")).sendKeys("revise closure comment");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[18]/button[1]")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
    }
    @And("Closure project")
    public void closure_project() throws InterruptedException {
        WebElement closureScrollElement = driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[12]/h4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", closureScrollElement);
        Thread.sleep(1000);
        driver.findElement(By.id("commentArea")).sendKeys("revise closure comment");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[18]/button[2]")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
    }
//    @And("Closure project")
//    public void closure_page_proses() throws InterruptedException {
//
//        WebElement closureScrollElement = driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[12]/h4"));
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", closureScrollElement);
//        Thread.sleep(1000);
//        driver.findElement(By.id("commentArea")).sendKeys("automation closure comment");
//        Thread.sleep(500);
//        driver.findElement(By.xpath("//*[@id='ClosureProjectForm']/div[18]/button[2]")).click();
//        Thread.sleep(5000);
//        driver.switchTo().alert().accept();
//        Thread.sleep(5000);
//    }


}
