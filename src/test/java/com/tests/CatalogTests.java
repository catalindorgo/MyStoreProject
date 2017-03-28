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
        mainSteps.clickOnWomenSection();
        catalogSteps.checkWomenPagesTitleAndBannerAndListedItems();
    }

    @Test
    public void checkDressesPagesTitleAndBannerAndListedItems(){
        mainSteps.clickOnDressesSection();
        catalogSteps.checkDressesPagesTitleAndBannerAndListedItems();
    }
    @Test
    public void checkTShirtTitleAndBannerAndListedItems(){
        mainSteps.clickTShirtSection();
        catalogSteps.checkTShirtTitleAndBannerAndListedItems();
    }

    @Test
    public void checkBlousesSubsectionsTitleBannerAndListeItmes(){
        mainSteps.selectBlousesSubSection();
        catalogSteps.checkBlousesSubsectionsTitleBannerAndListedItmes();
    }
    @Test
    public void checkTShirtSubSectionTitleBannerAndListedItems(){
        mainSteps.selectTShirtSubSection();
        catalogSteps.checkTShirtSubSectionTitleBannerAndListedItems();
    }
    @Test
    public void checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems(){
        mainSteps.selectCasualDressesSubSectionFromDresses();
        catalogSteps.checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems();
    }
// Testul de mai jos NU MAI crapa.
    @Test
    public void checkWomenProductListIsCorrectlySortedByPriceLowToHigh(){
        mainSteps.clickOnWomenSection();
        catalogSteps.checkWomenProductListIsCorrectlySortedByPriceLowToHigh("Price: Lowest first");
    }

    @Test
    public void checkWomenProductListIsCorrectlySortedByPriceHighToLow(){
        mainSteps.clickOnWomenSection();
        catalogSteps.checkWomenProductListIsCorrectlySortedByPriceHighToLow("Price: Highest first");
    }

    @Test
    public void checkIfWomenProductsAreInStock(){
        mainSteps.clickOnWomenSection();
        catalogSteps.checkIfWomenProductsAreInStock("In stock");
    }

    @Test
    public void checkIfWomenProductsAreSortedAlphabeticallyAtoZ(){
        mainSteps.clickOnWomenSection();
        catalogSteps.checkIfWomenProductsAreSortedAlphabeticallyAtoZ("Product Name: A to Z");
    }
    @Test
    public void checkIfWomenProductsAreSortedAlphabeticallyZtoA(){
        mainSteps.clickOnWomenSection();
        catalogSteps.checkIfWomenProductsAreSortedAlphabeticallyZtoA("Product Name: Z to A");
    }

    @Test
    public void clickCatalogCheckboxFromWomenSectionAndVerifyFiltering(){
        mainSteps.clickOnWomenSection();
        catalogSteps.clickCatalogCheckboxFromWomenSectionAndVerifyFiltering("Tops");
    }

    @Test
    public void clickColorCheckboxFromWomenSectionAndVerifyFiltering(){
        mainSteps.clickOnWomenSection();
        catalogSteps.clickColorCheckboxFromWomenSectionAndVerifyFiltering("Yellow");
    }
}
