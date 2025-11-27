package base;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5_WebLoginForm extends BaseTest {

    @BeforeClass
    public void setUp() throws Exception {
        createChromeDriver();
    }

    private void openForm() {
        driver.get("https://training-support.net/webelements");
        driver.findElement(By.xpath("//h3[text()='Login Form']/..")).click();
    }

    @Test
    public void validLogin() {
        openForm();

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement msg = driver.findElement(By.id("action-confirmation"));
        Assert.assertTrue(msg.getText().contains("Welcome Back"));
    }

    @Test
    public void invalidLogin() {
        openForm();

        driver.findElement(By.id("username")).sendKeys("abc");
        driver.findElement(By.id("password")).sendKeys("xyz");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement msg = driver.findElement(By.id("action-confirmation"));
        Assert.assertTrue(msg.getText().contains("Invalid"));
    }
}
