package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


/**
 * Created by catalindorgo on 3/10/2017.
 */
public class AuthenticationPage extends PageObject {

    @FindBy(xpath="//input[@name='email_create']")
    private WebElement emailAddressFieldUnderCreateAnAccount;

    @FindBy(xpath = "//div//button[@name='SubmitCreate']")
    private WebElement createAccountButton;

    //TODO: suggested xpath: .//div[contains(@class,"alert")]//ol//li
    //TODO: try using more suggestive xpaths- there are multiple ways of doing this
    // - Done - used the suggested xpath since I'm going to use this WebElement for all errors thrown by any incopability in the credentials fields.
    @FindBy(xpath = ".//div[contains(@class,'alert')]//ol//li")
    private WebElement errorMessageTriggeredByAutenticationProblems;

    //TODO: suggestion: //input[@id='email']- try to simplify XPATHS
    // Done - used simplified xpath + changed the name of the WebE also to be more suggestive.

    @FindBy (xpath = "//input[@name='email']")
    private WebElement logInEmailInputField;

    @FindBy(xpath = "//div/span/input[@name= 'passwd']")
    private WebElement logInPassword;

    @FindBy (xpath = "//p/button[@type ='submit']")
    private WebElement signInButton;

    @FindBy (xpath = "//div/a[@class='account']/span")
    private WebElement loggedInAccount;

    @FindBy(xpath = "//span[@class='navigation_page']")
    public WebElement authenticationPageBreadCrumb;

    //TODO: The same xpath as for errorMessageForInvalidEmail
    // Done - will use only 1 WebElement for all error messages triggered by the Autentication fields (Email address and Password).
//    @FindBy (xpath = "//ol/li[text()='Authentication failed.']")
//    private WebElement authenticationErrorMessage;

   //TODO: In this case the error message will always be the same; no need to give it as a parameter in the test; use it in the assertion directly
    // Done - removed the parameter and used hard coded assertion text.
    public void createAccountWithIncorrectEmailAndVerifyThrownError(String emailAddress){
        emailAddressFieldUnderCreateAnAccount.sendKeys(emailAddress);
        createAccountButton.click();
        Assert.assertTrue("The expected error is not received for incorrect Email address",errorMessageTriggeredByAutenticationProblems.getText().contentEquals("Invalid email address.") );
    }

    //TODO: Assert user is on the expected page- Create an account
    // NOT DONE - this test is done in the @CreateAccountTest class, beacause it uses the header WebElement from the SignUp page not from the AuthenticationPage.
    public void createAccountWithValidEmail(String emailAddress){
        emailAddressFieldUnderCreateAnAccount.sendKeys(emailAddress);
        createAccountButton.click();
    }

    private void  logInWithValidCredentials(String userName, String password){
        logInEmailInputField.sendKeys(userName);
        logInPassword.sendKeys(password);
        signInButton.click();
    }
    //TODO: Login should be a separated method (maybe prvate- it depends on how you use it) to be used in these 2 methods
    // Done - log in method is private for this class.
    public void logInAndVerifyAccount (String userName, String password, String expectedLoggedInAccount){
        logInWithValidCredentials(userName, password);
        Assert.assertTrue("Your user name is not displayed as the logged in account", loggedInAccount.getText().contentEquals(expectedLoggedInAccount));
    }

    //TODO: Assertion error message is not reflecting what you are asserting. Why using contains and not contentEquals?
    // DONE - Updated the Assertion Error message. And the Assertion is using contentEquals now.
    public void checkErrorMessageAtFailedAuthentication(String userEmail, String password){
       logInWithValidCredentials(userEmail, password);
        Assert.assertTrue("The 'Authentication failed' error message was not received",errorMessageTriggeredByAutenticationProblems.getText().contentEquals("Authentication failed.") );
    }
}
