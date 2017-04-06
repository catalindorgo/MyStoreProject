package com.steps;

import com.pages.AuthenticationPage;
import com.pages.SignUpPage;
import com.pages.ToolBarPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by catalindorgo on 3/10/2017.
 */
public class AuthenticationSteps extends ScenarioSteps {
    AuthenticationPage authenticationPage;

    @Step
    public void createAccountWithIncorrectEmailAndVerifyThrownError(String emailAdrres) {
        authenticationPage.createAccountWithIncorrectEmailAndVerifyThrownError(emailAdrres);
    }

    @Step
    public void createAccountWithValidEmail(String emailAddress ) {
        authenticationPage.createAccountWithValidEmail(emailAddress);
    }

    @Step
    public void logInAndVerifyAccount(String userName, String password, String expectedLoggedinAccount) {
        authenticationPage.logInAndVerifyAccount(userName, password, expectedLoggedinAccount);
    }

    @Step
    public void checkErrorMessageAtFailedAuthentication(String userName, String password) {
        authenticationPage.checkErrorMessageAtFailedAuthentication(userName, password);
    }
}