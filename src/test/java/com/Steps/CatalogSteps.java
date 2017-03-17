package com.Steps;

import com.pages.CatalogPage;
import com.pages.MainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by catalindorgo on 3/15/2017.
 */
public class CatalogSteps extends ScenarioSteps {
    MainPage mainPage;
    CatalogPage catalogPage;

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
    public void checkWomenProductListIsCorrectlySortedByPriceLowToHigh(){
        mainPage.clickOnWomenSection();
        catalogPage.sortByPriceLowToHigh();
        catalogPage.checkIfProductsAreSoretedByPriceLowToHigh();
    }
}
