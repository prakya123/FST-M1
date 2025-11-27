package base;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2_EditTaskDeadline extends BaseTest {

    @BeforeClass
    public void setUp() throws Exception {
        createNativeDriver();
    }

    // Helper: Long press
    private void longPress(AndroidElement el) {
        driver.executeScript("mobile: longClickGesture", 
                java.util.Map.of("elementId", el.getId(), "duration", 2000));
    }

    @Test
    public void editTaskDeadline() {

        AndroidElement task1 = (AndroidElement) driver.findElement(
                AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Complete Activity 1\")"));

        longPress(task1);

        By deadline = AppiumBy.id(APP_PACKAGE + ":id/deadline");
        driver.findElement(deadline).click();

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().descriptionContains(\"Sat\")")).click();
        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(AppiumBy.id(APP_PACKAGE + ":id/saveButton")).click();

        AndroidElement edited = (AndroidElement) driver.findElement(
                AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Complete Activity 1\")"));

        Assert.assertTrue(edited.getText().toLowerCase().contains("sat"));
    }
}
