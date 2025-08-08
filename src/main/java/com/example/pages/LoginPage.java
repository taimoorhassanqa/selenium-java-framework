package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing a generic login page. Update the locators to
 * reflect your actual application's login form. Methods return the page
 * object itself for fluent chaining.
 */
public class LoginPage extends BasePage {

    // Locators for username, password and login button
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigate to a given URL representing the login page.
     *
     * @param url the URL of the login page
     * @return the current LoginPage instance
     */
    public LoginPage open(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage enterUsername(String username) {
        type(usernameField, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordField, password);
        return this;
    }

    /**
     * Click the login button.
     */
    public void clickLogin() {
        click(loginButton);
    }
}
