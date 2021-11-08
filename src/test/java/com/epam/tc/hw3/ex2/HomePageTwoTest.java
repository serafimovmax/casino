package com.epam.tc.hw3.ex2;

import static com.epam.tc.hw3.PageElements.LOGS_TEXT;

import com.epam.tc.hw3.BaseHomePageTest;
import com.epam.tc.hw3.page.DifferentElementsPage;
import org.testng.annotations.Test;

public class HomePageTwoTest extends BaseHomePageTest {

    DifferentElementsPage diffElPage = new DifferentElementsPage(webDriver);

    @Test
    public void homePageOneTest() {

        //5. Open Page
        diffElPage.clickServiceButton();
        diffElPage.goToDifferentElementsPage();

        //6. Select checkboxes
        diffElPage.selectWaterCheckbox();
        diffElPage.selectWindCheckbox();

        //7. Select radio
        diffElPage.selectSelenRadio();

        //8. Select in dropdown
        diffElPage.clickDropdownColors();
        diffElPage.selectYellowColor();

        //9. Assert log rows
        softAssert.assertEquals(diffElPage.getLogsComponetText(), LOGS_TEXT);

        softAssert.assertAll();
    }
}
