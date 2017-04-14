package com.steps;

import com.pages.ProductComparisonPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 4/13/2017.
 */
public class ProductComparisonSteps extends ScenarioSteps {
    ProductComparisonPage productComparisonPage;

    @Step
    public void clickContinueShoppingButtonAndVerifyLandingPage(){
        productComparisonPage.clickContinueShoppingButtonAndVerifyLandingPage();
    }
}
