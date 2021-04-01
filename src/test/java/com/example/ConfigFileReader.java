package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;

    public ConfigFileReader(){
        BufferedReader reader;
        String propertyFilePath = "src//test//resources//config//config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        }
    }

    public String getChromeDriverPath(){
        String driverPath = properties.getProperty("chromeDriverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("chromeDriverPath not specified in the config.properties file.");
    }

    public String getFirefoxDriverPath(){
        String driverPath = properties.getProperty("firefoxDriverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("firefoxDriverPath not specified in the config.properties file.");
    }

    public String getBrowser(){
        String browser = properties.getProperty("browser");
        if(browser!=null) return browser;
        else throw new RuntimeException("browser not specified in the config.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the config.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("baseUrl");
        if(url != null) return url;
        else throw new RuntimeException("Base Url not specified in the config.properties file.");
    }

    public String getUsername() {
        String login = properties.getProperty("login");
        if (login != null) return login;
        else throw new RuntimeException("login not specified in the config.properties file.");

    }

    public String getPassword() {
        String password = properties.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("Password not specified in the config.properties file.");
    }

    public String getHeadlessModeValue(){
        String headlessMode = properties.getProperty("headlessMode");
        if (headlessMode != null) return headlessMode;
        else throw new RuntimeException("headlessMode not specified in the config.properties file.");
    }

}

