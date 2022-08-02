package com.sausedemo.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private Properties properties;

    public PropertyReader() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            String currentEnv = getProperty("environment");
            Properties envProp = new Properties();
            envProp.load(getClass().getClassLoader().getResourceAsStream(currentEnv +".properties"));
            properties.putAll(envProp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  String getProperty (String key) {
        return properties.getProperty(key);
    }
}
