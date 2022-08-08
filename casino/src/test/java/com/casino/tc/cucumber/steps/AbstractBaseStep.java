package com.casino.tc.cucumber.steps;

import com.casino.tc.driver.DriverSingleton;
import com.casino.tc.model.User;
import com.casino.tc.pages.LoginPage;
import com.casino.tc.pages.MainPage;
import com.casino.tc.service.DataProvider;
import com.casino.tc.service.UserCreator;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public abstract class AbstractBaseStep {
    public static final String URL = DataProvider.getLoginData("website");
    public WebDriver webDriver;
    public LoginPage loginPage;
    public static MainPage mainPage;
    public User testUser;

    public AbstractBaseStep() {
        webDriver = DriverSingleton.getWebDriver();
        testUser = UserCreator.withCredentialsFromProperty();
        loginPage = new LoginPage(webDriver);
    }

    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
