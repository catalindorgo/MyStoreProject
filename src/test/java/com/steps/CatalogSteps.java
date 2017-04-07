package com.steps;

import com.pages.CatalogPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/15/2017.
 */
public class CatalogSteps extends ScenarioSteps {
    CatalogPage catalogPage;

    @Step
    public void checkIfPageTitleBannerAndListedItemsAreCorrectlyDisplayed(){
        catalogPage.checkIfProductIsInStock();
    }

    @StepGroup
    public void checkIfProductListIsCorrectlySortedByPriceLowToHigh(String sortByOption){
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductsAreSoretedByPriceLowToHigh(sortByOption);
    }

    @StepGroup
    public void checkIfProductListIsCorrectlySortedByPriceHighToLow(String sortByOption) {
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductsAreSoretedByPriceHighToLow(sortByOption);
    }
    @StepGroup
    public void checkIfProductsAreInStock(String sortByOption){
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductIsInStock();
    }
    @StepGroup
    public void checkIfProductsAreSortedAlphabeticallyAtoZ(String sortByOption){
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductsAreSortedAlphabeticallyAtoZ();
    }
    @StepGroup
    public void checkIfProductsAreSortedAlphabeticallyZtoA(String sortByOption){
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductsAreSortedAlphabeticallyZtoA();
    }

    @Step
    public void clickACatalogCheckboxAndVerifyFilteringIsApplied(String checkboxName){
        catalogPage.clickACatalogCheckboxAndVerifyFilteringIsApplied(checkboxName);
    }

    @Step
    public void clickColorCheckboxAndVerifyFiltering(String colorCheckbox){
        catalogPage.clickColorCheckboxAndVerifyFilteringIsApplied(colorCheckbox);
    }

    @Step
    public void viewProductsAsList(){
        catalogPage.viewProductsAsList();
    }

    @Step
    public void addProductToCart(String productTitle){
        catalogPage.addProductToCart(productTitle);
    }

    @Step
    public void quickViewProduct(String productTitle){
        catalogPage.quickViewProduct(productTitle);
    }

    @Step
    public void switchToQuickViewPopUp(){
        catalogPage.switchToQuickViewPopUp();
    }
}
