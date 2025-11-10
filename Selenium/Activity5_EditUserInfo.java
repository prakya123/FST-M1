package com.selenium.orangehrm.tests;

import com.selenium.orangehrm.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Activity5_EditUserInfo extends BaseTest {

    @Test
    public void editUserInformation() {
        // Step 1: Open the OrangeHRM site and login
        driver.get(baseUrl);
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        // Step 2: Click on the "My Info" tab
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        // Step 3: Click the Edit button
        driver.findElement(By.id("btnSave")).click();

        // Step 4: Fill in Name, Gender, Nationality, and DOB
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("John");

        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Doe");

        driver.findElement(By.id("personal_optGender_1")).click(); // Male

        Select nationality = new Select(driver.findElement(By.id("personal_cmbNation")));
        nationality.selectByVisibleText("Indian");

        driver.findElement(By.id("personal_DOB")).clear();
        driver.findElement(By.id("personal_DOB")).sendKeys("1996-03-07");

        // Step 5: Click Save
        driver.findElement(By.id("btnSave")).click();

     // Step 6: Close browser
        driver.quit();
    }
}
