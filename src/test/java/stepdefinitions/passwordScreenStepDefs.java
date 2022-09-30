package stepdefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PasswordPage;

public class passwordScreenStepDefs {


    TestContext testContext;
    PasswordPage passwordPage;
    LoginPage loginPage;
    HomePage homePage;

    public  passwordScreenStepDefs(TestContext context) {


        testContext=context;
        passwordPage=testContext.getPageObjectManager().getPasswordPage();
    }



    @Given("User login to the application")
    public void userLoginToTheApplication() {
        loginPage=testContext.getPageObjectManager().getLoginPage();
        loginPage.getEmailScreen();
    }
    @And("user in the pop screen")
    public void userInThePopScreen() {
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
    }

    @And("User enters a {string} existing address")
    public void userEntersAExistingAddress(String email) {
        loginPage.enter_email(email);
    }

    @And("User clicks Continue button")
    public void userClicksContinueButton() {
        testContext.getWebDriverManager().getDriver().findElement(By.id("formSubmitButton")).click();
    }

    @And("User lands on Password screen")
    public void userLandsOnPasswordScreen() {
        System.out.println(passwordPage.passwordField.isDisplayed());
    }

    @When("User enters an valid {string} password")
    public void user_enters_an_valid_password(String password) {

        passwordPage.passwordField.sendKeys(password);

    }


    @When("^User clicks on Sign In button$")
    public void user_clicks_on_Sign_In_button() {
        passwordPage.signInBtn.click();
    }

    @Then("^User lands in the Home page as logged in user \"([^\"]*)\"$")
    public void user_lands_in_the_Home_page_as_logged_in_user(String user) {
        homePage=testContext.getPageObjectManager().getHomePage();
        Assert.assertEquals(user, homePage.accHeader.getText());
        System.out.println(homePage.accHeader.getText());
    }

    @When("^User enters an invalid \"([^\"]*)\"$")
    public void user_enters_an_invalid(String password) {
        passwordPage.enter_password(password);
    }

    @Then("^User should see \"([^\"]*)\" message$")
    public void user_should_see_message(String errorMsg) {
        /**
         * Capturing alert message
         */

       try {
            WebDriverWait wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = testContext.getWebDriverManager().getDriver().switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            Assert.assertEquals(errorMsg, alert.getText());
        } catch (Exception e) {
            System.out.println("No such Alert exception");
        }

    }

    @When("^User enters an invalid \"([^\"]*)\" empty field$")
    public void user_enters_an_invalid_empty_field(String password) {
        passwordPage.enter_password(password);
    }

    @Then("^User should be able  see \"([^\"]*)\" message$")
    public void user_should_be_able_see_message(String errorMsg) {



       Assert.assertEquals("Required", passwordPage.errMsgReq.getText());
    }



}