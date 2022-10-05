package stepdefinitions;

import cucumber.TestContext;
import helpers.FlexShopperCodeRetrieve;
import helpers.Mail;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ForgotPasswordPage;
import pageObjects.LoginPage;
import pageObjects.PasswordPage;


public class forgotPasswordStepDefs {


    TestContext testContext;
    PasswordPage passwordPage;
    LoginPage loginPage;
    ForgotPasswordPage forgotPasswordPage;
    FlexShopperCodeRetrieve checkMail;

    public forgotPasswordStepDefs(TestContext context) {


        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        passwordPage = testContext.getPageObjectManager().getPasswordPage();
        forgotPasswordPage = testContext.getPageObjectManager().getForgotPasswordPage();


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
    public void userShouldBeAbleToSeeTextOfRadiobuttonForTextMessage(String textMsg) {
        Assert.assertEquals(textMsg, forgotPasswordPage.txtMsg.getText());
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
            WebDriverWait wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(),30);
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
    @And("code is sent using check email to insert code text box")
    public void codeIsSentUsingCheckEmailToInsertCodeTextBox() {
       // checkMail= new CheckMail();
        Mail mail =new Mail();
      String passode1=mail.downloadEmails("imap", "imap.gmail.com", "993", "nann40547@gmail.com", "fplkkybdavflgxxy");
        //String passcode=checkMail.check("imap.gmail.com", "imap", "nann40547@gmail.com", "fyicwklawfmmekap");
        System.out.println("Passcode is: "+passode1);
        WebElement securityBox=testContext.getWebDriverManager().getDriver().findElement(By.id("code-input"));
        WebDriverWait wait =new WebDriverWait(testContext.getWebDriverManager().getDriver(), 50);
        wait.until(ExpectedConditions.visibilityOf(securityBox));
        securityBox.sendKeys(passode1);

    }

    @Then("user should see we sent you code message")
    public void userShouldSeeWeSentYouCodeMessage() {
    }

    @And("user should get code")
    public void userShouldGetCode() {
    }


    @Then("user should see {string} text")
    public void userShouldSeeText(String text) {

    }

    @And("user should see {string} text and {string} email")
    public void userShouldSeeTextAndEmail(String text, String emailText) {
    }

    @And("user clicks No Code received? button")
    public void userClicksNoCodeReceivedButton() {
    }

    @And("user should see reset password screen")
    public void userShouldSeeResetPasswordScreen() {
    }

    @And("user clicks submit button")
    public void userClicksSubmitButton() {
    }

    @And("user enter reset {string} password")
    public void userEnterResetPassword(String arg0) {
    }

    @And("user  clicks save changes")
    public void userClicksSaveChanges() {
    }

    @And("user lands on app")
    public void userLandsOnApp() {
    }

    @And("user enters new {string}password")
    public void userEntersNewPassword(String arg0) {
    }

    @And("user should see dashboard page")
    public void userShouldSeeDashboardPage() {
    }

    @And("user enter reset password")
    public void userEnterResetPassword() {
    }

    @And("user enters old  password")
    public void userEntersOldPassword() {
    }

    @And("user should see error message")
    public void userShouldSeeErrorMessage() {
    }


}