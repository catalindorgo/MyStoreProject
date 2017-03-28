package com.steps;

import com.pages.AuthenticationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import com.pages.SignUpPage;

/**
 * Created by catalindorgo on 3/10/2017.
 */
public class SignUpSteps extends ScenarioSteps{
    SignUpPage signUpPage;
    AuthenticationPage authenticationPage;

    @Step
    public void registerWithInvalidCredentialsAndCheckError(){
        signUpPage.registerWithInvalidCredentialsAndVerifyThrownError();
    }
    @Step
    public void registerNewAccountSuccessfully(String gender, String firstName, String lastName, String email,String password, String dayOfBirth, String month, String year, String addressFirstname, String addressLastname, String homeAddress,String cityName ,String state,String zipCodeNumber, String mobilePhoneNumber, String alias ){
        signUpPage.fillInAndRegisterUserAccountCredentials(gender, firstName,lastName,email,password,dayOfBirth,month,year,addressFirstname,addressLastname,homeAddress,cityName,state,zipCodeNumber,mobilePhoneNumber,alias);
    }

    @Step
    public void waitForSignUpPageHeader(){
        signUpPage.waitForSignUpPageHeader();
    }

    @Step
    public void verifyCurrentPageTitle(String currentPageTitle){
        signUpPage.verifyCurrentPageTitle(currentPageTitle);
    }
}

