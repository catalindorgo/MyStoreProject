package com.Steps;

import com.pages.CatalogPage;
import com.pages.GeneralMethods;
import com.pages.MainPage;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/15/2017.
 */
public class CatalogSteps extends ScenarioSteps {
    MainPage mainPage;
    CatalogPage catalogPage;
    GeneralMethods generalMethods;

    @StepGroup
    public void checkWomenPagesTitleAndBannerAndListedItems(){
        mainPage.clickOnWomenSection();
        catalogPage.checkWomenPageTitleAndBannerAndListedItems();
    }

    @StepGroup
    public void checkDressesPagesTitleAndBannerAndListedItems(){
        mainPage.clickOnDressesSection();
        catalogPage.checkDressesPageTitleAndBannerAndListedItems();
    }

    @StepGroup
    public void checkTShirtTitleAndBannerAndListedItems(){
        mainPage.clickTShirtSection();
        catalogPage.checkTShirtTitleAndBannerAndListedItems();
    }

    @StepGroup
    public void checkBlousesSubsectionsTitleBannerAndListedItmes(){
        mainPage.selectBlousesSubSection();
        catalogPage.checkBlousesSubsectionsTitleBannerAndListeItmes();
    }
    @StepGroup
    public void checkTShirtSubSectionTitleBannerAndListedItems(){
        mainPage.selectTShirtSubSection();
        catalogPage.checkTShirtSubsectionsTitleBannerAndListeItmes();
    }
    @StepGroup
    public void checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems(){
        mainPage.selectCasualDressesSubSectionFromDresses();
        catalogPage.checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems();
    }

    @StepGroup
    public void checkWomenProductListIsCorrectlySortedByPriceLowToHigh(String sortByOption){
        mainPage.clickOnWomenSection();
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductsAreSoretedByPriceLowToHigh(sortByOption);
    }

    @StepGroup
    public void checkWomenProductListIsCorrectlySortedByPriceHighToLow(String sortByOption) {
        mainPage.clickOnWomenSection();
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductsAreSoretedByPriceHighToLow(sortByOption);
    }
    @StepGroup
    public void checkIfWomenProductsAreInStock(String sortByOption){
        mainPage.clickOnWomenSection();
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductIsInStock();
    }
    @StepGroup
    public void checkIfWomenProductsAreSortedAlphabeticallyAtoZ(String sortByOption){
        mainPage.clickOnWomenSection();
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductsAreSortedAlphabeticallyAtoZ();
    }
    @StepGroup
    public void checkIfWomenProductsAreSortedAlphabeticallyZtoA(String sortByOption){
        mainPage.clickOnWomenSection();
        catalogPage.sortByUserOption(sortByOption);
        catalogPage.checkIfProductsAreSortedAlphabeticallyZtoA();
    }

    @StepGroup
    public void clickCatalogCheckboxFromWomenSectionAndVerifyFiltering(String checkboxName){
        mainPage.clickOnWomenSection();
        catalogPage.clickCatalogCheckbox(checkboxName);
    }

    @StepGroup
    public void clickColorCheckboxFromWomenSectionAndVerifyFiltering(String colorCheckbox){
        mainPage.clickOnWomenSection();
        catalogPage.clickColorCheckbox(colorCheckbox);
    }
}
