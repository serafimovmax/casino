package com.casino.ui.cucumber.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainPageSteps extends AbstractBaseStep{

    @When("I click Players button")
    public void iClickPlayersButton() {
        mainPage.clickPlayersButton();
    }

    @When("The list of players is displayed")
    public void theListOfPlayersIsDisplayed() {
        mainPage.listOfPlayersIsDisplayed();
    }

    @When("I click External ID button")
    public void iClickExternalIdButton() {
        mainPage.iClickExternalIdButton();
    }

    @Then("External ID column is sorted")
    public void externalIDColumnIsSorted() {
        List<String> one = mainPage.getExternalIdList();
        List<String> two = one.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        assertThat(one.equals(two));
    }
}
