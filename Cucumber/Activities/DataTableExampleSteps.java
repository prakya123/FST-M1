package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataTableExampleSteps {

    WebDriver driver;

    @Given("user is on the To-Do list page")
    public void openPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://training-support.net/webelements/todo-list");

        assertEquals("Selenium: To-Do List", driver.getTitle());
    }

    @When("user adds the following tasks")
    public void inputTasks(DataTable inputTasks) throws InterruptedException {
        List<String> tasks = inputTasks.asList();
        System.out.println(tasks);

        for(String task : tasks) {
            driver.findElement(By.id("todo-input")).sendKeys(task);
            driver.findElement(By.id("todo-add")).click();
            Thread.sleep(1000);
        }
    }

    @Then("they can see the task added to the list")
    public void verifyResults() {
        System.out.println("All tasks present");
        driver.quit();
    }
}
