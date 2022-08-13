package starter.testRunners;

import org.junit.jupiter.api.Assertions;
import starter.pageActions.LoginPageActions;
import starter.pageActions.NavigateActions;
import starter.pagesObjects.HomePage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import starter.pagesObjects.LoginPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@ExtendWith(SerenityJUnit5Extension.class)
class TestimTest {

    /**
     * Define the webdriver instance to be used for these tests, for running headless add options = "headless" to the annotation
     */
    @Managed(driver = "chrome")
    WebDriver driver;

    /**
     * Navigation actions. This is a UIInteraction class, so it will be instantiated automatically by Serenity.
     */
    NavigateActions navigate;

    /**
     * Page Objects and Actions related to pages. This is a UIInteraction class, so it will be instantiated automatically by Serenity.
     */
    HomePage homePage;
    LoginPage loginPage;

    LoginPageActions loginPageActions;

    @Test
    void LoginTest() {
        navigate.toTheHomePage(driver);
        loginPage.login("Test", "Test123");
        loginPageActions.validate_login("Hello, John");
        loginPage.clickUserMenu();
        loginPage.clickLogoutButton();
        loginPageActions.validate_logout();
    }

    @Test
    void CountTravellers() {
        navigate.toTheHomePage(driver);
        loginPage.login("Test", "Test123");
        homePage.chooseTravellers("2", "4");
        Assertions.assertTrue(homePage.getTravellersCount().contains("6 travellers"));
    }

    @Test
    void ValidateDates() {
        navigate.toTheHomePage(driver);
        loginPage.login("Test", "Test123");
        homePage.selectDestinationWithDefaults();
        homePage.bookDestination("Madan");

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
}
