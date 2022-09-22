package e2escripts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class wegeg {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/veneraserikova/WorkSpace/FlexShopperFramework/src/test/java/resources/drivers/chromedriver");


        /**
         *GIVEN The User wants to log in as an Existing User
         **/
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://fmweb.staging.flexint.net/?do=pp3");
        driver.manage().window().setSize(new Dimension(1536, 920));


        /**
         AND User is in the login PP3 screen
         */
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        /**
         WHEN User enters the existing user email
         AND User clicks on CONTINUE
         */
        driver.findElement(By.id("email-input")).sendKeys("startdrift@gmail.com");
        driver.findElement(By.id("formSubmitButton")).click();


        /**
         *
         * THEN User should land in "Password" screen
         *
         */
        WebElement password = driver.findElement(By.id("password-input"));
        Assert.assertTrue(password.isDisplayed());
        System.out.println("Password is displayed");
        password.sendKeys("test123");



    }
}