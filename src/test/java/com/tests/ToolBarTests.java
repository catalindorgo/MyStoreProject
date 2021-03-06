package com.tests;

import com.steps.ToolBarSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 3/15/2017.
 */

@RunWith(SerenityRunner.class)
public class ToolBarTests {
    @Managed(uniqueSession = true)
    WebDriver webDriver;
    @Steps
    ToolBarSteps toolBarSteps;

    @Before
    public void launchApplication(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
    }

    @Test
    public void verifyBottomToolbarNewsletterAndFollowUsButtonsArePresent(){
        toolBarSteps.verifyBottomToolbarNewsletterAndFollowUsButtonsArePresent();
    }

    @Test
    public void clickOnFollowUsIconAndCheckLandingPage(){
        toolBarSteps.clickOnFollowUsIconAndCheckLandingPage("twitter");
    }

    @Test
    public void subscribeToNewsletterAndCheckIfSubscriptionWasSuccessfull(){
        toolBarSteps.subscribeToNewsletterAndCheckIfSubscriptionWasSuccessfull("gg@yahoo.com");
    }

    @Test
    public void subscribeToNewsletterWithInvalidEmailAndVerifyIfErrorMessageIsThrown(){
        toolBarSteps.subscribeToNewsletterWithInvalidEmailAndVerifyIfErrorMessageIsThrown("zzzssdsds");

    }
}
