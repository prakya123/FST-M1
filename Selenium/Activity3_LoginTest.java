package com.selenium.orangehrm.tests;

import com.selenium.orangehrm.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity3_LoginTest extends BaseTest {

    @Test
    public void loginToOrangeHRM() throws InterruptedException {
        // Step 1: Open the OrangeHRM site
        driver.get(baseUrl);

        // Step 2: Enter username
        driver.findElement(By.id("txtUsername")).sendKeys("orange");

        // Step 3: Enter password
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");

        // Step 4: Click Login button
        driver.findElement(By.id("btnLogin")).click();

        // Step 5: Wait for the page to load
        Thread.sleep(3000);

        // Step 6: Verify login successful
        String dashboardHeader = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(dashboardHeader, "Dashboard", "Login failed — Dashboard not visible!");

        System.out.println("✅ Successfully logged in — Dashboard displayed!");
    }
}