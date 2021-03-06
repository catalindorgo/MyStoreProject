package com.steps;

import com.pages.ToolBarPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/14/2017.
 */
public class ToolBarSteps extends ScenarioSteps{
    ToolBarPage toolBarPage;

    @Step
    public void clickSignInButtonAndVerifyLandingPage(){
        toolBarPage.clickSignInButtonAndVerifyLandingPage();
    }

    @Step
    public void verifyBottomToolbarNewsletterAndFollowUsButtonsArePresent(){
        toolBarPage.verifyBottomToolbarNewsletterAndFollowUsButtonsArePresent();
    }

    @Step
    public void clickOnFollowUsIconAndCheckLandingPage(String followUsButton){
        toolBarPage.clickOnFollowUsIconAndCheckLandingPage(followUsButton);
    }

    @Step
    public void subscribeToNewsletterAndCheckIfSubscriptionWasSuccessfull(String emailAddress){
        toolBarPage.subscribeToNewsletterAndCheckIfSubscriptionWasSuccessfull(emailAddress);
    }

    @Step
    public void subscribeToNewsletterWithInvalidEmailAndVerifyIfErrorMessageIsThrown(String invalidEmail){
        toolBarPage.subscribeToNewsletterWithInvalidEmailAndVerifyIfErrorMessageIsThrown(invalidEmail);
    }


}
