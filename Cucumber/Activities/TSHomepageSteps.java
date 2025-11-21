package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TSHomepageSteps extends BaseClass {

    @Given("user is on the TS homepage")
    public void openTSHomepage() {
        initDriver(); 
        driver.get("https://training-support.net");
    }

    @When("the user clicks on the About Us link")
    public void clickAboutUsLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement about = wait.until(
            ExpectedConditions.elementToBeClickable(By.linkText("About Us"))
        );
        about.click();
    }

    @Then("they are redirected to another page")
    public void verifyRedirect() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(
            ExpectedConditions.titleIs("Training Support")
        ));
    }
}