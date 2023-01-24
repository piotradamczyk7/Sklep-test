package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class CheckoutPage extends BasePage {

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    @FindBy(className = "woocommerce-error")
    private WebElement errorMessage;

    @FindBy(id = "billing_address_1")
    private WebElement addressField;

    @FindBy(xpath = "//div[@class=\"woocommerce-order\"]/p[1]")
    private WebElement successMessage;

    @Step("Click on Place Order Button")
    public CheckoutPage clickOnPlaceOrderButton() {
        WaitForElement.waitUntilElementIsClickable(placeOrderButton);
        sleep();
        placeOrderButton.click();
        sleep();
        log().info("Clicked on Place Order Button");
        return this;
    }

    @Step("Assert that Error Message is displayed")
    public CheckoutPage assertThatErrorMessageIsDisplayed() {
        log().info("Checking if Error Message is displayed");
        WaitForElement.waitUntilElementIsVisible(errorMessage);
        assertThat(errorMessage).isDisplayed().hasText("Billing Street address is a required field.");
        return this;
    }

    @Step("Type into Address Field {username}")
    public CheckoutPage typeIntoAddressField(String username) {
        WaitForElement.waitUntilElementIsVisible(addressField);
        addressField.clear();
        addressField.sendKeys(username);
        sleep();
        log().info("Typed into Address Field: {}", username);
        return this;
    }

    @Step("Assert that Success Message is displayed")
    public CheckoutPage assertThatSuccessMessageIsDisplayed() {
        log().info("Checking if Success Message is displayed");
        WaitForElement.waitUntilElementIsVisible(successMessage);
        assertThat(successMessage).isDisplayed().hasText("Thank you. Your order has been received.");
        return this;
    }
}