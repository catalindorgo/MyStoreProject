package com.steps;

import com.pages.CartPopUpPage;
import com.pages.CatalogPage;
import com.pages.MainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/22/2017.
 */
public class CartPopUpSteps extends ScenarioSteps {
    CartPopUpPage cartPopUpPage;

    @Step
    public void addProductToCartAndCheckIfSuccessfullyAdded(String productIndex){
        cartPopUpPage.checkAddedProductIsPresentInCartPopUp(productIndex);
    }

    @Step
    public void clickProceedToCheckout(){
        cartPopUpPage.clickProceedToCheckout();
    }
}
