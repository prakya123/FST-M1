package base;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity3_CompletedTasks extends BaseTest {

    @BeforeClass
    public void setUp() throws Exception {
        createNativeDriver();
    }

    @Test
    public void completedTasks() {

        List<WebElement> checkboxes =
                driver.findElements(AppiumBy.id(APP_PACKAGE + ":id/taskCheckbox"));

        checkboxes.get(0).click();
        checkboxes.get(1).click();

        AndroidElement thirdRow = (AndroidElement) driver.findElements(
                AppiumBy.id(APP_PACKAGE + ":id/taskRow")).get(2);

        driver.executeScript("mobile: longClickGesture",
                java.util.Map.of("elementId", thirdRow.getId()));

        AndroidElement seekbar =
                (AndroidElement) driver.findElement(AppiumBy.id(APP_PACKAGE + ":id/progressSeekBar"));

        int xStart = ((Object) seekbar.getLocation()).getX();
        int width = ((Object) seekbar.getSize()).getWidth();
        int y = ((Object) seekbar.getLocation()).getY();

        int moveTo = xStart + width / 2; // 50%

        driver.executeScript("mobile: dragGesture", java.util.Map.of(
                "elementId", seekbar.getId(),
                "endX", moveTo,
                "endY", y+5
        ));

        driver.findElement(AppiumBy.id(APP_PACKAGE + ":id/saveButton")).click();

        driver.findElement(AppiumBy.accessibilityId("More options")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"Completed tasks\")")).click();

        List<WebElement> completed =
                driver.findElements(AppiumBy.id(APP_PACKAGE + ":id/taskRow"));

        Assert.assertEquals(completed.size(), 2);
    }
}
