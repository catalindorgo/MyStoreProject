package com.tests;

import com.steps.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 3/23/2017.
 */
@RunWith(SerenityRunner.class)
public class ShoppingCartTests {
    @Managed (uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    ShoppingCartSteps shoppingCartSteps;
    @Steps
    AuthenticationSteps authenticationSteps;
    @Steps
    MainSteps mainSteps;
    @Steps
    CatalogSteps catalogSteps;
    @Steps
    CartPopUpSteps cartPopUpSteps;
    @Steps
    ToolBarSteps toolBarSteps;

    @Before
    public void userLogIn(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        toolBarSteps.clickSignInButtonAndVerifyLandingPage();
        authenticationSteps.logInAndVerifyAccount("admin@yahoo.ro", "password", "Admin lastName");
    }

    @Test
    public void addProductToCartAndCheckIfPresentInShoppingSummary(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.viewProductsAsListAndVerifyTheListingStyleIsApplied();
        catalogSteps.addProductToCart("Faded Short Sleeve T-shirts");
        cartPopUpSteps.clickProceedToCheckout();
        shoppingCartSteps.checkIfProductIsSuccessfullyAddedToShoppingChartSummary("Faded Short Sleeve T-shirts");
    }

    @Test
    public void addProductToCartAndCheckAddressPageDetailsAreCorrect(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.viewProductsAsListAndVerifyTheListingStyleIsApplied();
        catalogSteps.addProductToCart("Faded Short Sleeve T-shirts");
        cartPopUpSteps.clickProceedToCheckout();
        shoppingCartSteps.checkAddressPageDetailsAreCorrect("Faded Short Sleeve T-shirts", "7432221");
    }

    @Test
    public void addProductToCartAndCheckShippingPageDetailsAreCorrect(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.viewProductsAsListAndVerifyTheListingStyleIsApplied();
        catalogSteps.addProductToCart("Faded Short Sleeve T-shirts");
        cartPopUpSteps.clickProceedToCheckout();
        shoppingCartSteps.checkShippingPageDetailsAreCorrect("Faded Short Sleeve T-shirts", "7432221");
    }
    @Test
    public void addProductToCartAndCheckPaymentDetailsAreCorrect(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.viewProductsAsListAndVerifyTheListingStyleIsApplied();
        catalogSteps.addProductToCart("Faded Short Sleeve T-shirts");
        cartPopUpSteps.clickProceedToCheckout();
        shoppingCartSteps.checkPaymentDetailsAreCorrect("Faded Short Sleeve T-shirts","7432221");
    }

    @Test
    public void buyAProductCompleteTestFlow(){
        mainSteps.clickOnWomenSectionAndVerifyLandingPageBreadCrumb();
        catalogSteps.viewProductsAsListAndVerifyTheListingStyleIsApplied();
        catalogSteps.addProductToCart("Faded Short Sleeve T-shirts");
        cartPopUpSteps.clickProceedToCheckout();
        shoppingCartSteps.buyAProductCompleteTestFlow("Faded Short Sleeve T-shirts","7432221" );
    }
}
