package com.casino.tc.cucumber.steps;

import com.casino.tc.driver.DriverSingleton;
import io.cucumber.java.After;

public class CucumberHooks {
    @After
    public void closeDriver() {
        DriverSingleton.closeDriver();
    }
}
