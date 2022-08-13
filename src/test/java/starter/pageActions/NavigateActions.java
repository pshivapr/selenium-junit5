package starter.pageActions;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

/**
 * UIInteractionSteps let us define action classes which regroup related actions.
 * The @Step annotation is used to indicate that this action will appear as a step in the reports.
 */
public class NavigateActions extends UIInteractions {

    @Step("Navigate to the home page")
    public void toTheHomePage(WebDriver driver) {
        openUrl("https://demo.testim.io/prod/?v=2");
        driver.manage().window().maximize();
    }
}
