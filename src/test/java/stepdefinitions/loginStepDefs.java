package stepdefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class loginStepDefs {

    private static WebDriver driver;
    @Given("^User wants to login to the application$")
    public void user_wants_to_login_to_the_application() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/veneraserikova/WorkSpace/FlexShopperFramework/src/test/java/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://fmweb.staging.flexint.net/?do=pp3");
        driver.manage().window().setSize(new Dimension(1536, 920));

    }

    @Given("^User is in the pop3 email screen$")
    public void user_is_in_the_pop_email_screen() {
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
    }

    @When("^User enters a valid email address$")
    public void user_enters_a_valid_email_address() {
       WebElement element =driver.findElement(By.id("email-input"));
       element.clear();
       element.sendKeys("startdrift@gmail.com");
    }

    @When("^User clicks on CONTINUE button$")
    public void user_clicks_on_CONTINUE_button() {
        driver.findElement(By.id("formSubmitButton")).click();
    }

    @Then("^User lands on PASSWORD screen$")
    public void user_lands_on_PASSWORD_screen() {
        WebElement password = driver.findElement(By.id("password-input"));
        Assert.assertTrue(password.isDisplayed());
        System.out.println("Password is displayed");
        driver.quit();
    }

    @When("^User enters a valid email address doesn't exists in email$")
    public void user_enters_a_valid_email_address_doesn_t_exists_in_email() {
        WebElement element =driver.findElement(By.id("email-input"));
        element.clear();
        element.sendKeys("drift@gmail.com");

    }

    @Then("^User lands on Profile Info screen$")
    public void user_lands_on_Profile_Info_screen() {
        WebElement profileInfo = driver.findElement(By.xpath("//h2[text()='Profile Info']"));
        Assert.assertEquals("Profile Info", profileInfo.getText());
        System.out.println("profileInfo.getText() = " + profileInfo.getText());
        driver.quit();
    }

    @When("^User enters an invalid email address$")
    public void user_enters_an_invalid_email_address() {
        WebElement element =driver.findElement(By.id("email-input"));
        element.clear();
        element.sendKeys("drift@gmail@com");

    }
    @And("^User clicks welcomepage$")
    public void userClicksWelcomepage() {
        driver.findElement(By.xpath("//h3[text()='Welcome to']")).click();
    }

    @Then("^User sees an error message$")
    public void user_sees_an_error_message() {
        WebElement errorMessage=driver.findElement(By.xpath("//span[@label='Invalid email address']"));
        Assert.assertEquals("Invalid email address", errorMessage.getText());
        System.out.println(errorMessage.getText());
        driver.quit();
    }

    @When("^User enters an invalid email address without email$")
    public void user_enters_an_invalid_email_address_without_email() {
        WebElement element =driver.findElement(By.id("email-input"));
        element.clear();
        element.sendKeys("");
    }

    @Then("^User sees errorr message$")
    public void user_sees_errorr_message() {

        WebElement errorMessage=driver.findElement(By.xpath("//span[@label='Invalid email address']"));
        Assert.assertEquals("Invalid email address", errorMessage.getText());
        System.out.println(errorMessage.getText());
        System.out.println("Validation Message Returned: Invalid Email Address");
        driver.quit();
    }



}
