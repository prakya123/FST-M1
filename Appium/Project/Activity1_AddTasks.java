package base;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1_AddTasks extends BaseTest {

    @BeforeClass
    public void setUp() throws Exception {
        createChromeDriver();
    }

    protected void createChromeDriver() {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void addTasks() {

        By addTaskBtn = AppiumBy.id(APP_PACKAGE + ":id/addTaskButton");
        By titleField = AppiumBy.id(APP_PACKAGE + ":id/taskTitle");
        By prioritySpinner = AppiumBy.id(APP_PACKAGE + ":id/prioritySpinner");
        By saveBtn = AppiumBy.id(APP_PACKAGE + ":id/saveButton");

        String[][] tasks = {
                {"Complete Activity 1", "High"},
                {"Complete Activity 2", "Medium"},
                {"Complete Activity 3", "Low"}
        };

        for (String[] t : tasks) {
            driver.findElement(addTaskBtn).click();
            driver.findElement(titleField).sendKeys(t[0]);
            driver.findElement(prioritySpinner).click();
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"" + t[1] + "\")")).click();
            driver.findElement(saveBtn).click();
        }

        // Assertions
        for (String[] t : tasks) {
            Assert.assertTrue(
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().textContains(\"" + t[0] + "\")")).isDisplayed()
            );
        }
    }
}
