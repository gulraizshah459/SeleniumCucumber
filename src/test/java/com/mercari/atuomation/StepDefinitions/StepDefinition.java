package com.mercari.atuomation.StepDefinitions;

import com.mercari.atuomation.PagesRepo.SearchRepo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static DriverManager.DriverFactory.driverCreated;


public class StepDefinition {
    public SearchRepo searchRepo = new SearchRepo(driverCreated);

    @Given("the user is on the Mercari top page {string}")
    public void user_go_to_mercari_top_page(String webURL) {
        driverCreated.get(webURL);
    }
    @When("the user clicks on the search bar")
    public void user_click_on_the_search_bar() {
        searchRepo.clickOnSearchField();
    }
    @Then("the user clicks on {string}")
    public void user_click_on(String text) {
        searchRepo.clickOnText(text);
    }
    @Then("the search conditions on the left sidebar are set to {string}, {string}, and {string}")
    public void verify_the_search_conditions_on_the_left_sidebar_are_set_correctly_as_and_and(String condition1, String condition2, String condition3) {
        searchRepo.verifyCategoriesShouldBePresent(condition1,condition2,condition3);
    }
    @Then("there are {int} browsing history items")
    public void verify_there_are_browsing_histories(int countOfItems) {
        searchRepo.verifySearchHistoryListItems(countOfItems);
    }
    @Then("the latest browsing history item shows {string}")
    public void verify_the_latest_browsing_history_is_showing(String textToCheck) {
        searchRepo.verifyLatestBrowsingHistoryIsShowing(textToCheck);
    }

    @And("the user is on the search results page")
    public void userIsOnSearchScreen() {
        searchRepo.verifySearchScreenVisible();
    }

    @Then("the user navigates to the homepage")
    public void userGoToHomepage() {
        searchRepo.clickOnHomepage();
    }

    @Then("the user searches for {string}")
    public void userSearchFor(String text) {
        searchRepo.searchForText(text);
    }
}
