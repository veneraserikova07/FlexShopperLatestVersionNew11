package stepdefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageObjects.LoginPage;
import pageObjects.PasswordPage;
import pageObjects.ProfileInfoPage;

public class loginStepDefs {



    TestContext testContext;
    LoginPage loginPage;
    ProfileInfoPage profileInfoPage;
    PasswordPage passwordPage;


    public  loginStepDefs(TestContext context) {


        testContext=context;
        loginPage=testContext.getPageObjectManager().getLoginPage();
    }

    @Given("^User wants to login to the application$")
    public void user_wants_to_login_to_the_application() {
        loginPage.getEmailScreen();
    }

    @Given("^User is in the pop3 email screen$")
    public void user_is_in_the_pop_email_screen() {
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
    }

    @When("^User enters a valid \"([^\"]*)\" existing address$")
    public void userEntersAValidExistingAddress(String email) throws Throwable {
        loginPage.enter_email(email);
    }

    @When("^User clicks on CONTINUE button$")
    public void user_clicks_on_CONTINUE_button() {
        testContext.getWebDriverManager().getDriver().findElement(By.id("formSubmitButton")).click();
    }

    @Then("^User lands on PASSWORD screen$")
    public void user_lands_on_PASSWORD_screen() {
        passwordPage=testContext.getPageObjectManager().getPasswordPage();
        Assert.assertTrue(passwordPage.passwordField.isDisplayed());
    }

    @When("^User enters a valid \"([^\"]*)\" non-existing address$")
    public void userEntersAValidNonExistingAddress(String email) {
        loginPage.enter_email(email);
    }

    @Then("^User lands on Profile Info screen$")
    public void user_lands_on_Profile_Info_screen() {
        profileInfoPage=testContext.getPageObjectManager().getProfileInfoPage();
        Assert.assertEquals("Profile Info", profileInfoPage.profilePage.getText());
        System.out.println(profileInfoPage.profilePage.getText());
    }

    @When("^User enters an invalid \"([^\"]*)\" address$")
    public void userEntersAnInvalidAddress(String email) throws Throwable {
        loginPage.enter_email(email);
    }

    @And("User clicks on Welcome to")
    public void userClicksOnWelcomeTo() {
        loginPage.welcomeText.click();
    }

    @Then("^User sees \"([^\"]*)\" message$")
    public void userSeesMessage(String errorMsg) throws Throwable {
        Assert.assertEquals(errorMsg,loginPage.errorMsg.getText() );
        System.out.println("Validation Message Returned: Invalid Email Address");
    }

}