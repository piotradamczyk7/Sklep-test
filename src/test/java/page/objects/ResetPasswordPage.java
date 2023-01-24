package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class ResetPasswordPage extends BasePage {

    @FindBy(className = "woocommerce-message")
    private WebElement resetMessage;

    @FindBy(id = "user_login")
    private WebElement emailField;

    @FindBy(css = "input[value=\"Reset password\"]")
    private WebElement resetPasswordButton;

    @Step("Type into Email Field {email}")
    public ResetPasswordPage typeIntoEmailField(String email) {
        WaitForElement.waitUntilElementIsVisible(emailField);
        emailField.clear();
        emailField.sendKeys(email);
        sleep();
        log().info("Typed into Email Field: {}", email);
        return this;
    }

    @Step("Click on Password Reset Button")
    public ResetPasswordPage clickOnPasswordResetButton() {
        WaitForElement.waitUntilElementIsClickable(resetPasswordButton);
        sleep();
        resetPasswordButton.click();
        sleep();
        log().info("Clicked on Reset Password Button");
        return this;
    }

    @Step("Assert that Password Reset Message is displayed")
    public ResetPasswordPage assertThatCorrectResetMessageIsVisible() {
        log().info("Checking if correct Password Reset Message is displayed");
        WaitForElement.waitUntilElementIsVisible(resetMessage);
        assertThat(resetMessage).isDisplayed().hasText("Password reset email has been sent.");
        return this;
    }
}