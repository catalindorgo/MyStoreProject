package com.tests;

import com.steps.CatalogSteps;
import com.steps.MainSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 3/15/2017.
 */
@RunWith(SerenityRunner.class)
public class CatalogTests {
    @Managed(uniqueSession = true)
    WebDriver webDriver;
    @Steps
    MainSteps mainSteps;
    @Steps
    CatalogSteps catalogSteps;

    @Before
    public void launchFireFox(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void navigateToWomenSectionAndCheckLandingPage(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
    }

    @Test
    public void checkDressesPagesTitleAndBannerAndListedItems(){
        mainSteps.clickOnDressesSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.checkIfPageTitleBannerAndListedItemsAreCorrectlyDisplayed();
    }
    @Test
    public void checkTShirtTitleAndBannerAndListedItems(){
        mainSteps.clickTShirtSection();
        catalogSteps.checkIfPageTitleBannerAndListedItemsAreCorrectlyDisplayed();
    }

    @Test
    public void checkBlousesSubsectionsTitleBannerAndListeItmes(){
        mainSteps.selectBlousesSubSection();
        catalogSteps.checkIfPageTitleBannerAndListedItemsAreCorrectlyDisplayed();
    }
    @Test
    public void checkTShirtSubSectionTitleBannerAndListedItems(){
        mainSteps.selectTShirtSubSection();
        catalogSteps.checkIfPageTitleBannerAndListedItemsAreCorrectlyDisplayed();
    }
    @Test
    public void checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems(){
        mainSteps.selectCasualDressesSubSectionFromDresses();
        catalogSteps.checkIfPageTitleBannerAndListedItemsAreCorrectlyDisplayed();
    }

    @Test
    public void checkWomenProductListIsCorrectlySortedByPriceLowToHigh(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.checkIfProductListIsCorrectlySortedByPriceLowToHigh("Price: Lowest first");
    }

    @Test
    public void checkWomenProductListIsCorrectlySortedByPriceHighToLow(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.checkIfProductListIsCorrectlySortedByPriceHighToLow("Price: Highest first");
    }

    @Test
    public void checkIfWomenProductsAreInStock(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.checkIfProductsAreInStock("In stock");
    }

    @Test
    public void checkIfWomenProductsAreSortedAlphabeticallyAtoZ(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.checkIfProductsAreSortedAlphabeticallyAtoZ("Product Name: A to Z");
    }
    @Test
    public void checkIfWomenProductsAreSortedAlphabeticallyZtoA(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.checkIfProductsAreSortedAlphabeticallyZtoA("Product Name: Z to A");
    }

    @Test
    public void clickCatalogCheckboxFromWomenSectionAndVerifyFiltering(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.clickACatalogCheckboxAndVerifyFilteringIsApplied("Tops");
    }

    @Test
    public void clickColorCheckboxFromWomenSectionAndVerifyFiltering(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.clickColorCheckboxAndVerifyFiltering("Yellow");
    }
}
