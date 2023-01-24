package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.Locale;

import static generic.assertions.AssertWebElement.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class SearchingPage extends BasePage {

    @FindBy(className = "page-header")
    private WebElement searchingPageHeader;

    @FindBy(className = "site-title")
    private WebElement homePageLink;

    @FindBy(linkText = "Little Black Top")
    private WebElement littleBlackTop;

    @Step("Click on Home Link")
    public TopMenuPage clickOnHomeLink() {
        WaitForElement.waitUntilElementIsClickable(homePageLink);
        sleep();
        homePageLink.click();
        sleep();
        log().info("Clicked on Home Link");
        return new TopMenuPage();
    }

    @Step("Assert that searching result is displayed")
    public SearchingPage assertThatSearchingResultIsVisible(String searchingQuery){
        log().info("Checking if searching result  is displayed");
        WaitForElement.waitUntilElementIsVisible(searchingPageHeader);
        assertThat(searchingPageHeader).isDisplayed().hasText("SEARCH RESULTS FOR: "+searchingQuery.toUpperCase(Locale.ROOT));
        return this;
    }

    @Step("Assert that this is correct searching page")
    public SearchingPage assertThatThisIsSearchingPage() {
        log().info("Checking if it's correct searching page");
        assertEquals(DriverManager.getCurrentUrl(),"http://skleptest.pl/?s=little");
        return this;
    }
}