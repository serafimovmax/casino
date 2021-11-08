package com.epam.tc.hw3.page;

import com.epam.tc.hw3.Constants;
import com.epam.tc.hw3.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    private static final String URL = Constants.HOME_PAGE_URL.get();

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    public LoginPage openPage() {
        webDriver.navigate().to(URL);
        new WebDriverWait(webDriver, 10);
        return this;
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public MainPage login(User user) {
        userIcon.click();
        loginField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
        return new MainPage(webDriver);
    }
}
