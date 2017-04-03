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
    private WebElement emailAddressField;

    @FindBy(xpath = "//div//button[@name='SubmitCreate']")
    private WebElement createAccountButton;

    //TODO: suggested xpath: .//div[contains(@class,"alert")]//ol//li
    //TODO: try using more suggestive xpaths- there are multiple ways of doing this
    @FindBy(xpath = "//div[@class='row']//ol/li")
    private WebElement errorMessageForInvalidEmail;

    //TODO: suggestion: //input[@id='email']- try to simplify XPATHS

    @FindBy (xpath = "//div/div/input[@name='email']")
    private WebElement logInEmail;

    @FindBy(xpath = "//div/span/input[@name= 'passwd']")
    private WebElement logInPassword;

    @FindBy (xpath = "//p/button[@type ='submit']")
    private WebElement signInButton;

    @FindBy (xpath = "//div/a[@class='account']/span")
    private WebElement loggedInAccount;

    //TODO: The same xpath as for errorMessageForInvalidEmail
    @FindBy (xpath = "//div/div/ol")
    private WebElement authenticationErrorMessage;

   //TODO: In this case the error message will always be the same; no need to give it as a parameter in the test; use it in the assertion directly
    public void createAccountWithIncorrectEmailAndVerifyThrownError(String emailAddress, String expectedErrorMessage){
        emailAddressField.sendKeys(emailAddress);
        createAccountButton.click();
        Assert.assertTrue("The expected error is not received for inccorect Email address",errorMessageForInvalidEmail.getText().contentEquals(expectedErrorMessage) );
    }

    //TODO: Assert user is on the expected page- Create an account
    public void createAccountWithValidEmail(String emailAddress){
        emailAddressField.sendKeys(emailAddress);
        createAccountButton.click();
    }

    //TODO: Login should be a separated method (maybe prvate- it depends on how you use it) to be used in these 2 methods
    public void logInAndVerifyAccount (String userName, String password, String expectedLoggedInAccount){
        logInEmail.sendKeys(userName);
        logInPassword.sendKeys(password);
        signInButton.click();
        Assert.assertTrue("Your user name is not displayed as the logged in account", loggedInAccount.getText().contentEquals(expectedLoggedInAccount));
    }

    //TODO: Assertion error message is not reflecting what you are asserting. Why using contains and not contentEquals?
    public void checkErrorMessageAtFailedAuthentication(String userName, String password){
        logInEmail.sendKeys(userName);
        logInPassword.sendKeys(password);
        signInButton.click();
        Assert.assertTrue("the error message was not received",authenticationErrorMessage.getText().contains("Authentication failed") );
    }
}
