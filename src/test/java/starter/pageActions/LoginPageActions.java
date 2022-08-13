package starter.pageActions;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoginPageActions extends UIInteractions {

    @Step("validate user logged in to be {0}$")
    public void validate_login(String username) {

        assertTrue($("//span[text()='"+username+"']").isDisplayed());
    }

    @Step("validate user logged out")
    public void validate_logout() {

        assertTrue($("//button[contains(@class,'NavButton__nav-button')]").isDisplayed());
    }

}
