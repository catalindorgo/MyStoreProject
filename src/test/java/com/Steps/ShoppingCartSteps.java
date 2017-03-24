package com.Steps;

import com.pages.CartPopUpPage;
import com.pages.CatalogPage;
import com.pages.MainPage;
import com.pages.ShoppingCartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/23/2017.
 */
public class ShoppingCartSteps extends ScenarioSteps {
    ShoppingCartPage shoppingCartPage;
    MainPage mainPage;
    CatalogPage catalogPage;
    CartPopUpPage cartPopUpPage;

    @StepGroup
    public void addProductToCartAndCheckIfPresentInShoppingSummary(String productIndex){
        mainPage.clickOnWomenSection();
        catalogPage.viewProductsAsList();
        catalogPage.addProductToCart(productIndex);
        cartPopUpPage.clickProceedToCheckout();
        shoppingCartPage.checkIfProductIsSuccessfullyAddedToShoppingChartSummary(productIndex);
    }

    @StepGroup
    public void checkAddressPageDetailsAreCorrect(String productIndex,  String userMobileNumber){
        mainPage.clickOnWomenSection();
        catalogPage.viewProductsAsList();
        catalogPage.addProductToCart(productIndex);
        cartPopUpPage.clickProceedToCheckout();
        shoppingCartPage.checkIfProductIsSuccessfullyAddedToShoppingChartSummary(productIndex);
        shoppingCartPage.clickProceedToCheckOutButtonSummaryTab();
        shoppingCartPage.checkAddressPageDetailsAreCorrect( userMobileNumber);
    }
    @StepGroup
    public void checkShippingPageDetailsAreCorrect(String productIndex,  String userMobileNumber){
        mainPage.clickOnWomenSection();
        catalogPage.viewProductsAsList();
        catalogPage.addProductToCart(productIndex);
        cartPopUpPage.clickProceedToCheckout();
        shoppingCartPage.checkIfProductIsSuccessfullyAddedToShoppingChartSummary(productIndex);
        shoppingCartPage.clickProceedToCheckOutButtonSummaryTab();
        shoppingCartPage.checkAddressPageDetailsAreCorrect( userMobileNumber);
        shoppingCartPage.clickProceedToCheckOutButton();
        shoppingCartPage.checkShippingPageUIElemnts();
    }

    @StepGroup
    public void checkPaymentDetailsAreCorrect(String productIndex,  String userMobileNumber){
        mainPage.clickOnWomenSection();
        catalogPage.viewProductsAsList();
        catalogPage.addProductToCart(productIndex);
        cartPopUpPage.clickProceedToCheckout();
        shoppingCartPage.checkIfProductIsSuccessfullyAddedToShoppingChartSummary(productIndex);
        shoppingCartPage.clickProceedToCheckOutButtonSummaryTab();
        shoppingCartPage.checkAddressPageDetailsAreCorrect( userMobileNumber);
        shoppingCartPage.clickProceedToCheckOutButton();
        shoppingCartPage.checkShippingPageUIElemnts();
        shoppingCartPage.clickTheAgreeToTermsButton();
        shoppingCartPage.clickProceedToCheckOutButton();
        shoppingCartPage.checkPaymentPageDetailsAreCorrect();
    }

    @StepGroup
    public void buyAProductCompleteTestFlow(String productIndex,  String userMobileNumber){
        mainPage.clickOnWomenSection();
        catalogPage.viewProductsAsList();
        catalogPage.addProductToCart(productIndex);
        cartPopUpPage.clickProceedToCheckout();
        shoppingCartPage.checkIfProductIsSuccessfullyAddedToShoppingChartSummary(productIndex);
        shoppingCartPage.clickProceedToCheckOutButtonSummaryTab();
        shoppingCartPage.checkAddressPageDetailsAreCorrect( userMobileNumber);
        shoppingCartPage.clickProceedToCheckOutButton();
        shoppingCartPage.checkShippingPageUIElemnts();
        shoppingCartPage.clickTheAgreeToTermsButton();
        shoppingCartPage.clickProceedToCheckOutButton();
        shoppingCartPage.checkPaymentPageDetailsAreCorrect();
        shoppingCartPage.clickPayByBankWire();
        shoppingCartPage.clickConfirmOrderAndCheckCompleteMessage();


    }
}
