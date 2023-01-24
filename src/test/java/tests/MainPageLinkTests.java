package tests;

import io.qameta.allure.*;
import page.objects.*;
import org.testng.annotations.Test;
import utils.testng.listeners.RetryAnalyzer;

public class MainPageLinkTests extends TestBase {

    @Issue("DEFECT-2")
    @TmsLink("ID-2")
    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to assert that home page link is visible")
    public void checkingIfHomePageLinkIsVisible() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .assertThatHomePageLinkIsVisible();
    }

    @Issue("DEFECT-3")
    @TmsLink("ID-3")
    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to assert that Home Page Link works properly")
    public void checkingIfHomePageLinkWorks() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .clickOnSearchingButton()
                .clickOnHomeLink()
                .assertThatThisIsHomePage();
    }
}
