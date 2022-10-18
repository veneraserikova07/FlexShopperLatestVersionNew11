package stepdefinitions;

import cucumber.TestContext;
import helpers.CheckMail;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.*;

import java.util.Locale;

public class ForgotPasswordWithOutFullInfo {

    TestContext testContext;
    PasswordPage passwordPage;
    LoginPage loginPage;
    ForgotPasswordPage forgotPasswordPage;
    CheckMail checkMail;
    CodeScreenPage codeScreenPage;
    ResetPasswordPage changePasswordScreen;
    HomePage homePage;

    public ForgotPasswordWithOutFullInfo(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        passwordPage = testContext.getPageObjectManager().getPasswordPage();
        forgotPasswordPage = testContext.getPageObjectManager().getForgotPasswordPage();
        codeScreenPage = testContext.getPageObjectManager().getCodeScreenPage();
        changePasswordScreen = testContext.getPageObjectManager().getChangePasswordScreen();
        homePage = testContext.getPageObjectManager().getHomePage();
    }
    @Given("user without full information forgot the password")
    public void userWithoutFullInformationForgotThePassword() {
        loginPage.getEmailScreen();
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
        loginPage.loginWithNotFullInfo();
        passwordPage.passwordField.isDisplayed();
    }

}
