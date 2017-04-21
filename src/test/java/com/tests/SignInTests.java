package com.tests;

import com.steps.AuthenticationSteps;
import com.steps.ToolBarSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 4/4/2017.
 */
@RunWith(SerenityRunner.class)
public class SignInTests {
    @Managed(uniqueSession = true)
    WebDriver webDriver;

    @Steps
    ToolBarSteps toolBarSteps;
    @Steps
    AuthenticationSteps authenticationSteps;

    @Before
    public void launchApplication(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void logInAndVerifyAccount(){
        toolBarSteps.clickSignInButtonAndVerifyLandingPage();
        authenticationSteps.logInAndVerifyAccount("admin@yahoo.ro", "password", "Admin lastName");
    }

    //TODO: Change method name to reflect all you are doing: signInWithWrongCredentialsAndVerifyErrormessage
    //TODO: Personally, I like to use Verify instead of Check. Check is used only on checking radio buttons...
    // Done - Updated the Methods name to be more suggestive.  Also will use Verify over Check in this context in the future.
    @Test
    public void signInWithIncorrectCredentialsAndVerifyErrorMessage(){
        toolBarSteps.clickSignInButtonAndVerifyLandingPage();
        authenticationSteps.checkErrorMessageAtFailedAuthentication("admin@yahoo.ro", "$%^&*()_");
    }
}
