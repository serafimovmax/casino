package com.epam.tc.hw3.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentElementsPage extends AbstractPage {

    @FindBy(className = "dropdown-toggle")
    private WebElement service;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;

    @FindBy(xpath = "//label[contains(.,'Water')]")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[contains(.,'Wind')]")
    private WebElement windCheckbox;

    @FindBy(xpath = "//label[contains(.,'Selen')]")
    private WebElement radioSelen;

    @FindBy(className = "colors")
    private WebElement dropdownColors;

    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowColor;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logsComponent;


    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public void clickServiceButton() {
        service.click();
    }

    public void goToDifferentElementsPage() {
        differentElements.click();
    }

    public void selectWaterCheckbox() {
        waterCheckbox.click();
    }

    public void selectWindCheckbox() {
        windCheckbox.click();
    }

    public void selectSelenRadio() {
        radioSelen.click();
    }

    public void clickDropdownColors() {
        dropdownColors.click();
    }

    public void selectYellowColor() {
        yellowColor.click();
    }

    public List<String> getLogsComponetText() {
        return logsComponent.stream()
                            .map(logsText -> logsText
                                .getText().substring(logsText.getText().indexOf(" ") + 1))
                            .collect(Collectors.toList());
    }
}

