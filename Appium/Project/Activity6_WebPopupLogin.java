package base;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6_WebPopupLogin extends BaseTest {

    @BeforeClass
    public void setUp() throws Exception {
        createChromeDriver();
    }

    @Test
    public void popupLogin() {
        driver.get("https://training-support.net/webelements");

        driver.findElement(By.xpath("//h3[text()='Popups']/..")).click();

        driver.findElement(By.id("signInButton")).click();

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement msg = driver.findElement(By.id("action-confirmation"));
        Assert.assertTrue(msg.getText().contains("Welcome"));
    }
}
