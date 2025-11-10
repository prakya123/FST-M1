package com.selenium.orangehrm.tests;

import com.selenium.orangehrm.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1_VerifyTitle extends BaseTest {

    @Test
    public void verifyWebsiteTitle() {
        driver.get(baseUrl);

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        Assert.assertEquals(title, "OrangeHRM", "Page title should be exactly 'OrangeHRM'");
    }
}
