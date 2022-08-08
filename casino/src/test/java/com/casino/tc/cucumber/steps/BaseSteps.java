package com.casino.tc.cucumber.steps;

import com.casino.tc.util.TestListener;
import com.casino.tc.util.TextsForComparison;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;

@Feature("Base Test Open Page")
@Story("Open page")
@Listeners(TestListener.class)
public class BaseSteps extends AbstractBaseStep {
    @Given("I open the login page")
    public void openWebsite() {
        loginPage.openPage();
    }

    @Then("Login page is opened")
    public void siteIsOpened() {
        Assertions.assertThat(loginPage.getUrl()).isEqualTo(URL);
        Assertions.assertThat(loginPage.getTitle()).contains(TextsForComparison.LOGIN_PAGE);
    }
}
