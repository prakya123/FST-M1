package base;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity4_WebToDoList extends BaseTest {

    @BeforeClass
    public void setUp() throws Exception {
        createChromeDriver();
    }

    @Test
    public void webTodoList() {
        driver.get("https://training-support.net/webelements");

        WebElement todoCard = driver.findElement(By.xpath("//h3[text()='To-Do List']/.."));
        todoCard.click();

        WebElement input = driver.findElement(By.cssSelector("input[placeholder='Add task']"));
        WebElement addBtn = driver.findElement(By.id("addTask"));

        String[] tasks = {"Add tasks to list", "Get number of tasks", "Clear the list"};

        for (String t : tasks) {
            input.sendKeys(t);
            addBtn.click();
        }

        for (String t : tasks) {
            driver.findElement(By.xpath("//li/span[text()='" + t + "']")).click();
        }

        List<WebElement> total = driver.findElements(By.cssSelector("ul#tasksList li"));
        Assert.assertEquals(total.size(), 5);
    }
}
