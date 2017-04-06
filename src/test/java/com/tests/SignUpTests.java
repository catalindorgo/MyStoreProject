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
public class SignUpTests  {
    @Managed(uniqueSession = true)
    public WebDriver  webDriver;

    @Steps
    SignUpSteps signUpSteps;
    @Steps
    AuthenticationSteps authenticationSteps;
    @Steps
    ToolBarSteps toolBarSteps;

    //TODO: maybe change method's name?
    @Before
    public void launchFireFox(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    /*
    TODO: registerWithInvalidCredentialsAndCheckError- poor name for the method: no invalid credentials + error message is not checked (only verifies that the message is displayed but can be any error message);
    TODO: decide what you want to to achieve with this method and change it accordingly; I would propose different approach but it depends on what you want to do with it:
    TODO: change test's name accordingly
    */
    @Test
    public void registerWithInvalidCredentialsAndCheckError(){
        toolBarSteps.clickSignInButton();
        authenticationSteps.createAccountWithValidEmail("matei@corvin.ro");
        signUpSteps.registerWithInvalidCredentialsAndCheckError();
    }

    @Test
    public void registerNewAccountSuccessfully(){
        toolBarSteps.clickSignInButton();
        authenticationSteps.createAccountWithValidEmail("admin991@yahoo.ro");
        signUpSteps.registerNewAccountSuccessfully("mr", "firstname", "lastname", "", "password", "4", "June", "1986", "randomAddress", "theaddress", "homeAdd", "chicago","Iowa", "00000", "2321312", "alias" );
    }
}
