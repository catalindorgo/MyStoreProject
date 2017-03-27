package com.Tests;

import com.Steps.CatalogSteps;
import com.pages.CatalogPage;
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
    CatalogSteps catalogSteps;

    @Before
    public void launchFireFox(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void navigateToWomenSectionAndCheckLandingPage(){
        catalogSteps.checkWomenPagesTitleAndBannerAndListedItems();
    }

    @Test
    public void checkDressesPagesTitleAndBannerAndListedItems(){
        catalogSteps.checkDressesPagesTitleAndBannerAndListedItems();
    }
    @Test
    public void checkTShirtTitleAndBannerAndListedItems(){
        catalogSteps.checkTShirtTitleAndBannerAndListedItems();
    }

    @Test
    public void checkBlousesSubsectionsTitleBannerAndListeItmes(){
        catalogSteps.checkBlousesSubsectionsTitleBannerAndListedItmes();
    }
    @Test
    public void checkTShirtSubSectionTitleBannerAndListedItems(){
        catalogSteps.checkTShirtSubSectionTitleBannerAndListedItems();
    }
    @Test
    public void checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems(){
        catalogSteps.checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems();
    }
// Testul de mai jos NU MAI crapa.
    @Test
    public void checkWomenProductListIsCorrectlySortedByPriceLowToHigh(){
        catalogSteps.checkWomenProductListIsCorrectlySortedByPriceLowToHigh("Price: Lowest first");
    }

    @Test
    public void checkWomenProductListIsCorrectlySortedByPriceHighToLow(){
        catalogSteps.checkWomenProductListIsCorrectlySortedByPriceHighToLow("Price: Highest first");
    }

    @Test
    public void checkIfWomenProductsAreInStock(){
        catalogSteps.checkIfWomenProductsAreInStock("In stock");
    }

    @Test
    public void checkIfWomenProductsAreSortedAlphabeticallyAtoZ(){
        catalogSteps.checkIfWomenProductsAreSortedAlphabeticallyAtoZ("Product Name: A to Z");
    }
    @Test
    public void checkIfWomenProductsAreSortedAlphabeticallyZtoA(){
        catalogSteps.checkIfWomenProductsAreSortedAlphabeticallyZtoA("Product Name: Z to A");
    }

    @Test
    public void clickCatalogCheckboxFromWomenSectionAndVerifyFiltering(){
        catalogSteps.clickCatalogCheckboxFromWomenSectionAndVerifyFiltering("Tops");
    }

    @Test
    public void clickColorCheckboxFromWomenSectionAndVerifyFiltering(){
        catalogSteps.clickColorCheckboxFromWomenSectionAndVerifyFiltering("Yellow");
    }
}
