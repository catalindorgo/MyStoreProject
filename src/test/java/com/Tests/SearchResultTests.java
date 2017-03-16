package com.Tests;

import com.Steps.SearchResultSteps;
import com.pages.SearchResultPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
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

    @Test
    public void checkIfSearchResultRetainsTheSearchTerm(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        searchResultSteps.checkIfSearchResultRetainsTheSearchTerm("SUMMER");
    }
//IN PROGRESS - below test does not work yet since the Char that I;m getting in the Page Method seems not to be the first in the list since the HTML is written badly
    //check the xpath for the SearchResultCounter and check the text format in console.
    @Test
    public void compareSearchListedItemsToNumberOfSearchResults(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        searchResultSteps.compareSearchListedItemsToNumberOfSearchResults("Summer");
    }
}
