package com.steps;

import com.pages.CatalogPage;
import com.pages.GeneralMethods;
import com.pages.MainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/15/2017.
 */
public class CatalogSteps extends ScenarioSteps {
    CatalogPage catalogPage;

    @Step
    public void checkWomenPagesTitleAndBannerAndListedItems(){
        catalogPage.checkWomenPageTitleAndBannerAndListedItems();
    }

    @Step
    public void checkDressesPagesTitleAndBannerAndListedItems(){
        catalogPage.checkDressesPageTitleAndBannerAndListedItems();
    }

    @Step
    public void checkTShirtTitleAndBannerAndListedItems(){
        catalogPage.checkTShirtTitleAndBannerAndListedItems();
    }

    @Step
    public void checkBlousesSubsectionsTitleBannerAndListedItmes(){
        catalogPage.checkBlousesSubsectionsTitleBannerAndListeItmes();
    }
    @Step
    public void checkTShirtSubSectionTitleBannerAndListedItems(){
        catalogPage.checkTShirtSubsectionsTitleBannerAndListeItmes();
    }
    @Step
    public void checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems(){
        catalogPage.checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems();
    }

    @StepGroup
    public void checkWomenProductListIsCorrectlySortedByPriceLowToHigh(String sortByOption){
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductsAreSoretedByPriceLowToHigh(sortByOption);
    }

    @StepGroup
    public void checkWomenProductListIsCorrectlySortedByPriceHighToLow(String sortByOption) {
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductsAreSoretedByPriceHighToLow(sortByOption);
    }
    @StepGroup
    public void checkIfWomenProductsAreInStock(String sortByOption){
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductIsInStock();
    }
    @StepGroup
    public void checkIfWomenProductsAreSortedAlphabeticallyAtoZ(String sortByOption){
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductsAreSortedAlphabeticallyAtoZ();
    }
    @StepGroup
    public void checkIfWomenProductsAreSortedAlphabeticallyZtoA(String sortByOption){
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductsAreSortedAlphabeticallyZtoA();
    }

    @Step
    public void clickCatalogCheckboxFromWomenSectionAndVerifyFiltering(String checkboxName){
        catalogPage.clickCatalogCheckbox(checkboxName);
    }

    @Step
    public void clickColorCheckboxFromWomenSectionAndVerifyFiltering(String colorCheckbox){
        catalogPage.clickColorCheckbox(colorCheckbox);
    }

    @Step
    public void viewProductsAsList(){
        catalogPage.viewProductsAsList();
    }

    @Step
    public void addProductToCart(String productIndex){
        catalogPage.addProductToCart(productIndex);
    }

    @Step
    public void quickViewProduct(String prodcutIndex){
        catalogPage.quickViewProduct(prodcutIndex);
    }
}
