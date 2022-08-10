package com.casino.ui.cucumber.steps;

import com.casino.ui.driver.DriverSingleton;
import com.casino.ui.model.User;
import com.casino.ui.pages.LoginPage;
import com.casino.ui.pages.MainPage;
import com.casino.ui.service.DataProvider;
import com.casino.ui.service.UserCreator;
import org.openqa.selenium.WebDriver;

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
