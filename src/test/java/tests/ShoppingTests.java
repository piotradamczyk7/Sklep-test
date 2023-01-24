package tests;

import io.qameta.allure.*;
import page.objects.*;
import org.testng.annotations.Test;
import utils.testng.listeners.RetryAnalyzer;

public class ShoppingTests extends TestBase {

    @Issue("DEFECT-11")
    @TmsLink("ID-11")
    @Severity(SeverityLevel.CRITICAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to assert that delete product by quantity button works fine")
    public void checkingIfDeleteProductByQuantityButtonWorksCorrect() throws InterruptedException {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .mouseHoverCategoriesMenu()
                .clickOnShirtsMenu();
        ShoppingPage shoppingPage = new ShoppingPage();
        shoppingPage
                .clickOnAddToCardAmariShirt();
        topMenuPage
                .clickOnCardButton()
                .assertThatShirtIsAdded()
                .clickOnDecrementAmariShirt()
                .clickOnUpdateCartButton()
                .assertThatCartIsEmpty();
    }

    @Issue("DEFECT-12")
    @TmsLink("ID-12")
    @Severity(SeverityLevel.BLOCKER)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to assert that without entered address you can't proceed")
    public void checkingIfWithoutAddressYouCantProceed() throws InterruptedException {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .clickOnAccountButton()
                .typeIntoUsernameField("skleptestwp@wp.pl")
                .typeIntoPasswordField("Skoda+skleptest+2004")
                .clickOnLoginButton();
        topMenuPage
                .mouseHoverCategoriesMenu()
                .clickOnShirtsMenu();
        ShoppingPage shoppingPage = new ShoppingPage();
        shoppingPage
                .clickOnAddToCardAmariShirt();
        topMenuPage
                .clickOnCardButton()
                .clickOnProceedButton()
                .typeIntoAddressField("")
                .clickOnPlaceOrderButton()
                .assertThatErrorMessageIsDisplayed();
        topMenuPage
                .clickOnCardButton()
                .clickOnDecrementAmariShirt()
                .clickOnUpdateCartButton();
    }

    @Issue("DEFECT-13")
    @TmsLink("ID-13")
    @Severity(SeverityLevel.BLOCKER)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to assert that shopping works fine")
    public void checkingIfShoppingWorks() throws InterruptedException {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .clickOnAccountButton()
                .typeIntoUsernameField("skleptestwp@wp.pl")
                .typeIntoPasswordField("Skoda+skleptest+2004")
                .clickOnLoginButton();
        topMenuPage
                .mouseHoverCategoriesMenu()
                .clickOnShirtsMenu();
        ShoppingPage shoppingPage = new ShoppingPage();
        shoppingPage
                .clickOnAddToCardAmariShirt();
        topMenuPage
                .clickOnCardButton()
                .clickOnProceedButton()
                .typeIntoAddressField("Urocza 20")
                .clickOnPlaceOrderButton()
                .assertThatSuccessMessageIsDisplayed();
    }
}