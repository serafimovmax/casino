package com.epam.tc.hw4.page;

import com.epam.tc.hw4.driver.DriverSingelton;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver webDriver;

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = DriverSingelton.getWebDriver();
    }
}
