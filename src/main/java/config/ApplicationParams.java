package config;

public class ApplicationParams {

    private static ThreadLocal<String> platformName = new ThreadLocal<>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<>();
    private static ThreadLocal<String> iOSVersion = new ThreadLocal<>();
    private static ThreadLocal<String> udid = new ThreadLocal<>();

    public void setPlatformName(String value) {
        platformName.set(value);
    }

    public String getPlatformName() {
        return platformName.get();
    }

    public void setDeviceName(String value) {
        deviceName.set(value);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setiOSVersion(String value) {
        iOSVersion.set(value);
    }

    public String getiOSVersion() {
        return iOSVersion.get();
    }

    public void setUdid(String value) {
        udid.set(value);
    }

    public String getUdid() {
        return udid.get();
    }
}
