package e2escripts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FlexShopperLoginWithInvalidNoEmail {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/veneraserikova/WorkSpace/FlexShopperFramework/src/test/java/resources/drivers/chromedriver");

        /**
         *  BACKGROUND:
         *  GIVEN User wants to log in to the application
         */
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://fmweb.staging.flexint.net/?do=pp3");
        driver.manage().window().setSize(new Dimension(1536, 920));

        /**
         * AND the user is in the pop3 email screen
         */
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);

        /**
         * Test Scenario: : User can not log in without email address
         * WHEN The user enters an invalid email address
         * AND The user clicks on CONTINUE
         */
        driver.findElement(By.id("email-input")).sendKeys("");
        driver.findElement(By.id("formSubmitButton")).click();

        /**
         * THEN the user sees an error message
         */
        WebElement errorMessage=driver.findElement(By.xpath("//span[@label='Invalid email address']"));
        Assert.assertEquals("Invalid email address", errorMessage.getText());
        System.out.println(errorMessage.getText());
        System.out.println("Validation Message Returned: Invalid Email Address");
        driver.quit();
    }
}