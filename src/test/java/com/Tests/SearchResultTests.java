package com.Tests;

import com.Steps.SearchResultSteps;
import com.pages.SearchResultPage;
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

    @Before
    public void launchFireFox(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void checkIfSearchResultRetainsTheSearchTerm(){
        searchResultSteps.checkIfSearchResultRetainsTheSearchTerm("SUMMER");
    }
    @Test
    public void compareSearchListedItemsToNumberOfSearchResults(){
        searchResultSteps.compareSearchListedItemsToNumberOfSearchResults("Summer");
    }
    @Test
    public void checkErrorMessageIsDisplayedForNoResultsSearch(){
        searchResultSteps.checkErrorMessageIsDisplayedForNoResultsSearch("ErrorTerm");
    }
}
