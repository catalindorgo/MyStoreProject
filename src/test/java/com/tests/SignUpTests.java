package com.tests;

import com.steps.AuthenticationSteps;
import com.steps.SignUpSteps;
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
        authenticationSteps.createAccountWithValidEmail("matei@corvin.ro");
        signUpSteps.registerWithInvalidCredentialsAndCheckError();
    }

    @Test
    public void registerNewAccountSuccessfully(){
        authenticationSteps.createAccountWithValidEmail("admin7@yahoo.ro");
        signUpSteps.registerNewAccountSuccessfully("mr", "firstname", "lastname", "", "password", "4", "June", "1986", "randomAddress", "theaddress", "homeAdd", "chicago","Iowa", "00000", "2321312", "alias" );
    }
}
