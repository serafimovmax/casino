package com.casino.tc.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Test for Log In Page")
@Story("Test for Log In as User")
public class LoginPageSteps extends AbstractBaseStep{

    @When("I login as user")
    public void iLoginAsUser() {
        mainPage = loginPage.login(testUser);
    }

    @Then("User is logged")
    public void isUserIsLogged() {
        assertThat(mainPage.checkLogoIsDisplayed());
    }

}
