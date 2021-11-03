package com.epam.tc.hw2.ex1;

import static com.epam.tc.hw2.PageElements.IMG_TEXT;
import static com.epam.tc.hw2.PageElements.LEFT_BUTTONS;
import static com.epam.tc.hw2.PageElements.MENU_BUTTONS;

import com.epam.tc.hw2.BaseHomePageTest;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageOneTest extends BaseHomePageTest {

    @Test
    public void homePageOneTest() {

        //5. Assert menu buttons are displayed
        List<WebElement> menuButtons = webDriver.findElements(By.xpath(
            "//ul[@class='uui-navigation nav navbar-nav m-l8']/li"));
        for (WebElement menuElements : menuButtons) {
            softAssert.assertTrue(menuElements.isDisplayed());
            softAssert.assertEquals(menuButtons.stream().map(WebElement::getText)
                                               .collect(Collectors.toList()), MENU_BUTTONS);
        }

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imgIndex = webDriver.findElements(By.xpath("//div[@class='benefit-icon']"));
        for (WebElement img : imgIndex) {
            softAssert.assertTrue(img.isDisplayed());
        }

        //7. Assert that texts are displayed and equal to expected
        List<WebElement> imgText = webDriver.findElements(By.xpath(("//span[@class='benefit-txt']")));
        for (WebElement textImage : imgText) {
            softAssert.assertTrue(textImage.isDisplayed());
            softAssert.assertEquals(imgText.stream().map(WebElement::getText).collect(Collectors.toList()), IMG_TEXT);
        }

        //8. Assert that the iframe exists
        softAssert.assertTrue(webDriver.findElement(By.id("frame")).isDisplayed());

        //9. Assert that the “Frame Button” exists
        webDriver.switchTo().frame("frame");
        softAssert.assertTrue(webDriver.findElement(By.id("frame-button")).isDisplayed());

        //10. Assert that driver has focus on the original window
        webDriver.switchTo().parentFrame();

        //11. Assert that left section menu items are displayed and have proper text
        List<WebElement> leftSelection = webDriver.findElements(By.xpath("//ul[@class='sidebar-menu left']/li"));
        for (WebElement leftElement : leftSelection) {
            softAssert.assertTrue(leftElement.isDisplayed());
            softAssert.assertEquals(leftSelection.stream().map(WebElement::getText)
                                                 .collect(Collectors.toList()), LEFT_BUTTONS);
        }

        softAssert.assertAll();

    }
}
