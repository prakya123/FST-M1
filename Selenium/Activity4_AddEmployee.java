package com.selenium.orangehrm.tests;

import com.selenium.orangehrm.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity4_AddEmployee extends BaseTest {

    @Test
    public void addNewEmployee() {
        // Step 1: Open OrangeHRM site and log in
        driver.get(baseUrl);
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        // Step 2: Click on PIM tab
        WebElement pimMenu = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimMenu.click();

        // Step 3: Click Add Employee
        driver.findElement(By.id("menu_pim_addEmployee")).click();

        // Step 4: Fill out employee details
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");

        // Step 5: Click Save
        driver.findElement(By.id("btnSave")).click();

        // Step 6: Go back to PIM > Employee List
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();

        // Step 7: Search by employee name
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("John Doe");
        driver.findElement(By.id("searchBtn")).click();

        // Step 8: Verify employee creation
        WebElement empName = driver.findElement(By.xpath("//a[contains(text(),'John')]"));
        Assert.assertTrue(empName.isDisplayed(), "Employee creation verification failed!");

        System.out.println("Employee John Doe successfully created!");
    }
}
