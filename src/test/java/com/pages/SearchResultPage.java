package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by catalindorgo on 3/16/2017.
 */
public class SearchResultPage extends PageObject {

    @FindBy(xpath = ".//h1/span[@class='lighter']")
    private WebElement searchResultTerm;

    @FindBy(xpath = ".//h1/span[@class='heading-counter']")
    private WebElement searchResultsCounter;

    @FindBy(xpath = ".//ul/li[contains(@class, 'product')]")
    private List<WebElement> listOfSearchResults;

    @FindBy(xpath = "//div/p[contains(text(), 'No results')]")
    private WebElement noSearchResultsErrorMessage;

    public void checkIfSearchResultRetainsTheSearchTerm(String searchTerm){
        Assert.assertTrue("The term you have searched for does not fit with the 'search result term'", searchResultTerm.getText().contains(searchTerm));
    }

    public void compareResultsListedAgainstSearchResultsCounter(){
        String productCounterString = searchResultsCounter.getText();
        char productCounterChar = productCounterString.charAt(0);
        int productCounter = Character.getNumericValue(productCounterChar);

        Assert.assertTrue("Nr of listed search results is not equal to the Search result counter", productCounter==listOfSearchResults.size());
        }
    public void checkErrorMessageForIncorrectSearch(){
        noSearchResultsErrorMessage.isDisplayed();
    }
}
