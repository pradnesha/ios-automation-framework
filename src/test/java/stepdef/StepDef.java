package stepdef;

import Pages.HomePage;
import config.DriverManager;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

public class StepDef {
    HomePage home = new HomePage();

    @Given("user opens app")
    public void user_opens_app()
    {
        home.clickFirstCell();
    }
}
