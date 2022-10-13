package stepdefinitions;

import cucumber.TestContext;
import helpers.CheckMail;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
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

    @Given("user lands ann app")
    public void user_lands_ann_app() {
        loginPage.getEmailScreen();
    }

    @Given("user on pop up screen")
    public void user_on_pop_up_screen() {
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
    }

    @Given("user enter existing email {string} address")
    public void user_enter_existing_email_address(String email) {
        loginPage.enter_email(email);
    }

    @Given("user clicks continue button")
    public void user_clicks_continue_button() {
        loginPage.continueBtn.click();
    }

    @Given("user lands on password screen")
    public void user_lands_on_password_screen() {
        System.out.println(passwordPage.passwordField.isDisplayed());
    }

    @Given("user clicks forgot password link")
    public void user_clicks_forgot_password_link() {
        passwordPage.ForgotPassword.click();
    }

    @Then("user should see firstText {string}")
    public void user_should_see_first_text(String firstText) {
        Assert.assertEquals(firstText, forgotPasswordPage.resetPasswordText.getText());
    }

    @Then("user should see secondText {string}")
    public void user_should_see_second_text(String secondText) {
        Assert.assertEquals(secondText, forgotPasswordPage.chooseOptionsText.getText());
    }

    @And("user should be able to see text {string} of radiobutton for email")
    public void userShouldBeAbleToSeeTextOfRadiobuttonForEmail(String emailText) {
        Assert.assertEquals(emailText, forgotPasswordPage.email.getText());
    }

    @And("user should be able to see text {string} of radiobutton for text message")
    public void userShouldBeAbleToSeeTextOfRadiobuttonForTextMessage(String SmsText) {
        WebDriverWait wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(forgotPasswordPage.txtMsg));
        Assert.assertEquals(SmsText, forgotPasswordPage.txtMsg.getText());
    }

    @Then("user should be able to click on continue button")
    public void user_should_be_able_to_click_on_continue_button() {
        forgotPasswordPage.continueBtn.click();
    }

    @And("user clicks Return to Password Sign In link")

    public void userClicksReturnToPasswordSignInLink() {
        forgotPasswordPage.returnToPwd.click();
    }

    @Then("user should see psdScreen")
    public void userShouldSeePsdScreen() {
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

    @Then("code is sent using check email to insert code text box")
    public void codeIsSentUsingCheckEmailToInsertCodeTextBox() throws InterruptedException {
        CheckMail checkGmail = new CheckMail();
        Thread.sleep(5000);
        String PassCode = CheckMail.check("imap.gmail.com", "imap", "nann40547@gmail.com", "rhtytnjlxhtxbehk");
        WebDriverWait wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
        Thread.sleep(10000);
        System.out.println("PassCode is " + PassCode);
        codeScreenPage.securityBox.sendKeys(PassCode);
        Thread.sleep(3000);
    }

    @And("user clicks on No Code received? button")
    public void userClicksOnNoCodeReceivedButton() {
        codeScreenPage.NoCodeReceivedBtn.click();
    }

    @Then("user should see forgot password screen with email text password screen")
    public void userShouldSeeForgotPasswordScreenWithEmailTextPasswordScreen() {
      Assert.assertTrue(forgotPasswordPage.email.isDisplayed());
    }

    @And("user clicks submit button")
    public void userClicksSubmitButton() {
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
        Thread.sleep(3000);
        testContext.getWebDriverManager().getDriver().findElement(By.xpath("//a[@class='logOut']")).click();
        Thread.sleep(3000);
        testContext.getWebDriverManager().getDriver().manage().deleteAllCookies();
        testContext.getWebDriverManager().getDriver().navigate().refresh();
    }
    @And("user clicks sign in module")
    public void userClicksSignInModule() {
    }
    @And("user lands on app")
    public void userLandsOnApp() {
    }

    @And("user on pop up Screen")
    public void userOnPopUpScreen() {
    }

    @And("user enter existing email {string}")
    public void userEnterExistingEmail(String arg0) {
    }

    @And("user clicks continue btn")
    public void userClicksContinueBtn() {
    }

    @And("user lands on password scrn")
    public void userLandsOnPasswordScrn() {
    }

    @And("user enter new {string} password")
    public void userEnterNewPassword(String arg0) {
    }

    @And("user click sign in button")
    public void userClickSignInButton() {
    }

    @Then("user lands in the Home page as logged in user {string}")
    public void userLandsInTheHomePageAsLoggedInUser(String arg0) {
    }
    @And("user enters old {string} password")
    public void userEntersOldPassword(String arg0) {
    }

    @Then("user should see error message")
    public void userShouldSeeErrorMessage() {
    }

    @Then("user should see {string} text")
    public void userShouldSeeText(String firstText) {
        Assert.assertEquals(firstText, codeScreenPage.firstText.getText());
    }

    @And("user should {string} email")
    public void userShouldEmail(String email) {
        Assert.assertEquals(email, codeScreenPage.emailText.getText());
    }

    @And("user clicks No Code received? button")
    public void userClicksNoCodeReceivedButton() {
        codeScreenPage.NoCodeReceivedBtn.click();
    }

    @And("user sees forgot password screen")
    public void userSeesForgotPasswordScreen() {
        System.out.println(forgotPasswordPage.email.getText());
    }

}