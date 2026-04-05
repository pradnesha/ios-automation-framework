package runner;

import config.ApplicationParams;
import config.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class TestNgRunner extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    @Parameters({"platformName", "devicesName", "udid", "iOSVersion"})
    public void setupClass(String platformName, String devicesName, String udid, String iOSVersion) throws Exception {

        System.out.println("===== FROM TESTNG XML =====");
        System.out.println("Platform: " + platformName);
        System.out.println("Device: " + devicesName);
        System.out.println("Version: " + iOSVersion);
        System.out.println("udid: " + udid);
        System.out.println("===========================");

        ApplicationParams params = new ApplicationParams();
        params.setPlatformName(platformName);
        params.setDeviceName(devicesName);
        params.setiOSVersion(iOSVersion);
        params.setUdid(udid);

    }


}
