public class BaseTest {

    public AndroidDriver driver;

    @BeforeMethod
    public void setup() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "com.android.settings");
        caps.setCapability("appActivity", ".Settings");

        driver = new AndroidDriver(
            new URL("http://127.0.0.1:4723"),
            caps
        );
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}