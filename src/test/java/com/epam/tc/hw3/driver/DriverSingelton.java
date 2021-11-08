package com.epam.tc.hw3.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingelton {

    private static WebDriver webDriver;
    private static final long TEN_SECONDS = 10;

    private DriverSingelton() {}

    public static WebDriver getWebDriver() {
        if (null == webDriver) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts()
                     .implicitlyWait(TEN_SECONDS, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void closeWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
