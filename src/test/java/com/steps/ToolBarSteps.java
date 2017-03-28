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
    public void clickSignInButton(){
        toolBarPage.clickSignInButton();
    }

    @Step
    public void checkBottomToolbarElementsPrsence(){
        toolBarPage.checkBottomToolbarElementsPrsence();
    }

    @Step
    public void clickOnFollowUsIconAndCheckLandingPage(String followUsButton){
        toolBarPage.clickOnFollowUsIconAndCheckLandingPage(followUsButton);
    }

    @Step
    public void subscribeToNewsletter(String emailAddress){
        toolBarPage.subscribeToNewsletter(emailAddress);
    }

    @Step
    public void subscribeToNewsletterWithInvalidEmail(String invalidEmail){
        toolBarPage.subscribeToNewsletterWithInvalidEmail(invalidEmail);
    }


}
