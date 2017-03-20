package com.Tests;

import com.Steps.CatalogSteps;
import com.pages.CatalogPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
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

    @Test
    public void navigateToWomenSectionAndCheckLandingPage(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        catalogSteps.checkWomenPagesTitleAndBannerAndListedItems();
    }

    @Test
    public void checkDressesPagesTitleAndBannerAndListedItems(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        catalogSteps.checkDressesPagesTitleAndBannerAndListedItems();
    }
    @Test
    public void checkTShirtTitleAndBannerAndListedItems(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        catalogSteps.checkTShirtTitleAndBannerAndListedItems();
    }

    @Test
    public void checkBlousesSubsectionsTitleBannerAndListeItmes(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        catalogSteps.checkBlousesSubsectionsTitleBannerAndListedItmes();
    }
    @Test
    public void checkTShirtSubSectionTitleBannerAndListedItems(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        catalogSteps.checkTShirtSubSectionTitleBannerAndListedItems();
    }
    @Test
    public void checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        catalogSteps.checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems();
    }
// Testul de mai jos crapa.
    @Test
    public void checkWomenProductListIsCorrectlySortedByPriceLowToHigh(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        catalogSteps.checkWomenProductListIsCorrectlySortedByPriceLowToHigh("Price: Lowest first");
    }
}
