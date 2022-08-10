package com.casino.ui.pages;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    @FindBy(id = "header-logo")
    private WebElement logo;

    @FindBy(xpath = "//span[contains(text(), \"Users\")]")
    private WebElement usersButton;

    @FindBy(xpath = "//p[text()='Players online / total']")
    private WebElement playersButton;

    @FindBy(xpath = "//div[@class = 'panel-body']")
    private WebElement listOfPlayers;

    @FindBy(xpath = "//tbody/tr[*]/td[3]")
    private List<WebElement> externalIdList;

    @FindBy(xpath = "//a[text()='External ID']")
    private WebElement externalIdButton;

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

    @Step("Click Players Button")
    public void clickPlayersButton() {
        playersButton.click();
    }

    @Step("The List of Players is displayed")
    public boolean listOfPlayersIsDisplayed() {
        return listOfPlayers.isDisplayed();
    }

    @Step("Click External ID button")
    public void iClickExternalIdButton() {
        externalIdButton.click();
    }

    @Step("Get sorted External ID")
    public List<String> getExternalIdList() {
        return externalIdList.stream()
                             .map(logMessage -> logMessage
                                 .getText()
                                 .substring(logMessage.getText().indexOf(" ") + 1))
                             .collect(Collectors.toList());
    }
}
