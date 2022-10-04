package stepdefinitions;

import cucumber.TestContext;
import helpers.CheckMail;
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
        CheckMail checkMail = new CheckMail();
        String passcode= CheckMail.check("imap.gmail.com", "imap", "nann40547@gmail.com", "fyicwklawfmmekap");
        System.out.println("PassCode is "+passcode);
        WebElement securityBox=testContext.getWebDriverManager().getDriver().findElement(By.id("code-input"));
        WebDriverWait wait =new WebDriverWait(testContext.getWebDriverManager().getDriver(), 50);
        wait.until(ExpectedConditions.visibilityOf(securityBox));
        securityBox.sendKeys(passcode);



    }

    @Then("user should see we sent you code message")
    public void userShouldSeeWeSentYouCodeMessage() {
    }

    @And("user should get code")
    public void userShouldGetCode() {
    }

   // nann40547@gmail.com", "elwtswjneifjlzor

    //fyicwklawfmmekap


}