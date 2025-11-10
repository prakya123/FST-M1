package com.selenium.orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7_AddQualifications {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("http://alchemy.hguy.co:8080/orangehrm");
    }

    @Test
    public void addQualification() {
        // Login
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        // Wait for the dashboard to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewMyDetails")));

        // Click My Info tab
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        // Wait for My Info page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Qualifications")));

        // Click Qualifications
        driver.findElement(By.linkText("Qualifications")).click();

        // Wait for Add button under Work Experience
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addWorkExperience")));

        // Click Add
        driver.findElement(By.id("addWorkExperience")).click();

        // Fill Work Experience details
        driver.findElement(By.id("experience_employer")).sendKeys("TechCorp Pvt Ltd");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("QA Engineer");
        driver.findElement(By.id("experience_from_date")).clear();
        driver.findElement(By.id("experience_from_date")).sendKeys("2023-01-01");
        driver.findElement(By.id("experience_to_date")).clear();
        driver.findElement(By.id("experience_to_date")).sendKeys("2024-12-31");

        // Save
        driver.findElement(By.id("btnWorkExpSave")).click();

        // Wait until table is visible again
        WebElement table = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("tblWorkExp"))
        );

        // Assert that the entry is present
        Assert.assertTrue(table.getText().contains("TechCorp Pvt Ltd"),
                "Work experience was not added successfully!");

        System.out.println("✅ Work experience added successfully!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
