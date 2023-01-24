package tests;

import io.qameta.allure.*;
import page.objects.*;
import org.testng.annotations.Test;
import utils.testng.listeners.RetryAnalyzer;

public class MenuTests extends TestBase {

    @Issue("DEFECT-10")
    @TmsLink("ID-10")
    @Severity(SeverityLevel.CRITICAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to assert that Menu Categories works")
    public void checkingIfCategoriesMenuWorks() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .mouseHoverCategoriesMenu()
                .clickOnShirtsMenu()
                .assertThatThisIsShirtsPage();
    }
}