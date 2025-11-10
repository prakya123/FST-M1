package com.selenium.orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity9_RetrieveEmergencyContacts {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Launch browser and open OrangeHRM
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://alchemy.hguy.co:8080/orangehrm");
    }

    @Test
    public void retrieveEmergencyContacts() throws InterruptedException {
        // Login
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        // Click on "My Info"
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(2000);

        // Click on "Emergency Contacts"
        driver.findElement(By.linkText("Emergency Contacts")).click();
        Thread.sleep(2000);

        // Locate the Emergency Contacts table
        WebElement table = driver.findElement(By.id("emgcontact_list"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        System.out.println("🔹 Emergency Contacts Information:");
        // Loop through each row and print data
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + "  |  ");
            }
            System.out.println();
        }
    }

    @AfterClass
    public void tearDown() {
        // Close browser
        driver.quit();
    }
}
