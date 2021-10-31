package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseHomePageTest {
    protected WebDriver webDriver;
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                 .implicitlyWait(10L, TimeUnit.SECONDS);

        //1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        //3. Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();

        //4. Assert Username is loggined
        softAssert.assertEquals(webDriver.findElement(By.id("user-name"))
                                         .getText(), "ROMAN IOVLEV");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        webDriver.quit();
    }
}
