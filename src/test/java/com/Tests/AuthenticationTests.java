package com.Tests;

import com.Steps.AuthenticationSteps;
import com.Steps.SignUpSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
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
    SignUpSteps signUpSteps;

    @Before
    public void launchFireFox(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void createAccountWithInvalidEmailAndVerifyThrownError(){
        authenticationSteps.createAccountWithIncorrectEmailAndVerifyThrownError("invalidEmail", "Invalid email address.");
    }

    @Test
    public void createAccountWithValidEmailAndVerifyLandingPage(){
        authenticationSteps.createAccountWithValidEmailAndVerifyLandingPage("domnul1@copac.com", "CREATE AN ACCOUNT");
    }

    @Test
    public void logInAndVerifyAccount(){
        authenticationSteps.logInAndVerifyAccount("admin@yahoo.ro", "password", "Admin lastName");
    }
    @Test
    public void checkErrorMessageAtFailedAuthentication(){
        //maximize browser
       // webDriver.manage().window().maximize();
        authenticationSteps.checkErrorMessageAtFailedAuthentication("admin@yahoo.ro", "$%^&*()_");
    }
}
