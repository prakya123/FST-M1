package com.selenium.orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6_VerifyDirectoryMenu {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the OrangeHRM login page
        driver.get("http://alchemy.hguy.co:8080/orangehrm");

        // Login using credentials
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test
    public void verifyDirectoryMenu() {
        // Locate the Directory menu item
        WebElement directoryMenu = driver.findElement(By.id("menu_directory_viewDirectory"));

        // Verify that the Directory menu item is displayed and enabled (clickable)
        Assert.assertTrue(directoryMenu.isDisplayed(), "Directory menu is not visible!");
        Assert.assertTrue(directoryMenu.isEnabled(), "Directory menu is not clickable!");

        // Click the Directory menu
        directoryMenu.click();

        // Verify the heading of the page matches "Search Directory"
        WebElement heading = driver.findElement(By.xpath("//h1[contains(text(),'Search Directory')]"));
        String headingText = heading.getText();
        System.out.println("Page heading is: " + headingText);

        Assert.assertEquals(headingText, "Search Directory", "Heading does not match!");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
