package com.casino.ui.pages;

import com.casino.ui.model.User;
import com.casino.ui.service.DataProvider;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    private static final String URL = DataProvider.getLoginData("website");

    @FindBy(id = "UserLogin_username")
    private WebElement loginField;

    @FindBy(id = "UserLogin_password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[contains(@value, 'Sign in')]")
    private WebElement signInButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }
    @Step("Open the page")
    public LoginPage openPage() {
        webDriver.navigate().to(URL);
        new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return this;
    }

    @Step("Get the url of page")
    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    @Step("Get the title of page")
    public String getTitle() {
        return webDriver.getTitle();
    }

    @Step("Perform login")
    public MainPage login(User user) {
        loginField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        signInButton.click();
        return new MainPage(webDriver);
    }
}
