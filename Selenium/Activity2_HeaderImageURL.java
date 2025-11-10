package com.selenium.orangehrm.tests;

import com.selenium.orangehrm.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Activity2_HeaderImageURL extends BaseTest {

    @Test
    public void getHeaderImageURL() throws InterruptedException {
        // Step 1: Open the OrangeHRM page
        driver.get(baseUrl);

        // Step 2: Wait a bit to ensure page loads
        Thread.sleep(2000);

        // Step 3: Find the header image (logo)
        WebElement headerImage = driver.findElement(By.xpath("//div[@id='divLogo']//img"));

        // Step 4: Get the 'src' attribute
        String imageUrl = headerImage.getAttribute("src");

        // Step 5: Print it to the console
        System.out.println("Header Image URL is: " + imageUrl);
    }
}
