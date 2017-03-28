package com.steps;

import com.pages.CatalogPage;
import com.pages.MainPage;
import com.pages.QuickViewPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/27/2017.
 */
public class QuickViewSteps extends ScenarioSteps {
    QuickViewPage quickViewPage;

    @StepGroup
    public void shareProductOnSocialNetworkAndCheckLaunchedPopUp(String socialNetwork, Integer tabNumber){
        quickViewPage.switchToLaunchedPopUp(tabNumber);
        quickViewPage.shareProductOnSocialNetworkAndCheckLaunchedPopUp(socialNetwork);
    }

    @StepGroup
    public void addProductToWishList(Integer tabNumber)   {
//       quickViewPage.switchToLaunchedPopUp(tabNumber);
        quickViewPage.clickAddToWishlistButtonAndCheckConfirmationPopUp();
    }

    @Step
    public void checkProductNameIsCorrect(String productIndex){
        quickViewPage.checkProductNameIsCorrect(productIndex);
    }
}
