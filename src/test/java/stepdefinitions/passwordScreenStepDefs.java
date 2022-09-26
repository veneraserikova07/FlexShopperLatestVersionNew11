package stepdefinitions;





import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.PasswordPge;

public class passwordScreenStepDefs {
    WebDriver driver;
    PasswordPge passwordPage;
    HomePage homePage;
    PageObjectManager pageObjectManager;



    @Given("User landed in Password screen")
    public void user_landed_in_password_screen() {
        passwordPage=pageObjectManager.getPasswordPage();
        // passwordPage=testContext.getPageObjectManager().getPasswordPage();
        Assert.assertTrue(passwordPage.passwordField.isDisplayed());
    }


    @When("^User enters an valid \"([^\"]*)\"$")
    public void user_enters_an_valid(String password) {
        pageObjectManager =new PageObjectManager(driver);
        passwordPage=pageObjectManager.getPasswordPage();
        passwordPage.enter_password(password);
    }

    @When("^User clicks on Sign In button$")
    public void user_clicks_on_Sign_In_button() {
        passwordPage.signInBtn.click();

    }

    @Then("^User lands in the Home page as logged in user \"([^\"]*)\"$")
    public void user_lands_in_the_Home_page_as_logged_in_user(String user) {
       homePage=pageObjectManager.getHomePage();
        Assert.assertEquals(user, homePage.accHeader.getText());
        System.out.println(homePage.accHeader.getText());
    }

    @When("^User enters an invalid \"([^\"]*)\"$")
    public void user_enters_an_invalid(String password) {
        passwordPage.enter_password(password);
    }

    @Then("^User should see \"([^\"]*)\" message$")
    public void user_should_see_message(String errorMsg) {
       Assert.assertEquals(errorMsg,passwordPage.errorMsg.getText());
        System.out.println(passwordPage.errorMsg.getText());
    }



    @When("^User enters an invalid \"([^\"]*)\" empty field$")
    public void user_enters_an_invalid_empty_field(String password) {
        passwordPage.enter_password(password);
    }

    @Then("^User should be able  see \"([^\"]*)\" message$")
    public void user_should_be_able_see_message(String errorMsg) {
        Assert.assertEquals(errorMsg, passwordPage.errMsgReq.getText());
        System.out.println(passwordPage.errMsgReq.getText());
    }

}
