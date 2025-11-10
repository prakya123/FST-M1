package com.selenium.orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8_ApplyLeave {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://alchemy.hguy.co:8080/orangehrm");
    }

    @Test
    public void applyLeaveTest() throws InterruptedException {
        // Login
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        // Wait for Dashboard
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard-quick-launch-panel-menu_holder")));

        // Click Apply Leave
        driver.findElement(By.xpath("//span[text()='Apply Leave']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("applyleave_txtLeaveType")));

        // Select Leave Type
        Select leaveType = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leaveType.selectByVisibleText("DayOff");

        // Enter From and To dates
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2025-11-01");

        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2025-11-02");

        // Add comment
        driver.findElement(By.id("applyleave_txtComment")).sendKeys("Applying leave for testing automation script");

        // Click Apply
        driver.findElement(By.id("applyBtn")).click();

        // Navigate to My Leave to verify
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();

        // Wait for table
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));

        // Verify leave request is shown
        WebElement table = driver.findElement(By.id("resultTable"));
        Assert.assertTrue(table.getText().contains("Pending Approval"), "Leave not applied or not found!");

        System.out.println("✅ Leave applied successfully and status is 'Pending Approval'.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
