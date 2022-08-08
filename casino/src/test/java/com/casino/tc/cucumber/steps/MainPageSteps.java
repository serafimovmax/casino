package com.casino.tc.cucumber.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainPageSteps extends AbstractBaseStep{


//    @When("I click dropdown User button")
//    public void iClickDropdownUserButton() {
//        mainPage.clickUsersButtons();
//    }

    @When("I click Players button")
    public void iClickPlayersButton() {
        mainPage.clickPlayersButton();
    }

    @When("The list of players is displayed")
    public void theListOfPlayersIsDisplayed() {
        mainPage.listOfPlayersIsDisplayed();
    }
}
