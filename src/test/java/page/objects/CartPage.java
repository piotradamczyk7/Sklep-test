package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class CartPage extends BasePage {

    @FindBy(xpath = "//td[@class=\"product-name\"]/a")
    private WebElement productName;

    @FindBy(xpath = "//a[@data-increment=\"down\"]")
    private WebElement productDecrement;

    @FindBy(name = "update_cart")
    private WebElement updateCartButton;

    @FindBy(xpath = "//p[@class=\"cart-empty\"]")
    private WebElement emptyCartMessage;

    @FindBy(xpath = "//div[@class=\"wc-proceed-to-checkout\"]/a")
    private WebElement proceedButton;

    @Step("Assert that shirt is added")
    public CartPage assertThatShirtIsAdded() {
        WaitForElement.waitUntilElementIsVisible(productName);
        log().info("Checking if shirt is added");
        assertThat(productName).isDisplayed().hasText("Amari Shirt");
        return this;
    }

    @Step("Click on Decrement Button of Amari Shirt")
    public CartPage clickOnDecrementAmariShirt() throws InterruptedException {
        WaitForElement.waitUntilElementIsClickable(productDecrement);
        sleep();
        Thread.sleep(3000);
        productDecrement.click();
        sleep();
        log().info("Clicked on Decrement Button of Amari Shirt");
        return this;
    }

    @Step("Click on Update Cart Button")
    public CartPage clickOnUpdateCartButton() {
        WaitForElement.waitUntilElementIsClickable(updateCartButton);
        sleep();
        updateCartButton.click();
        sleep();
        log().info("Clicked on Update Cart Button");
        return this;
    }

    @Step("Assert that cart is empty")
    public CartPage assertThatCartIsEmpty() {
        WaitForElement.waitUntilElementIsVisible(emptyCartMessage);
        log().info("Checking if cart is empty");
        assertThat(emptyCartMessage).isDisplayed().hasText("Your cart is currently empty.");
        return this;
    }
    @Step("Click on Proceed Button")
    public CheckoutPage clickOnProceedButton() {
        WaitForElement.waitUntilElementIsClickable(proceedButton);
        sleep();
        proceedButton.click();
        sleep();
        log().info("Clicked on Proceed Button");
        return new CheckoutPage();
    }
}