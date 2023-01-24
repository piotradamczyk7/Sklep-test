package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(className = "woocommerce-error")
    private WebElement incorrectPasswordMessage;

    @FindBy(className = "woocommerce-message")
    private WebElement message;

    @FindBy(css = "a[href=\"http://skleptest.pl/my-account/lost-password/\"]")
    private WebElement passwordReset;

    @Step("Type into User Name Field {username}")
    public LoginPage typeIntoUsernameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        sleep();
        log().info("Typed into User Name Field: {}", username);
        return this;
    }

    @Step("Type into Password Field {password}")
    public LoginPage typeIntoPasswordField(String password) {
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
        sleep();
        log().info("Typed into Password Field: {}", password);
        return this;
    }

    @Step("Click on Login Button")
    public LoginPage clickOnLoginButton() {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        sleep();
        loginButton.click();
        sleep();
        log().info("Clicked on Login Button");
        return this;
    }

    @Step("Assert that Warning Message is displayed")
    public LoginPage assertThatIncorrectPasswordWarningMessageIsVisible(String username) {
        log().info("Checking if incorrect password Warning Message is displayed");
        WaitForElement.waitUntilElementIsVisible(incorrectPasswordMessage);
        assertThat(incorrectPasswordMessage).isDisplayed().hasText("ERROR: The password you entered for the username "+username+" is incorrect. Lost your password?");
        return this;
    }

    @Step("Assert that Warning Message is displayed")
    public LoginPage assertThatIncorrectUsernameWarningMessageIsVisible() {
        log().info("Checking if incorrect username Warning Message is displayed");
        WaitForElement.waitUntilElementIsVisible(incorrectPasswordMessage);
        assertThat(incorrectPasswordMessage).isDisplayed().hasText("Error: A user could not be found with this email address.");
        return this;
    }

    @Step("Click on Passsword Reset")
    public ResetPasswordPage clickOnPasswordReset() {
        WaitForElement.waitUntilElementIsClickable(passwordReset);
        sleep();
        passwordReset.click();
        sleep();
        log().info("Clicked on Password Reset");
        return new ResetPasswordPage();
    }
}