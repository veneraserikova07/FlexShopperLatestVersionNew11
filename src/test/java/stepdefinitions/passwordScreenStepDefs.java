package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class passwordScreenStepDefs {
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





}
