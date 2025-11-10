package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net");
    }

    @Test
    public void testTitleAndAboutUs() {
        String title = driver.getTitle();
        System.out.println("Home page title: " + title);
        Assert.assertEquals(title, "Training Support");

        driver.findElement(By.linkText("About Us")).click();


        String newTitle = driver.getTitle();
        System.out.println("New page title: " + newTitle);
        Assert.assertEquals(newTitle, "About Training Support");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}