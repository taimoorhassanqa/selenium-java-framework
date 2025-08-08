package com.example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Factory class to manage and provide WebDriver instances.
 *
 * <p>The factory uses WebDriverManager to handle driver binaries. By default
 * it creates a ChromeDriver in headless mode. Adjust the implementation
 * to suit other browsers or configurations.</p>
 */
public class DriverFactory {

    /**
     * Create and return a new WebDriver instance.
     *
     * @return a configured WebDriver
     */
    public static WebDriver createDriver() {
        // Setup chromedriver binary using WebDriverManager
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        // Run in headless mode for CI environments
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        return new ChromeDriver(options);
    }
}
