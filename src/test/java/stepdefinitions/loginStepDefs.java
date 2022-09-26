package stepdefinitions;


import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.PasswordPage;
import pageObjects.ProfileInfoPage;


public class loginStepDefs {

    //WebDriver driver;

    TestContext testContext;
   //WebDriverManager webDriverManager;
   // PageObjectManager pageObjectManager;
    //ConfigFileReader configFileReader;
    LoginPage loginPage;
    ProfileInfoPage profileInfoPage;


    PasswordPage passwordPage;
    @Given("^User wants to login to the application$")
    public void user_wants_to_login_to_the_application(TestContext context) {
        testContext=context;
        // webDriverManager=new WebDriverManager();
         //driver = webDriverManager.getDriver();
        // pageObjectManager =new PageObjectManager(driver);
         //loginPage=pageObjectManager.getLoginPage();
        // loginPage.getEmailScreen();
        loginPage=testContext.getPageObjectManager().getLoginPage();

    }

    @Given("^User is in the pop3 email screen$")
    public void user_is_in_the_pop_email_screen() {
      // driver.switchTo().frame(0);
     //  driver.switchTo().frame(0);
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);
        testContext.getWebDriverManager().getDriver().switchTo().frame(0);


    }

    @When("^User enters a valid \"([^\"]*)\" existing address$")
    public void userEntersAValidExistingAddress(String email) throws Throwable {
      //  loginPage=pageObjectManager.getLoginPage();
      //  loginPage.enter_email(email);
        loginPage.enter_email(email);
    }

    @When("^User clicks on CONTINUE button$")
    public void user_clicks_on_CONTINUE_button() {
      //  driver.findElement(By.id("formSubmitButton")).click();
        testContext.getWebDriverManager().getDriver().findElement(By.id("formSubmitButton")).click();

    }

    @Then("^User lands on PASSWORD screen$")
    public void user_lands_on_PASSWORD_screen() {
       // passwordPage=pageObjectManager.getPasswordPage();
        passwordPage=testContext.getPageObjectManager().getPasswordPage();
        Assert.assertTrue(passwordPage.passwordField.isDisplayed());

    }

    @When("^User enters a valid \"([^\"]*)\" non-existing address$")
    public void userEntersAValidNonExistingAddress(String email) throws Throwable {
        loginPage.enter_email(email);
    }

    @Then("^User lands on Profile Info screen$")
    public void user_lands_on_Profile_Info_screen() {
        Assert.assertEquals("Profile Info", profileInfoPage.profilePage.getText());
        System.out.println(profileInfoPage.profilePage.getText());
    }

    @When("^User enters an invalid \"([^\"]*)\" address$")
    public void userEntersAnInvalidAddress(String email) throws Throwable {
        loginPage.enter_email(email);
    }
    @And("^User clicks welcomepage$")
    public void userClicksWelcomepage() {

        loginPage.welcomeText.click();
    }


    @Then("^User sees \"([^\"]*)\" message$")
    public void userSeesMessage(String errorMsg) throws Throwable {
        Assert.assertEquals(errorMsg,loginPage.errorMsg.getText() );
        System.out.println("Validation Message Returned: Invalid Email Address");
    }
}
