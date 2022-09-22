package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class passwordScreenStepDefs {
    private static WebDriver driver;

    @Given("^User lands on Password screen$")
    public void user_lands_on_Password_screen() {
        WebElement password = driver.findElement(By.id("password-input"));
        Assert.assertTrue(password.isDisplayed());
        System.out.println("Password is displayed");
    }

    @When("^User enters an valid password$")
    public void user_enters_an_valid_password() {
        WebElement password = driver.findElement(By.id("password-input"));
        password.clear();
        password.sendKeys("test123");
    }

    @When("^User clicks on Sign In button$")
    public void user_clicks_on_Sign_In_button() {
        driver.findElement(By.id("formSubmitButton")).click();
    }

    @Then("^User lands in the Home page as logged in user$")
    public void user_lands_in_the_Home_page_as_logged_in_user() {
        WebElement myAccountHeader = driver.findElement(By.className("userName"));

        Assert.assertEquals("Stanislav Kuleshov", myAccountHeader.getText());
        System.out.println("myAccountHeader.getText() = " + myAccountHeader.getText());
        driver.quit();
    }

    @When("^User enters an invalid password$")
    public void user_enters_an_invalid_password() {
        driver.findElement(By.id("password-input")).sendKeys("test");

    }

    @Then("^User should sees an error message$")
    public void user_should_sees_an_error_message() {
        WebElement errorMessage = driver.findElement(By.xpath("//span[text()='Invalid email or password: please check your details and try again']"));
        System.out.println(errorMessage.getText());
        driver.quit();
    }

    @When("^User doesn't enter password$")
    public void user_doesn_t_enter_password() {
        driver.findElement(By.id("password-input")).sendKeys("");
    }

    @Then("^user sees an error message$")
    public void user_sees_an_error_message() {
        WebElement errorMessage = driver.findElement(By.xpath("//span[@label='Required']"));
        Assert.assertEquals("Required", errorMessage.getText());

        System.out.println(errorMessage.getText());
        driver.quit();
    }



}
