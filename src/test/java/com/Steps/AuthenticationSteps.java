package com.Steps;

import com.pages.AuthenticationPage;
import com.pages.SignUpPage;
import com.pages.ToolBarPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;

/**
 * Created by catalindorgo on 3/10/2017.
 */
public class AuthenticationSteps extends ScenarioSteps {
    AuthenticationPage authenticationPage;
    SignUpPage signUpPage;
    ToolBarPage toolBarPage;

    @StepGroup
    public void createAccountWithIncorrectEmailAndVerifyThrownError(String emailAdrres, String errorMessage) {
        toolBarPage.clickSignInButton();
        authenticationPage.createAccountWithIncorrectEmailAndVerifyThrownError(emailAdrres, errorMessage);
    }

    @StepGroup
    public void createAccountWithValidEmailAndVerifyLandingPage(String emailAddress, String currentPageTitle) {
        toolBarPage.clickSignInButton();
        authenticationPage.createAccountWithValidEmail(emailAddress);
        signUpPage.waitForSignUpPageHeader();
        signUpPage.verifyCurrentPageTitle(currentPageTitle);
    }

    @StepGroup
    public void logInAndVerifyAccount(String userName, String password, String expectedLoggedinAccount) {
        toolBarPage.clickSignInButton();
        authenticationPage.logInAndVerifyAccount(userName, password, expectedLoggedinAccount);
    }

    @StepGroup
    public void checkErrorMessageAtFailedAuthentication(String userName, String password) {
        toolBarPage.clickSignInButton();
        authenticationPage.checkErrorMessageAtFailedAuthentication(userName, password);
    }
}