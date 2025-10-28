package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            // Set up ChromeDriver automatically
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // 1. Open the URL
            driver.get("https://training-support.net/webelements/login-form/");

            // 2. Get and print the title
            String title = driver.getTitle();
            System.out.println("Page title: " + title);

            // 3. Find username and enter "admin"
            // (Locator used: id "username")
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("admin");

            // 4. Find password and enter "password"
            // (Locator used: id "password")
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("password");

            // 5. Find and click the "Log in" button
            // (Locator used: button text)
            WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
            loginButton.click();

            // Small wait to let any result appear (not ideal for large tests)
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
