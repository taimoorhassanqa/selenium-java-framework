package com.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader loads configuration properties from a file and system properties.
 * The default config file location is src/test/resources/config.properties.
 * You can override the location by setting the system property 'config.file'.
 */
public class ConfigReader {
    private final Properties properties = new Properties();

    public ConfigReader() {
        loadProperties();
    }

    /**
     * Loads properties from the configuration file defined by 'config.file' system property
     * or the default location if not specified.
     */
    private void loadProperties() {
        String configFilePath = System.getProperty("config.file", "src/test/resources/config.properties");
        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + configFilePath, e);
        }
    }

    /**
     * Returns the property value associated with the given key. If a system property
     * with the same key is set, it takes precedence over the value from the config file.
     *
     * @param key property key
     * @return property value or null if not found
     */
    public String getProperty(String key) {
        String value = System.getProperty(key);
        if (value != null) {
            return value;
        }
        return properties.getProperty(key);
    }

    /**
     * Returns the integer value of the property with the given key, or a default value
     * if the property is not found or cannot be parsed as an integer.
     *
     * @param key property key
     * @param defaultValue default value if property not found or invalid
     * @return integer property value or defaultValue
     */
    public int getInt(String key, int defaultValue) {
        String value = getProperty(key);
        try {
            return value != null ? Integer.parseInt(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
