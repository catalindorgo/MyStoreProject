package com.tests;

import com.steps.MainSteps;
import com.steps.SearchResultSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 3/16/2017.
 */
@RunWith(SerenityRunner.class)
public class SearchResultTests {
    @Managed(uniqueSession = true)
    WebDriver webDriver;

    @Steps
    SearchResultSteps searchResultSteps;
    @Steps
    MainSteps mainSteps;

    @Before
    public void launchApplicationHomePageInFireFoxBrowser(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void checkIfSearchResultRetainsTheSearchTerm(){
        mainSteps.searchForTerm("SUMMER");
        searchResultSteps.checkIfSearchResultRetainsTheSearchTerm("summer");
    }

    @Test
    public void compareSearchListedItemsToNumberOfSearchResults(){
        mainSteps.searchForTerm("Summer");
        searchResultSteps.compareSearchListedItemsToNumberOfSearchResults();
    }

    @Test
    public void checkErrorMessageIsDisplayedForNoResultsSearch(){
        mainSteps.searchForTerm("ErrorMessage");
        searchResultSteps.checkErrorMessageIsDisplayedForNoResultsSearch();
    }
}
