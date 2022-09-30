package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepdefinitions",
        monochrome = true,

      plugin = {"pretty","json:target/cucumber-reports/Cucumber.json","junit:target/cucumber-reports/Cucumber.xml",
               "html:target/cucumber.html", "rerun:target/rerun.txt"},

      // plugin = { "html:target/cucumber.html", "com.cucumber.listener.ExtentCucumberFormatter" },





        tags = "@login"

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
