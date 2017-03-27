package com.Tests;

import com.Steps.AuthenticationSteps;
import com.Steps.SignUpSteps;
import com.pages.AuthenticationPage;
import com.pages.SignUpPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 3/10/2017.
 */
@RunWith(SerenityRunner.class)
public class SignUpTests  {
    @Managed(uniqueSession = true)
    public WebDriver  webDriver;

    @Steps
    SignUpSteps signUpSteps;
    @Steps
    AuthenticationSteps authenticationSteps;

    @Before
    public void launchFireFox(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void registerWithInvalidCredentialsAndCheckError(){
        signUpSteps.registerWithInvalidCredentialsAndCheckError("matei@corvin.ro");
    }

    @Test
    public void registerNewAccountSuccessfully(){
        authenticationSteps.createAccountWithValidEmailAndVerifyLandingPage("admin5@yahoo.ro", "CREATE AN ACCOUNT");
        signUpSteps.registerNewAccountSuccessfully("mr", "firstname", "lastname", "", "password", "4", "June", "1986", "randomAddress", "theaddress", "homeAdd", "chicago","Iowa", "00000", "2321312", "alias" );
    }
}
