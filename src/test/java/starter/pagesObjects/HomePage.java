package starter.pagesObjects;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class HomePage extends PageComponent {

    @FindBy(xpath="//ul[contains(@class,'TopBar__navigation')]//button")
    private WebElementFacade loginMenuButton;

    @FindBy(xpath="//button[contains(@class, 'WQCBB Hero__cta-button')]")
    private WebElementFacade selectDestinationButton;

    @FindBy(css=".Gallery__headline-2___3amRj")
    private WebElementFacade galleryHeading;

    @FindBy(xpath="//div[contains(@class,'OrderSummary__row-2')]//div[2]")
    private WebElementFacade dates;

    @Step("Click login menu button")
    public void clickLoginMenuButton() {
        loginMenuButton.click();
    }

    @Step("Click select destination")
    public void clickSelectDestination() {
        selectDestinationButton.click();
    }

    @Step("Select dropdown {string} option {string}")
    public void selectDropdownOption(String dropdown, String option) {
        if (dropdown == "Departing" || dropdown == "Returning") {
            $("//div[@data-react-toolbox='date-picker']//label[text()='"+dropdown+"']/../input").click();
            if (option == "default")
                $("//button[text()='Ok']").click();
        } else {
            $("//input[@role='input' and contains(@value, '"+dropdown+"')]").click();
            $("//li[contains(text(), '"+dropdown+"')]/../li[text()='"+option+"']").click();
        }
    }

    @Step("Get travellers count")
    public String getTravellersCount() {
        return galleryHeading.getText();
    }

    @Step("Get Order Summary Dates")
    public String getOrderSummaryDates() {
        return dates.getText();
    }

    @Step("Get order summary")
    public String getOrderSummary() {
        return $("//div[contains(@class,'OrderSummary__order-summary')]").getText();
    }

    @Step("Book destination {string}")
    public void bookDestination(String title) {
        $("//div[@data-react-toolbox='card']//*[text()='"+title+"']//../../..//button").click();
    }

    @Step("Choose travellers")
    public void chooseTravellers(String noOfAdults, String noOfChildren) {
        selectDropdownOption("Adults", noOfAdults);
        selectDropdownOption("Children", noOfChildren);
    }

    @Step("Assert total travellers")
    public void assertTotalTravellers(String total) {
        assertTrue(galleryHeading.getText().contains(total + " travellers"));
    }

    @Step("Select Destination with Defaults")
    public void selectDestinationWithDefaults() {
        selectDropdownOption("Departing", "default");
        clickSelectDestination();
    }

}
