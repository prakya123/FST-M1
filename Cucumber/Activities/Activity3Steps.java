package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Activity3Steps {

    private WebDriver driver;
    private WebDriverWait wait;
    private Alert alert;

    @Given("User is on the page")
    public void user_is_on_the_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://training-support.net/webelements/alerts");
    }

    // ---------- SIMPLE ALERT ----------

    @When("User clicks the Simple Alert button")
    public void click_simple_alert_button() {
        driver.findElement(By.xpath("//button[text()='Simple']")).click();
    }

    // ---------- CONFIRMATION ALERT ----------

    @When("User clicks the Confirmation Alert button")
    public void click_confirm_alert_button() {
        driver.findElement(By.xpath("//button[text()='Confirmation']")).click();
    }

    // ---------- PROMPT ALERT ----------

    @When("User clicks the Prompt Alert button")
    public void click_prompt_alert_button() {
        driver.findElement(By.xpath("//button[text()='Prompt']")).click();
    }

    // ---------- COMMON ALERT HANDLING ----------

    @Then("Alert opens")
    public void alert_opens() {
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
    }

    @And("Read the text from it and print it")
    public void read_text_and_print() {
        String text = alert.getText();
        System.out.println("Alert text: " + text);
    }

    @And("Close the alert")
    public void close_the_alert() {
        alert.accept();
    }

    @And("Close the alert with Cancel")
    public void close_alert_with_cancel() {
        alert.dismiss();
    }

    @And("Write a custom message in it")
    public void write_to_prompt() {
        alert.sendKeys("Hello from Cucumber!");
    }

    @And("Write {string} into the prompt")
    public void write_into_prompt(String inputText) {
        alert.sendKeys(inputText);
    }

    @And("Read the result text")
    public void read_result_text() {
        WebElement result = driver.findElement(By.id("result"));
        System.out.println("Result text: " + result.getText());
        driver.quit();
    }
}
