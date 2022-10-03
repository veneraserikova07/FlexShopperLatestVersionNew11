package runners;
import com.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import managers.FileReaderManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepdefinitions",
        monochrome = true,

      plugin = {"pretty","json:target/cucumber-reports/Cucumber.json","junit:target/cucumber-reports/Cucumber.xml",
               "html:target/cucumber.html", "rerun:target/rerun.txt"},

    //   plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },





        tags = "@wip"

)

public class TestRunner {
  /* @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", 	"macOS 12.5.1" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.141.59");
        Reporter.setSystemInfo("Maven", "3.8.1");
        Reporter.setSystemInfo("Java Version", "1.8.0_341");
    }*/
}
