package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.TestContext;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Hooks {

    TestContext testContext;
    AppiumDriver<MobileElement> driver;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void beforeScenario(/*Scenario scenario*/) throws MalformedURLException {DesiredCapabilities capabilities=new DesiredCapabilities();
      /*  capabilities.setCapability("Version", 12);
        capabilities.setCapability("deviceName","Pixel 4 New");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
        capabilities.setCapability("chromeExec", "./src/test/java/mobile_drivers/chromedriver 2");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(url, capabilities);*/
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                //This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);

                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");

                //Copy taken screenshot from source location to destination location
                Files.copy(sourcePath, destinationPath);

                //This attach the specified screenshot to the test
                Reporter.addScreenCaptureFromPath(destinationPath.toString());
            } catch (IOException e) {
            }
        }
    }


    @After(order = 0)
    public void AfterSteps() {
        testContext.getWebDriverManager().getDriver().quit();
    }

}