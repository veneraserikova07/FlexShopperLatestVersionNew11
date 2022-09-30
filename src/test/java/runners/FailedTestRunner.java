package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "stepdefinitions",
        features = "target/rerun.txt"
//                   ,  tags = "@ui"
)
public class FailedTestRunner {
}
