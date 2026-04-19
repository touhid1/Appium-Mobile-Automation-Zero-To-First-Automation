package com.qa;

public class TestConfig {

    public String getPlatformName() {
        return getValue("platformName", "Android");
    }

    public String getDeviceName() {
        return getValue("deviceName", "Android Emulator");
    }

    public String getUdid() {
        return getValue("udid", "emulator-5554");
    }

    public String getAppiumServerUrl() {
        return getValue("appiumServerUrl", "http://127.0.0.1:4723");
    }

    public String getAppPackage() {
        return getValue("appPackage", "com.android.settings");
    }

    public String getAppActivity() {
        return getValue("appActivity", ".Settings");
    }

    private String getValue(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value == null || value.isBlank()) {
            return defaultValue;
        }
        return value;
    }
}
