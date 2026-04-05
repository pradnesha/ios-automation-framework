package stepdef;

import config.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import utils.SlackNotifier;

import java.util.ArrayList;
import java.util.List;



public class Hooks {
    DriverManager driverManager = new DriverManager();

    private static int passedScenarios = 0;
    private static int failedScenarios = 0;

    private static List<String> passedScenarioNames = new ArrayList<>();
    private static List<String> failedScenarioNames = new ArrayList<>();

    @Before
    public void setUp()
    {
        System.out.println("🚀 App Launching...");
        driverManager.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario)
    {
        AppiumDriver driver = DriverManager.getDriver();

        byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);

        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", scenario.getName());
            failedScenarios++;
            failedScenarioNames.add(scenario.getName());
            System.out.println("❌ Scenario Failed: " + scenario.getName());
        } else {
            passedScenarios++;
            passedScenarioNames.add(scenario.getName());
            System.out.println("✅ Scenario Passed: " + scenario.getName());
        }

        System.out.println("🛑 App Closing...");
        DriverManager.quitDriver();
    }

    public static void printSummary() {
        System.out.println("===== Test Execution Summary =====");
        System.out.println("Total Passed Scenarios: " + passedScenarios);
        System.out.println("Total Failed Scenarios: " + failedScenarios);
        System.out.println("==================================");

    }

    public static void sendSlackSummary() {

        int total = passedScenarios + failedScenarios;

        StringBuilder message = new StringBuilder();

        message.append("🚀 iOS Automation Execution\n")
                .append("Total: ").append(total).append("\n")
                .append("Passed: ").append(passedScenarios).append(" ✅\n")
                .append("Failed: ").append(failedScenarios).append(" ❌\n\n");

        if (failedScenarios > 0) {
            message.append("❌ Failed Scenarios:\n");

            for (String name : failedScenarioNames) {
                message.append("- ").append(name).append("\n");
            }
        }
        SlackNotifier.sendMessage(String.valueOf(message));
    }

}
