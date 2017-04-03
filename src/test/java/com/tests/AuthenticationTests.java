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
public class AuthenticationTests {
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
    public void launchFireFox(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    //TODO: I would split these tests in 2 classed: Create Account tests and Sign in tests- I think it's a bit confusing because even if they are on the same page, it's different functionality

    @Test
    public void createAccountWithInvalidEmailAndVerifyThrownError(){
        toolBarSteps.clickSignInButton();
        authenticationSteps.createAccountWithIncorrectEmailAndVerifyThrownError("invalidEmail", "Invalid email address.");
    }

    //TODO: waitForSignUpPageHeader method should be removed from the test; wait should be included in createAccountWithValidEmail method
    @Test
    public void createAccountWithValidEmailAndVerifyLandingPage(){
        toolBarSteps.clickSignInButton();
        authenticationSteps.createAccountWithValidEmail("domnul1@copac.com");
        signUpSteps.waitForSignUpPageHeader();
        signUpSteps.verifyCurrentPageTitle("CREATE AN ACCOUNT");
    }

    @Test
    public void logInAndVerifyAccount(){
        toolBarSteps.clickSignInButton();
        authenticationSteps.logInAndVerifyAccount("admin@yahoo.ro", "password", "Admin lastName");
    }

    //TODO: Change method name to reflect all you are doing: signInWithWrongCredentialsAndVerifyErrormessage
    //TODO: Personally, I like to use Verify instead of Check. Check is used only on checking radio buttons...
    @Test
    public void checkErrorMessageAtFailedAuthentication(){
        toolBarSteps.clickSignInButton();
        authenticationSteps.checkErrorMessageAtFailedAuthentication("admin@yahoo.ro", "$%^&*()_");
    }
}
