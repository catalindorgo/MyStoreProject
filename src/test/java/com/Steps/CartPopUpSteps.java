package com.Steps;

import com.pages.CartPopUpPage;
import com.pages.CatalogPage;
import com.pages.MainPage;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/22/2017.
 */
public class CartPopUpSteps extends ScenarioSteps {
    MainPage mainPage;
    CatalogPage catalogPage;
    CartPopUpPage cartPopUpPage;

    @StepGroup
    public void addProductToCartAndCheckIfSuccessfullyAdded(String productIndex){
        mainPage.clickOnWomenSection();
        catalogPage.viewProductsAsList();
        cartPopUpPage.addProductToCartAndCheckIfSuccessfullyAdded(productIndex);

    }
}
