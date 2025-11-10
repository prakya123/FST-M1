package com.selenium.orangehrm.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public String baseUrl = "http://alchemy.hguy.co/orangehrm";

    @BeforeClass
    public void setUp() {
        // Automatically sets up the right ChromeDriver version
        WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
        driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
           //  driver.quit();// to keep the browser open
        }
    }
}

