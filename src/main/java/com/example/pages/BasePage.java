package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Abstract base class providing common WebDriver actions. All page objects
 * should extend this class to inherit common behaviours like finding
 * elements, clicking and entering text. It encapsulates the WebDriver
 * instance and exposes convenience methods to reduce duplication.
 */
public abstract class BasePage {
    protected final WebDriver driver;
    private final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        // Wait up to 10 seconds for elements to be visible/clickable
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Find a WebElement using a locator.
     *
     * @param locator the By locator
     * @return the WebElement
     */
    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Click on an element specified by locator.
     *
     * @param locator the By locator
     */
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Type text into an element specified by locator.
     *
     * @param locator the By locator
     * @param text    the text to enter
     */
    public void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get the current page title.
     *
     * @return the title as String
     */
    public String getTitle() {
        return driver.getTitle();
    }
}
