package com.casino.tc.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage{

    @FindBy(id = "header-logo")
    private WebElement logo;

    @FindBy(xpath = "//span[contains(text(), \"Users\")]")
    private WebElement usersButton;

    @FindBy(xpath = "//p[text()='Players online / total']/preceding-sibling::p[text()=' 0 / 12010']")
    private WebElement playersButton;

    @FindBy(xpath = "//div[@class = 'panel-body']")
    private WebElement listOfPlayers;


    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Step("Check Logo is displayed")
    public boolean checkLogoIsDisplayed() {
        return logo.isDisplayed();
    }

//    @Step("Click Users Button")
//    public void clickUsersButtons() {
//        usersButton.click();
//    }

    @Step("Click Players Button")
    public void clickPlayersButton() {
        playersButton.click();
    }

    @Step("The List of Players is displayed")
    public boolean listOfPlayersIsDisplayed() {
        return listOfPlayers.isDisplayed();
    }
}
