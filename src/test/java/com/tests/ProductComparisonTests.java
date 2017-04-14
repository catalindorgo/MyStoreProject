package com.tests;

import com.steps.CatalogSteps;
import com.steps.MainSteps;
import com.steps.ProductComparisonSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 4/13/2017.
 */

@RunWith(SerenityRunner.class)
public class ProductComparisonTests {

    @Managed(uniqueSession = true)
    WebDriver webDriver;

    @Steps
    MainSteps mainSteps;
    @Steps
    CatalogSteps catalogSteps;
    @Steps
    ProductComparisonSteps productComparisonSteps;

    @Before
    public void launchApplicationHomePageInFireFoxBrowser(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void addTwoProductsToComparisonBasketAndContinueShopping(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.viewProductsAsListAndVerifyTheListingStyleIsApplied();
        catalogSteps.addTwoProductsToCompareBasketAndVerifyIfTheyAreAddedUp("Blouse", "Faded Short Sleeve T-shirts");
        catalogSteps.clickTheCompareButtonAndVerifyLandingPage();
        productComparisonSteps.clickContinueShoppingButtonAndVerifyLandingPage();

    }
}
