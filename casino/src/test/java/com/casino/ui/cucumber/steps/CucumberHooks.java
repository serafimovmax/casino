package com.casino.ui.cucumber.steps;

import com.casino.ui.driver.DriverSingleton;
import io.cucumber.java.After;

public class CucumberHooks {
    @After
    public void closeDriver() {
        DriverSingleton.closeDriver();
    }
}
