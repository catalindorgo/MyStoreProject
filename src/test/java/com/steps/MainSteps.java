package com.steps;

import com.pages.MainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/14/2017.
 */
public class MainSteps extends ScenarioSteps {
    MainPage mainPage;

    @Step
    public void checkLogoPresence(){
        mainPage.checkLogoPresence();
    }

    @Step
    public void checkShoppingChartPresence(){
        mainPage.checkShoppingChartPresence();}

    @Step
    public void checkElementsPresenceFromWomenDropDown(){
        mainPage.checkElementsPresenceFromWomenDropDown();
    }

    @Step
    public void checkElementsPresenceFromDressesDropDown(){
        mainPage.checkElementsPresenceFromDressesDropDown();
    }

    @Step
    public void checkTShirtElementPresence(){
        mainPage.checkTShirtElementPresence();
    }

    @Step
    public void checkBannersPresence(){
        mainPage.checkBannersPresence();
    }

    @Step
    public void checkPopularAndBestSellersSectionsPresence(){mainPage.checkPopularAndBestSellersSectionsPresence();}

    @Step
    public void searchForTerm(String searchTerm){
        mainPage.searchForTerm(searchTerm);
    }

    @Step
    public void clickOnWomenSectionAndVerifyLandingPageBreadCrumb(){
        mainPage.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
    }
    @Step
    public void clickOnDressesSectionAndVerifyLandingPageBreadCrumb(){
        mainPage.clickOnDressesSectionAndVerifyLandingPageBreadCrumb();
    }

    @Step
    public void clickTShirtSection(){
        mainPage.clickTShirtSectionAndVerifyLandingPageBreadCrumb();
    }

    @Step
    public void selectBlousesSubSection(){
        mainPage.selectBlousesSubSection();
    }
    @Step
    public void selectTShirtSubSection(){
        mainPage.selectTShirtSubSection();
    }

    @Step
    public void selectCasualDressesSubSectionFromDresses(){
        mainPage.selectCasualDressesSubSectionFromDresses();
    }
}
