package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity4 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://training-support.net/webelements/target-practice");
    }

    @Test
    public void verifyPageTitle() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals(title, "Selenium: Target Practice");
    }

    @Test
    public void findBlackButtonText() {
        // Updated selector with implicit wait
        WebElement blackButton = driver.findElement(By.cssSelector("button.ui.black.button"));
        Assert.assertTrue(blackButton.isDisplayed());
        System.out.println("Black button text is: " + blackButton.getText());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
