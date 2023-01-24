package tests;

import io.qameta.allure.*;
import page.objects.*;
import org.testng.annotations.Test;
import utils.testng.listeners.RetryAnalyzer;

public class EmailAddressInMenuTests extends TestBase {

    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to assert that email address in Top Menu Bar is correct")
    public void checkingIfEmailAddressIsCorrect() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .assertThatEmailAdressIsCorrect();
    }
}