package runner;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import stepdef.Hooks;

@CucumberOptions(
        features = "src/test/resources/features/kukutv",
        glue = "stepdef",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class KukuTv extends TestNgRunner {
        @AfterSuite
        public void printTestSummary() {
                Hooks.printSummary();
        }
}
