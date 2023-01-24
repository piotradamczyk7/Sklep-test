package tests;

import data.provider.SearchingTestData;
import io.qameta.allure.*;
import page.objects.*;
import org.testng.annotations.Test;
import utils.testng.listeners.RetryAnalyzer;

public class SearchingTests extends TestBase {

    @Issue("DEFECT-4")
    @TmsLink("ID-4")
    @Severity(SeverityLevel.CRITICAL)
    @Test(retryAnalyzer = RetryAnalyzer.class, dataProviderClass = SearchingTestData.class, dataProvider = "remoteDataProvider")
    @Description("The goal of this test is to assert that searching works fine")
    public void checkingIfSearchingReturnsValidData(String query) {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .typeIntoSearchingField(query)
                .clickOnSearchingButton()
                .assertThatSearchingResultIsVisible(query);
    }

    @Issue("DEFECT-5")
    @TmsLink("ID-5")
    @Severity(SeverityLevel.CRITICAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to assert that URL of searching is correct")
    public void checkingIfSearchingReturnsCorrectUrl() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .typeIntoSearchingField("little")
                .clickOnSearchingButton()
                .assertThatThisIsSearchingPage();
    }
}