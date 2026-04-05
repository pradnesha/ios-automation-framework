package runner;


import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import stepdef.Hooks;

import static stepdef.Hooks.sendSlackSummary;

@CucumberOptions(
        features = "src/test/resources/features/kukufm",
        glue = "stepdef",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class KukuFm extends TestNgRunner {

        @AfterSuite
        public void printTestSummary() {
                Hooks.printSummary();
                sendSlackSummary();
        }
}
