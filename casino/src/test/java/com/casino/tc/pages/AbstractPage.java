package com.casino.tc.pages;

import com.casino.tc.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver webDriver;

    protected abstract AbstractPage openPage();

    protected static final int TEN_SECONDS = 10;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = DriverSingleton.getWebDriver();
    }
}
