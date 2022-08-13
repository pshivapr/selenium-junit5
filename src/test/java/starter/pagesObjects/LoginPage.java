package starter.pagesObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage {

    @FindBy(xpath="//span[text()='Username']//../input")
    private WebElementFacade userInput;

    @FindBy(xpath="//span[text()='Password']//../input")
    private WebElementFacade passwordInput;

    @FindBy(xpath="//button[@form='login']")
    private WebElementFacade loginButton;

    @FindBy(xpath="//span[text()='Hello, John']")
    private WebElementFacade userMenu;

    @FindBy(xpath="//a[text()='Log out']")
    private WebElementFacade logoutButton;

    @Step("Enter username {0}")
    public void enterUsername(String username) {
        userInput.sendKeys(username);
    }

    @Step("Enter password {0}")
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Click logout button")
    public void clickLogoutButton() {
        logoutButton.click();
    }

    @Step("Click user menu")
    public void clickUserMenu() {
        userMenu.click();
    }

    @Step("Login with credentials")
    public void login(String username, String password) {
        clickLoginMenuButton();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

}
