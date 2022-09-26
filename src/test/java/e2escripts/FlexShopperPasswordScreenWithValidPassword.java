package e2escripts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FlexShopperPasswordScreenWithValidPassword {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/veneraserikova/WorkSpace/FlexShopperFramework/src/test/java/resources/drivers/chromedriver");

        /**
         * BACKGROUND:
         * GIVEN User wants to log in to the application
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
         * AND the user enters the email address of an existing customers
         * AND User clicks on CONTINUE
         * AND User lands on Password screen
         */
        driver.findElement(By.id("email-input")).sendKeys("startdrift@gmail.com");
        driver.findElement(By.id("formSubmitButton")).click();

        /**
         * Test Scenario: Existing Customer lands in Home Page as loged in user
         * WHEN user enters a valid password
         */
        driver.findElement(By.id("password-input")).sendKeys("test123");

        /**
         * AND user clicks on CONTINUE
         */
        driver.findElement(By.id("formSubmitButton")).click();

        /**
         * THEN user lands in the Home page as loged in user
         */
        WebElement myAccountHeader = driver.findElement(By.className("userName"));
        Assert.assertEquals("Stanislav Kuleshov", myAccountHeader.getText());
        System.out.println("myAccountHeader.getText() = " + myAccountHeader.getText());
        driver.quit();
    }
}