package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    // ❗ UPDATE THESE BASED ON YOUR APK
    public static final String APP_PACKAGE  = "com.example.android.todolist";
    public static final String APP_ACTIVITY = ".MainActivity";

    // For Native App
    protected void createNativeDriver() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        ((Object) options).setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");
        options.setAppPackage(APP_PACKAGE);
        options.setAppActivity(APP_ACTIVITY);
        options.setNoReset(false);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // For Chrome browser
    protected void createChromeDriver() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");
        options.withBrowserName("Chrome");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        if (driver != null) driver.quit();
    }
}
