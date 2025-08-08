package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Utility class for waiting for various conditions in WebDriver.
 * Provides convenience methods to wait for element visibility, clickability,
 * and invisibility using explicit waits.
 */
public class WaitHelper {
    private final WebDriver driver;
    private final WebDriverWait wait;

    /**
     * Creates a new WaitHelper with a custom timeout.
     *
     * @param driver the WebDriver instance
     * @param timeout the duration to wait for conditions
     */
    public WaitHelper(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }

    /**
     * Creates a new WaitHelper with a default timeout of 10 seconds.
     *
     * @param driver the WebDriver instance
     */
    public WaitHelper(WebDriver driver) {
        this(driver, Duration.ofSeconds(10));
    }

    /**
     * Waits for the given element to be visible on the page.
     *
     * @param element the element to wait for
     * @return the visible WebElement
     */
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the given element to be clickable on the page.
     *
     * @param element the element to wait for
     * @return the clickable WebElement
     */
    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits until the given element is no longer visible on the page.
     *
     * @param element the element to wait for invisibility
     * @return true if the element becomes invisible within the timeout, false otherwise
     */
    public boolean waitForInvisibility(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
