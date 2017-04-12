package com.tests;

import com.steps.AuthenticationSteps;
import com.steps.SignUpSteps;
import com.steps.ToolBarSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 3/10/2017.
 */

@RunWith(SerenityRunner.class)
public class CreateAccountTests {
    @Managed (uniqueSession = true)
    public WebDriver webDriver;
//    @ManagedPages( defaultUrl = "http://automationpractice.com/index.php")
//    Pages pages;
    @Steps
    AuthenticationSteps authenticationSteps;
    @Steps
    ToolBarSteps toolBarSteps;
    @Steps
    SignUpSteps signUpSteps;

    @Before
    public void launchApplicationHomePageInFireFoxBrowser(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    //TODO: I would split these tests in 2 classed: Create Account tests and Sign in tests- I think it's a bit confusing because even if they are on the same page, it's different functionality
    // Done - I agree, it's easier to follow. 2 classes present - CreateAccountTests and - SignInTests.
    @Test
    public void createAccountWithInvalidEmailAndVerifyThrownError(){
        toolBarSteps.clickSignInButtonAndVerifyLandingPage();
        authenticationSteps.createAccountWithIncorrectEmailAndVerifyThrownError("invalidEmail");
    }

    //TODO: waitForSignUpPageHeader method should be removed from the test; wait should be included in createAccountWithValidEmail method
    // NOT DONE - The WebElement that I'm waiting for, the page header is from a different Class so that's why I didn't include it in the suggested method
    @Test
    public void createAccountWithValidEmailAndVerifyLandingPage(){
        toolBarSteps.clickSignInButtonAndVerifyLandingPage();
        authenticationSteps.createAccountWithValidEmail("domnul1@copac.com");
        signUpSteps.waitAndVerifyCurrentPageTitle("CREATE AN ACCOUNT");
    }

}
