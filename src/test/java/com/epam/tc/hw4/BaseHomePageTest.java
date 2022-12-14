package com.epam.tc.hw4;

import static com.epam.tc.hw3.Constants.TITLE_HOME_PAGE;

import com.epam.tc.hw4.driver.DriverSingelton;
import com.epam.tc.hw4.model.User;
import com.epam.tc.hw4.page.LoginPage;
import com.epam.tc.hw4.page.MainPage;
import com.epam.tc.hw4.service.UserCreator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseHomePageTest {
    public WebDriver webDriver;
    public SoftAssert softAssert;
    public LoginPage loginPage;
    public MainPage mainPage;
    public User someUser;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        webDriver = DriverSingelton.getWebDriver();
        softAssert = new SoftAssert();
        loginPage = new LoginPage(webDriver);
        someUser = UserCreator.withCredentialsFromProperty();

        //1. Open test site by URL
        loginPage.openPage();

        //2. Assert Browser title
        softAssert.assertTrue(loginPage.getPageTitle().contains(TITLE_HOME_PAGE.get()));

        //3. Perform login
        mainPage = loginPage.login(someUser);


        //4. Assert Username is loggined
        softAssert.assertTrue(mainPage.fullUserName().isDisplayed());
        softAssert.assertEquals(mainPage.getUserName(), Constants.USER_FULL_NAME.get());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverSingelton.closeWebDriver();
    }
}
