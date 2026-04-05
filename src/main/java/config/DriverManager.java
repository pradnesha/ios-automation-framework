package config;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import utils.TestUtils;

import java.net.URL;

public class DriverManager {

//    public static IOSDriver driver;


    // ✅ ThreadLocal instead of static driver
    private static ThreadLocal<IOSDriver> driver = new ThreadLocal<>();

    public void initializeDriver() {

        ApplicationParams params = new ApplicationParams();
        XCUITestOptions options = new XCUITestOptions();

        options.setPlatformName(params.getPlatformName());
        options.setDeviceName(params.getDeviceName());
        options.setPlatformVersion(params.getiOSVersion());
        options.setUdid(params.getUdid());
        options.setAutomationName("XCUITest");

        options.setBundleId(TestUtils.PLATFORM);

        try {
            driver.set(new IOSDriver(new URL("http://127.0.0.1:4723"), options));
        } catch (Exception e) {
            throw new RuntimeException("Driver initialization failed", e);
        }


//
//        XCUITestOptions options = new XCUITestOptions();
//
//        options.setPlatformName("iOS");
////        options.setDeviceName("iPhone 16e");   // match your simulator
//        String deviceName = System.getProperty("deviceName");
//        options.setDeviceName(deviceName);
//        options.setDeviceName("iPhone 16e");
//        options.setPlatformVersion("26.3");   // from your screenshot
//        options.setAutomationName("XCUITest");
//
//        options.setBundleId("com.apple.Preferences");
//
//        try {
//            driver.set(new IOSDriver(new URL("http://127.0.0.1:4723"), options));
//        } catch (Exception e) {
//            throw new RuntimeException("Driver initialization failed", e);
//        }
    }

    public static IOSDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();   // VERY IMPORTANT 🔥
        }
    }
}

