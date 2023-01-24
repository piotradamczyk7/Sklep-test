package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class ShoppingPage extends BasePage {

    @FindBy(xpath = "//a[@data-product_id=\"62\"]/span")
    private WebElement addToCardAmariShirtButton;

    @Step("Click on Add to Cart Button of Amari Shirt")
    public ShoppingPage clickOnAddToCardAmariShirt() {
        WaitForElement.waitUntilElementIsClickable(addToCardAmariShirtButton);
        sleep();
        addToCardAmariShirtButton.click();
        sleep();
        log().info("Clicked on Add to Cart Button of Amari Shirt");
        return this;
    }
}