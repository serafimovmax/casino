package com.casino.tc.util;

import com.casino.tc.driver.DriverSingleton;
import io.qameta.allure.Attachment;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult itestresult) {
        WebDriver webDriver = DriverSingleton.getWebDriver();
        saveScreenshot(webDriver);
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] saveScreenshot(WebDriver webDriver) {
        File screenCapture = ((TakesScreenshot) webDriver)
            .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                ".//target/screenshots/"
                    + getCurrentTimeAsString()
                    + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
