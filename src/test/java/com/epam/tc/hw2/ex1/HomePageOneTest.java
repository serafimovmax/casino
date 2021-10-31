package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseHomePageTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageOneTest extends BaseHomePageTest {

    @Test
    public void homePageOneTest() {

        //5. Assert menu buttons are displayed
        softAssert.assertEquals(webDriver.findElement(By.linkText("Home"))
                                         .getText(), "Home");
        softAssert.assertEquals(webDriver.findElement(By.linkText("Home"))
                                         .isDisplayed(), true);

        softAssert.assertEquals(webDriver.findElement(By.linkText("Contact form"))
                                         .getText(), "Contact form");
        softAssert.assertEquals(webDriver.findElement(By.linkText("Contact form"))
                                         .isDisplayed(), true);

        softAssert.assertEquals(webDriver.findElement(By.linkText("Service"))
                                         .getText(), "Service");
        softAssert.assertEquals(webDriver.findElement(By.linkText("Service"))
                                         .isDisplayed(), true);

        softAssert.assertEquals(webDriver.findElement(By.linkText("Metals & Colors"))
                                         .getText(), "Metals & Colors");
        softAssert.assertEquals(webDriver.findElement(By.linkText("Metals & Colors"))
                                         .isDisplayed(), true);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imgIndex = webDriver.findElements(By.xpath("//div[@class='benefit-icon']"));
        for (WebElement img : imgIndex) {
            softAssert.assertTrue(img.isDisplayed());
        }

        //7. Assert that texts are displayed and equal to expected
        List<WebElement> imgText = webDriver.findElements(By.xpath(("//span[@class='benefit-txt']")));
        for (WebElement textImage : imgText) {
            softAssert.assertTrue(textImage.isDisplayed());
        }
        softAssert.assertEquals(imgText.get(0).getText(), "To include good practices\n"
            + "and ideas from successful\nEPAM project");
        softAssert.assertEquals(imgText.get(1).getText(), "To be flexible and\ncustomizable");
        softAssert.assertEquals(imgText.get(2).getText(), "To be multiplatform");
        softAssert.assertEquals(imgText.get(3).getText(), "Already have good base\n"
            + "(about 20 internal and\nsome external projects),\nwish to get more…");

        //8. Assert that the iframe exists
        softAssert.assertTrue(webDriver.findElement(By.id("frame")).isDisplayed());

        //9. Assert that the “Frame Button” exists
        webDriver.switchTo().frame("frame");
        softAssert.assertTrue(webDriver.findElement(By.id("frame-button")).isDisplayed());

        //10. Assert that driver has focus on the original window
        webDriver.switchTo().parentFrame();

        //11. Assert that left section menu items are displayed and have proper text
        List<WebElement> leftSelection = webDriver.findElements(By.id("mCSB_1"));
        for (WebElement leftElement : leftSelection) {
            softAssert.assertTrue(leftElement.isDisplayed());
        }
        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[text()='Home']"))
                                         .getText(), "Home");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[text()='Contact form']"))
                                         .getText(), "Contact form");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[text()='Service']"))
                                         .getText(), "Service");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[text()='Metals & Colors']"))
                                         .getText(), "Metals & Colors");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[text()='Elements packs']"))
                                         .getText(), "Elements packs");

        softAssert.assertAll();

    }
}
