package tests;

import io.qameta.allure.*;
import page.objects.*;
import org.testng.annotations.Test;
import utils.testng.listeners.RetryAnalyzer;

public class LoginTests extends TestBase {

    @Issue("DEFECT-6")
    @TmsLink("ID-6")
    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to assert that after using an incorrect password the appropriate message will appear")
    public void checkingIfIncorrectPasswordReturnsCorrectMessage() {

       TopMenuPage topMenuPage = new TopMenuPage();
       topMenuPage
                .clickOnAccountButton()
                .typeIntoUsernameField("skleptestwp@wp.pl") //correct username
                .typeIntoPasswordField("incorrect")
                .clickOnLoginButton()
                .assertThatIncorrectPasswordWarningMessageIsVisible("skleptestwp@wp.pl");
    }

    @Issue("DEFECT-7")
    @TmsLink("ID-7")
    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to assert that after using an incorrect username the appropriate message will appear")
    public void checkingIfIncorrectUsernameReturnsCorrectMessage() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .clickOnAccountButton()
                .typeIntoUsernameField("incorrect@wp.pl")
                .typeIntoPasswordField("incorrect")
                .clickOnLoginButton()
                .assertThatIncorrectUsernameWarningMessageIsVisible();
    }

    @Issue("DEFECT-8")
    @TmsLink("ID-8")
    @Severity(SeverityLevel.BLOCKER)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to assert that login works")
    public void checkingIfLoginWorks() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .clickOnAccountButton()
                .typeIntoUsernameField("skleptestwp@wp.pl")
                .typeIntoPasswordField("Skoda+skleptest+2004")
                .clickOnLoginButton();
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage
                .assertThatCorrectLoginMessageIsVisible("skleptestwp");
    }

    @Issue("DEFECT-9")
    @TmsLink("ID-9")
    @Severity(SeverityLevel.CRITICAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to assert that password reset works")
    public void checkingIfPasswordResetWorks() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .clickOnAccountButton()
                .clickOnPasswordReset()
                .typeIntoEmailField("pradamczyk@wp.pl")
                .clickOnPasswordResetButton()
                .assertThatCorrectResetMessageIsVisible();
    }
}