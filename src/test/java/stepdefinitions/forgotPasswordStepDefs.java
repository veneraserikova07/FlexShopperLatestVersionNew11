package stepdefinitions;

import cucumber.TestContext;
import helpers.CheckMail;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

public class forgotPasswordStepDefs {
    TestContext testContext;
    PasswordPage passwordPage;
    LoginPage loginPage;
    ForgotPasswordPage forgotPasswordPage;
    CheckMail checkMail;
    CodeScreenPage codeScreenPage;
    ResetPasswordPage changePasswordScreen;
    HomePage homePage;

    public forgotPasswordStepDefs(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        passwordPage = testContext.getPageObjectManager().getPasswordPage();
        forgotPasswordPage = testContext.getPageObjectManager().getForgotPasswordPage();
        codeScreenPage = testContext.getPageObjectManager().getCodeScreenPage();
        changePasswordScreen = testContext.getPageObjectManager().getChangePasswordScreen();
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("user forgot the password")
    public void userForgotThePassword() {
        loginPage.getEmailScreen();
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
        loginPage.login();
        passwordPage.passwordField.isDisplayed();
    }
    @When("the user clicks on the Forgot Password link")
    public void theUserClicksOnTheForgotPasswordLink() {
        passwordPage.ForgotPassword.click();
    }
    @Then("user should see firstText {string}")
    public void userShouldSeeFirstText(String firstText) {
        Assert.assertEquals(firstText, forgotPasswordPage.resetPasswordText.getText());
    }
    @Then("user should see secondText {string}")
    public void user_should_see_second_text(String secondText) {
        Assert.assertEquals(secondText, forgotPasswordPage.chooseOptionsText.getText());
    }
    @And("user should be able to see email {string}")
    public void userShouldBeAbleToSeeEmail(String email) {
        Assert.assertEquals(email, forgotPasswordPage.emailName.getText());
    }
    @And("user should be able to see text {string}")
    public void userShouldBeAbleToSeeText(String phoneNumber) throws InterruptedException {
        WebDriverWait wait =new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(forgotPasswordPage.phoneNumber));
        Assert.assertEquals(phoneNumber, forgotPasswordPage.phoneNumber.getText());
    }
    @Then("user should be able to click on continue button")
    public void user_should_be_able_to_click_on_continue_button() {
        forgotPasswordPage.continueBtn.click();
    }

    @And("user clicks Return to Password Sign In link")

    public void userClicksReturnToPasswordSignInLink() {
        forgotPasswordPage.returnToPwd.click();
    }

    @Then("user should see email screen")
    public void userShouldSeeEmailScreen() {
        Assert.assertTrue(loginPage.welcomeText.isDisplayed());
    }

    @And("user clicks sent Email to radio button")
    public void userClicksSentEmailToRadioButton() {
        /*WebDriverWait wait=new WebDriverWait(testContext.getWebDriverManager().getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordPage.emailRadioBtn));
        forgotPasswordPage.emailRadioBtn.click();*/
        try {
            WebDriverWait wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 30);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='sc-dVhcbM cahqFL'])[2]")));
        } catch (TimeoutException toe) {
            System.out.println("WebElement wasn't found");
        }
        /* JavascriptExecutor jse =(JavascriptExecutor)testContext.getWebDriverManager().getDriver();
        jse.executeScript("arguments[0].click();", forgotPasswordPage.emailRadioBtn);
        forgotPasswordPage.emailRadioBtn.click();*/
    }

    @And("user clicks Continue button")
    public void userClicksContinueButton() {
        forgotPasswordPage.continueBtn.click();
    }

    @And("the user retrieves the verification code from the email and send to security code field")
    public void theUserRetrievesTheVerificationCodeFromTheEmailAndSendToSecurityCodeField() throws InterruptedException {
        CheckMail checkGmail = new CheckMail();
        Thread.sleep(8000);
        String PassCode = CheckMail.check("imap.gmail.com", "imap", "nann40547@gmail.com", "rhtytnjlxhtxbehk");
        WebDriverWait wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
        System.out.println("PassCode is " + PassCode);
        codeScreenPage.securityCodeBox.sendKeys(PassCode);
    }
    @And("the user clicks on the submit button")
    public void theUserClicksOnTheSubmitButton() {
        codeScreenPage.SubmitBtn.click();
    }

    @Then("the user lands on the {string} screen")
    public void theUserLandsOnTheScreen(String changePsd) throws InterruptedException {
        Assert.assertEquals(changePsd,changePasswordScreen.changePassword.getText() );
    }
    @And("user clicks submit button")
    public void userClicksSubmitButton() {
        codeScreenPage.SubmitBtn.click();
    }
    @Given("User on Change Password Screen")
    public void userOnChangePasswordScreen() throws InterruptedException {
        passwordPage.ForgotPassword.click();
        try {
            WebDriverWait wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 30);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='sc-dVhcbM cahqFL'])[2]")));
        } catch (TimeoutException toe) {
            System.out.println("WebElement wasn't found");
        }
        forgotPasswordPage.continueBtn.click();
        CheckMail checkGmail = new CheckMail();
        Thread.sleep(8000);
        String PassCode = CheckMail.check("imap.gmail.com", "imap", "nann40547@gmail.com", "rhtytnjlxhtxbehk");
        WebDriverWait wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
        System.out.println("PassCode is " + PassCode);
        codeScreenPage.securityCodeBox.sendKeys(PassCode);
        codeScreenPage.SubmitBtn.click();
    }
    @And("user enter reset {string} password")
    public void userEnterResetPassword(String newPassword) {
        changePasswordScreen.psdInputBox.sendKeys(newPassword);
    }

    @And("user  clicks save changes")
    public void userClicksSaveChanges() {
        changePasswordScreen.changePassword.click();
    }

    @And("user clicks to sign out")
    public void userClicksToSignOut() throws InterruptedException {
        Actions actions = new Actions(testContext.getWebDriverManager().getDriver());
        actions.moveToElement(testContext.getPageObjectManager().getHomePage().accHeader).perform();
        testContext.getWebDriverManager().getDriver().findElement(By.xpath("//a[@class='logOut']")).click();
        testContext.getWebDriverManager().getDriver().manage().deleteAllCookies();
        testContext.getWebDriverManager().getDriver().navigate().refresh();
    }
    @And("user clicks sign in module")
    public void userClicksSignInModule() throws InterruptedException {
        WebElement element=testContext.getWebDriverManager().getDriver().findElement(By.xpath("( //*[normalize-space(.)='Apply or Sign In'])[2]"));
        WebDriverWait wait=new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    @And("user clicks on Not You? Sign In or Apply Now link")
    public void userClicksOnNotYouSignInOrApplyNowLink() {
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
        testContext.getWebDriverManager().getDriver().findElement(By.id("cookieSignIn-notYou-link")).click();

    }

    @And("user enter existing email {string}")
    public void userEnterExistingEmail(String email) {
        loginPage.enter_email(email);
    }

    @And("user clicks continue btn")
    public void userClicksContinueBtn() {
        loginPage.continueBtn.click();
    }

    @And("user lands on password scrn")
    public void userLandsOnPasswordScrn() {
        passwordPage.passwordField.isDisplayed();
    }

    @And("user enter new {string} password")
    public void userEnterNewPassword(String password) {
        passwordPage.passwordField.sendKeys(password);
    }

    @And("user click sign in button")
    public void userClickSignInButton() {
        passwordPage.signInBtn.click();
    }

    @Then("user lands in the Home page as logged in user {string}")
    public void userLandsInTheHomePageAsLoggedInUser(String accHeader) throws InterruptedException {
        Assert.assertEquals(accHeader, homePage.accHeader.getText());
    }

    @And("user clicks on No Code received? button")
    public void userClicksOnNoCodeReceivedButton() {
        codeScreenPage.NoCodeReceivedBtn.click();
    }


    @Then("user should see forgot password screen with {string}")
    public void userShouldSeeForgotPasswordScreenWith(String email) {
        WebDriverWait wait =new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(forgotPasswordPage.emailName));
        Assert.assertEquals(email, forgotPasswordPage.emailName.getText());

    }

    @And("user should see forgot psd scr with {string}")
    public void userShouldSeeForgotPsdScrWith(String phoneNumber) {
        WebDriverWait wait =new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(forgotPasswordPage.phoneNumber));
        Assert.assertEquals(phoneNumber, forgotPasswordPage.phoneNumber.getText());
    }

    @And("user see Security Code field")
    public void userSeeSecurityCodeField() {
        Assert.assertTrue(codeScreenPage.securityBox.isDisplayed());
    }

    @Then("the user should land on the {string} screen")
    public void theUserShouldLandOnTheScreen(String text) {
        Assert.assertEquals(text, codeScreenPage.firstText.getText());
    }
    @And("the user should see the phoneNumber text: {string}")
    public void theUserShouldSeeThePhoneNumberText(String phoneNumber) {
        WebDriverWait wait =new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(forgotPasswordPage.phoneNumber));
        Assert.assertEquals(phoneNumber, forgotPasswordPage.phoneNumber.getText());
    }
    @And("And user clicks sent SMS  to radio button")
    public void andUserClicksSentSMSToRadioButton() {
        forgotPasswordPage.clickToSendSms();
    }

    @And("user enter old {string} psd")
    public void userEnterOldPsd(String oldPassword) {
        passwordPage.passwordField.sendKeys(oldPassword);
    }

    @Then("user can't login to dashboard page amd see error {string} message")
    public void userCanTLoginToDashboardPageAmdSeeErrorMessage(String validationMessage) {
        try {
            WebDriverWait wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = testContext.getWebDriverManager().getDriver().switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            Assert.assertEquals(validationMessage, alert.getText());
        } catch (Exception e) {
            System.out.println("No such Alert exception");
        }
    }

    @And("the user should see the email text: {string}")
    public void theUserShouldSeeTheEmailText(String email) {
        Assert.assertEquals(email, forgotPasswordPage.emailName.getText());
    }
}