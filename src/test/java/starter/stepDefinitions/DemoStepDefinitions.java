package starter.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import starter.pageActions.LoginPageActions;
import starter.pageActions.NavigateActions;
import starter.pagesObjects.HomePage;
import starter.pagesObjects.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class DemoStepDefinitions {

    /**
     * Navigation actions. This is a UIInteraction class, so it will be instantiated automatically by Serenity.
     */
    NavigateActions navigate;

    /**
     * Define the webdriver instance to be used for these tests, for running headless add options = "headless" to the annotation
     */
    @Managed(driver = "chrome")
    WebDriver driver;

    /**
     * Page Objects and Actions related to pages. This is a UIInteraction class, so it will be instantiated automatically by Serenity.
     */
    HomePage homePage;
    LoginPage loginPage;
    LoginPageActions loginPageActions;

    @Given("^User is on homepage$")
    public void user_is_on_homepage() {
        navigate.toTheHomePage(driver);
    }

    @Given("^choose travellers as below$")
    public void choose_travellers(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        homePage.chooseTravellers(data.get("Adults"), data.get("Children"));
    }

    @Given("^assert travellers to be (.*)$")
    public void assert_travellers(String travellers) {
        String actualString = homePage.getTravellersCount();
        assertTrue(actualString.contains(travellers + " travellers"));
    }

    @Given("^clicks select destination with default values$")
    public void click_select_destination_with_defaults() {
        homePage.selectDestinationWithDefaults();
    }

    @Given("^book planet by name (.*)$")
    public void book_planet_by_name(String title) {
        homePage.bookDestination(title);
    }

    @Given("^assert page with valid dates$")
    public void assert_page_with_dates() {
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        c.add(Calendar.DATE, 1);
        Date dateTomorrow = c.getTime();
        SimpleDateFormat date1 = new SimpleDateFormat("MMM dd", Locale.ENGLISH);
        String nextDay = date1.format(dateTomorrow);

        c.add(Calendar.DATE, 6);
        Date dateWeek = c.getTime();
        SimpleDateFormat date2 = new SimpleDateFormat("dd");
        String weekDay = date2.format(dateWeek);

        Assertions.assertEquals(homePage.getOrderSummaryDates(), (nextDay+" – "+weekDay));
    }

    @When("^login with below credentials$")
    public void login(DataTable credentials) {
        Map<String, String> data = credentials.asMap(String.class, String.class);
        loginPage.login(data.get("username"), data.get("password"));
    }

    @Then("^validate user logged in to be (.*)$")
    public void validate_user_logged_in(String username) {
        loginPageActions.validate_login(username);
    }

    @And("^when logout$")
    public void when_logout() {
        loginPage.clickUserMenu();
        loginPage.clickLogoutButton();
    }

    @Then("^validate user is logged out$")
    public void validate_user_is_logged_out() {
        loginPageActions.validate_logout();
    }
}
