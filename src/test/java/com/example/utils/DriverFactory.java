package com.example.utils;

import com.example.ConfigFileReader;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    protected static WebDriver driver;
    protected static WebDriverWait waitVar = null;
    protected static Boolean headlessModeValue = false;

    ConfigFileReader configFileReader = new ConfigFileReader();

    public void setUp(){

        switch (configFileReader.getBrowser().toLowerCase()){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", configFileReader.getFirefoxDriverPath());
                headlessModeValue = Boolean.parseBoolean(configFileReader.getHeadlessModeValue());
                if(headlessModeValue) {
                    FirefoxOptions options = new FirefoxOptions();
                    options.setHeadless(true);
                    driver = new FirefoxDriver(options);
                } else { driver = new FirefoxDriver(); }
                break;
            case "ie":
                //Here you can put the code for IE Webdriver if you need multiple options to execute the tests.
            default:
                System.setProperty("webdriver.chrome.driver", configFileReader.getChromeDriverPath());
                // Initialize new WebDriver session
                System.out.println("Starting driver...");
                headlessModeValue = Boolean.parseBoolean(configFileReader.getHeadlessModeValue());
                if(headlessModeValue){
                    //running with headless mode
                    ChromeOptions optionsForChrome = new ChromeOptions();
                    optionsForChrome.addArguments("headless");
                    optionsForChrome.addArguments("window-size=1200x600");
                    driver = new ChromeDriver(optionsForChrome);
                } else{ driver = new ChromeDriver(); }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        driver.get(configFileReader.getApplicationUrl());
        waitVar = new WebDriverWait(driver, 15);
    }

    public void tearDown() {
        driver.close();
    }

    public void takeScreenshot(Scenario scenario){
        // Take a screenshot...
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        // embed it in the report.
        scenario.attach(screenshot, "image/png", scenario.getName());
    }
}
