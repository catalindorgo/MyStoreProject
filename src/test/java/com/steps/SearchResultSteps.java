package com.steps;

import com.pages.MainPage;
import com.pages.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/16/2017.
 */
public class SearchResultSteps extends ScenarioSteps {

    SearchResultPage searchResultPage;

    @Step
    public void checkIfSearchResultRetainsTheSearchTerm(String searchTerm){
        searchResultPage.checkIfSearchResultRetainsTheSearchTerm(searchTerm);
    }

    @Step
    public void compareSearchListedItemsToNumberOfSearchResults(){
        searchResultPage.compareResultsListedAgainstSearchResultsCounter();
    }
    @Step
    public void checkErrorMessageIsDisplayedForNoResultsSearch(){
        searchResultPage.checkErrorMessageForIncorrectSearch();
    }
}
