package e2escripts;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium {

    AppiumDriver<MobileElement> driver;
    @Test
    public void  setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("Version", 12);
        capabilities.setCapability("deviceName","Pixel 4 New");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
        capabilities.setCapability("chromeExec", "/Users/veneraserikova/IdeaProjects/FlexShopperLatestVersionNew11/src/test/java/mobile_drivers/chromedriver 2");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(url, capabilities);
        driver.get("https://fmweb.staging.flexint.net/?do=pp3");
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        WebElement element =driver.findElement(By.id("email-input"));
        element.sendKeys("nann40547@gmail.com");

    }

}
