package com.example.tests;

import com.example.pages.LoginPage;
import com.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Sample TestNG test demonstrating how to use the Page Object and DriverFactory.
 *
 * <p>This test navigates to a dummy login page, enters credentials and
 * attempts a login. Assertions should be updated to reflect the behaviour
 * of your actual application under test.</p>
 */
public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSuccessfulLogin() {
        // Replace with the actual URL of your login page
        String url = "https://example.com/login";
        loginPage.open(url)
                 .enterUsername("user@example.com")
                 .enterPassword("password123");
        loginPage.clickLogin();

        // Replace the expected title with the title after a successful login
        String expectedTitle = "Dashboard";
        Assert.assertEquals(loginPage.getTitle(), expectedTitle, "User should be redirected to the dashboard.");
    }
}
