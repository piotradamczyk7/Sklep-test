package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class TopMenuPage extends BasePage {

    @FindBy(className = "top-email")
    private WebElement emailAddress;

    @FindBy(className = "site-title")
    private WebElement homePageLink;

    @FindBy(id = "search-top-bar-submit")
    private WebElement searchingButton;

    @FindBy(id = "search-field-top-bar")
    private WebElement searchingField;

    @FindBy(className = "top-account")
    private WebElement accountButton;

    @FindBy(className = "dropdown-toggle")
    private WebElement categories;

    @FindBy(id = "menu-item-125")
    private WebElement shirtsMenu;

    @FindBy(xpath = "//li[@class=\"top-cart\"]/a")
    private WebElement cartButton;

    @Step("Assert that Email Address is correct")
    public TopMenuPage assertThatEmailAdressIsCorrect() {
        log().info("Checking if Email Address is skleptestarmy@gmail.com");
        WaitForElement.waitUntilElementIsVisible(emailAddress);
        assertThat(emailAddress).isDisplayed().hasText("skleptestarmy@gmail.com");
        return this;
    }

    @Step("Assert that Home Page Link is displayed")
    public TopMenuPage assertThatHomePageLinkIsVisible() {
        log().info("Checking if Home Page Link is displayed");
        WaitForElement.waitUntilElementIsVisible(homePageLink);
        assertThat(homePageLink).isDisplayed();
        return this;
    }

    @Step("Assert that a Home Page is displayed")
    public TopMenuPage assertThatThisIsHomePage() {
        log().info("Checking if it's home page");
        assertEquals(DriverManager.getCurrentUrl(), "http://skleptest.pl/");
        return this;
    }

    @Step("Click on Searching Button")
    public SearchingPage clickOnSearchingButton() {
        WaitForElement.waitUntilElementIsClickable(searchingButton);
        sleep();
        searchingButton.click();
        sleep();
        log().info("Clicked on Searching Button");
        return new SearchingPage();
    }

    @Step("Type into Searching Field {queryToSearch}")
    public TopMenuPage typeIntoSearchingField(String queryToSearch) {
        WaitForElement.waitUntilElementIsVisible(searchingField);
        searchingField.clear();
        sleep();
        searchingField.sendKeys(queryToSearch);
        sleep();
        log().info("Typed into Searching Field: {}", queryToSearch);
        return this;
    }

    @Step("Click on Account Button")
    public LoginPage clickOnAccountButton() {
        WaitForElement.waitUntilElementIsClickable(accountButton);
        sleep();
        accountButton.click();
        sleep();
        log().info("Clicked on Account Button");
        return new LoginPage();
    }

    @Step("Mouse hover on Categories Menu")
    public TopMenuPage mouseHoverCategoriesMenu() {
        WaitForElement.waitUntilElementIsVisible(categories);
        Actions actions = new Actions(DriverManager.getWebDriver());
        actions.moveToElement(categories).build().perform();
        sleep();
        log().info("Mouse hovered on Categories Menu");
        return this;
    }

    @Step("Click on Shirts on Categories Menu")
    public TopMenuPage clickOnShirtsMenu() {
        WaitForElement.waitUntilElementIsClickable(shirtsMenu);
        shirtsMenu.click();
        sleep();
        log().info("Clicked on Shirts on Categories Menu");
        return this;
    }

    @Step("Assert that shirts' window is displayed")
    public ShoppingPage assertThatThisIsShirtsPage() {
        log().info("Checking if shirts' window is displayed");
        assertEquals(DriverManager.getCurrentUrl(), "http://skleptest.pl/product-category/shirts/");
        return new ShoppingPage();
    }

    @Step("Click on Card Button")
    public CartPage clickOnCardButton() {
        WaitForElement.waitUntilElementIsClickable(cartButton);
        cartButton.click();
        sleep();
        log().info("Clicked on Card Button");
        return new CartPage();
    }
}