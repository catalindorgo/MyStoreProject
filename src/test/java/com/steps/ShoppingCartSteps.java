package com.steps;

import com.pages.CartPopUpPage;
import com.pages.CatalogPage;
import com.pages.MainPage;
import com.pages.ShoppingCartPage;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/23/2017.
 */
public class ShoppingCartSteps extends ScenarioSteps {
    ShoppingCartPage shoppingCartPage;

    @StepGroup
    public void addProductToCartAndCheckIfPresentInShoppingSummary(String productTitle){
        shoppingCartPage.checkIfProductIsSuccessfullyAddedToShoppingChartSummary(productTitle);
    }

    @StepGroup
    public void checkAddressPageDetailsAreCorrect(String productTitle,  String userMobileNumber){
        shoppingCartPage.checkIfProductIsSuccessfullyAddedToShoppingChartSummary(productTitle);
        shoppingCartPage.clickProceedToCheckOutButtonSummaryTab();
        shoppingCartPage.checkAddressPageDetailsAreCorrect( userMobileNumber);
    }
    @StepGroup
    public void checkShippingPageDetailsAreCorrect(String productTitle,  String userMobileNumber){
        shoppingCartPage.checkIfProductIsSuccessfullyAddedToShoppingChartSummary(productTitle);
        shoppingCartPage.clickProceedToCheckOutButtonSummaryTab();
        shoppingCartPage.checkAddressPageDetailsAreCorrect( userMobileNumber);
        shoppingCartPage.clickProceedToCheckOutButton();
        shoppingCartPage.checkShippingPageUIElemnts();
    }

    @StepGroup
    public void checkPaymentDetailsAreCorrect(String productTitle,  String userMobileNumber){
        shoppingCartPage.checkIfProductIsSuccessfullyAddedToShoppingChartSummary(productTitle);
        shoppingCartPage.clickProceedToCheckOutButtonSummaryTab();
        shoppingCartPage.checkAddressPageDetailsAreCorrect( userMobileNumber);
        shoppingCartPage.clickProceedToCheckOutButton();
        shoppingCartPage.checkShippingPageUIElemnts();
        shoppingCartPage.clickTheAgreeToTermsButton();
        shoppingCartPage.clickProceedToCheckOutButton();
        shoppingCartPage.checkPaymentPageDetailsAreCorrect(productTitle);
    }

    @StepGroup
    public void buyAProductCompleteTestFlow(String productTitle,  String userMobileNumber){
        shoppingCartPage.checkIfProductIsSuccessfullyAddedToShoppingChartSummary(productTitle);
        shoppingCartPage.clickProceedToCheckOutButtonSummaryTab();
        shoppingCartPage.checkAddressPageDetailsAreCorrect( userMobileNumber);
        shoppingCartPage.clickProceedToCheckOutButton();
        shoppingCartPage.checkShippingPageUIElemnts();
        shoppingCartPage.clickTheAgreeToTermsButton();
        shoppingCartPage.clickProceedToCheckOutButton();
        shoppingCartPage.checkPaymentPageDetailsAreCorrect(productTitle);
        shoppingCartPage.clickPayByBankWire();
        shoppingCartPage.clickConfirmOrderAndCheckCompleteMessage();


    }
}
