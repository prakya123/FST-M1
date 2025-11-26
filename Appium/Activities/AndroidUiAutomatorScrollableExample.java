package Examples;
public class AndroidUiAutomatorScrollableExample {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        // Open Selenium page
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void scrollIntoViewTest() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));

        // Just scroll
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        // Locate element
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Tab opener']")).click();

        // Scroll and locate elements
        //driver.findElement(AppiumBy.androidUIAutomator(
                //UiScrollable + ".scrollTextIntoView(\"Tab Opener\")"
        //)).click();

        // Wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Click Me!")));
        // Print page title
        String pageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'New Tab')]")).getText();
        System.out.println("Page title is: " + pageTitle);

        // Assertion
        Assert.assertEquals(pageTitle, "New Tab Opener");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}