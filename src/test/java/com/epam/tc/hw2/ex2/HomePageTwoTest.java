package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.BaseHomePageTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageTwoTest extends BaseHomePageTest {

    @Test
    public void homePageOneTest() {

        //5. Open Page
        webDriver.findElement(By.className("dropdown-toggle")).click();
        webDriver.findElement(By.linkText("DIFFERENT ELEMENTS")).click();

        //6. Select checkboxes
        List<WebElement> checkboxes = webDriver.findElements(By.xpath("//label[@class='label-checkbox']"));
        checkboxes.get(0).click();
        checkboxes.get(2).click();

        //7. Select radio
        List<WebElement> radio = webDriver.findElements(By.xpath("//label[@class='label-radio']"));
        radio.get(3).click();

        //8. Select in dropdown
        webDriver.findElement(By.className("colors")).click();
        webDriver.findElement(By.xpath("//option[text()='Yellow']")).click();

        //9. Assert log rows
        WebElement logs = webDriver.findElement(By.xpath("//ul[@class='panel-body-list logs']"));
        List<WebElement> logText = logs.findElements(By.tagName("li"));
        softAssert.assertTrue(logText.get(0).getText().contains("Colors: value changed to Yellow"));
        softAssert.assertTrue(logText.get(1).getText().contains("metal: value changed to Selen"));
        softAssert.assertTrue(logText.get(2).getText().contains("Wind: condition changed to true"));
        softAssert.assertTrue(logText.get(3).getText().contains("Water: condition changed to true"));

        softAssert.assertAll();

    }
}
