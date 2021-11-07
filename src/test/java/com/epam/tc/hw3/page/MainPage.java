package com.epam.tc.hw3.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li")
    private List<WebElement> headerMenu;

    @FindBy(xpath = "//div[@class='benefit-icon']")
    private List<WebElement> benefitIcons;

    @FindBy(xpath = "//span[@class='benefit-txt']")
    private List<WebElement> benefitTxt;

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li")
    private List<WebElement> leftMenu;


    protected MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }



    public String getUserName() {
        return userName.getText();
    }

    public WebElement fullUserName() {
        return userName;
    }

    public List<String> getHeaderMenuText() {
        return headerMenu.stream()
                         .map(WebElement::getText)
            .collect(Collectors.toList());
    }

    public Boolean headerMenuDisplayed() {
        return headerMenu.stream().allMatch(WebElement::isDisplayed);
    }

    public Boolean benefitIconsDisplayed() {
        return benefitIcons.stream()
                           .allMatch(WebElement::isDisplayed);
    }

    public List<String> getBenefitIconsText() {
        return benefitTxt.stream()
                         .map(WebElement::getText)
            .collect(Collectors.toList());
    }

    public Boolean benefitIconsTextDisplayed() {
        return benefitTxt.stream().allMatch(WebElement::isDisplayed);
    }

    public WebElement getIframe() {
        return iframe;
    }

    public void switchToIframeButton() {
        webDriver.switchTo().frame(iframe);
    }

    public Boolean iframeButtonDisplayed() {
        return frameButton.isDisplayed();
    }

    public void switchToParentFrame() {
        webDriver.switchTo().parentFrame();
    }

    public Boolean leftMenuDisplayed() {
        return leftMenu.stream()
                       .allMatch(WebElement::isDisplayed);
    }

    public List<String> getLeftMenuText() {
        return leftMenu.stream().map(WebElement::getText)
                       .collect(Collectors.toList());
    }


}
