package com.Steps;

import com.pages.MainPage;
import com.pages.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/16/2017.
 */
public class SearchResultSteps extends ScenarioSteps {
    MainPage mainPage;
    SearchResultPage searchResultPage;

    @StepGroup
    public void checkIfSearchResultRetainsTheSearchTerm(String searchTerm){
        mainPage.searchForTerm(searchTerm);
        searchResultPage.checkIfSearchResultRetainsTheSearchTerm(searchTerm);
    }

    @StepGroup
    public void compareSearchListedItemsToNumberOfSearchResults(String searchTerm){
        mainPage.searchForTerm(searchTerm);
        searchResultPage.compareResultsListedAgainstSearchResultsCounter();
    }
}
