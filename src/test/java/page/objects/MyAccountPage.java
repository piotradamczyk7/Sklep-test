package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class MyAccountPage extends BasePage {

    @FindBy(className = "woocommerce-MyAccount-content")
    private WebElement correctPasswordMessage;

    @Step("Assert that Correct Login Message is displayed")
    public MyAccountPage assertThatCorrectLoginMessageIsVisible(String username) {
        log().info("Checking if Correct Login Message is displayed");
        WaitForElement.waitUntilElementIsVisible(correctPasswordMessage);
        assertThat(correctPasswordMessage).isDisplayed().hasText("Hello "+username+" (not "+username+"? Log out)\nFrom your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.");
        return this;
    }
}