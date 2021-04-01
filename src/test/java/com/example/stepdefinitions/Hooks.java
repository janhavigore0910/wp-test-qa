package com.example.stepdefinitions;

import com.example.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private final DriverFactory driverFactory = new DriverFactory();

    @Before()
    public void beforeScenario(){
        driverFactory.setUp();
    }

    @After()
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            driverFactory.takeScreenshot(scenario);
        }
        driverFactory.tearDown();
    }
}
