package com.pages;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.pages.SignUpPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Set;


/**
 * Created by catalindorgo on 3/10/2017.
 */
public class AuthenticationPage extends PageObject {

    @FindBy(xpath="//input[@name='email_create']")
      WebElement emailAddressField;

    @FindBy(xpath = "//div//button[@name='SubmitCreate']")
     WebElement createAccountButton;

    @FindBy(xpath = "//div[@class='row']//ol/li")
     WebElement errorMessageForInvalidEmail;

    @FindBy (xpath = "//div/div/input[@name='email']")
     WebElement logInEmail;

    @FindBy(xpath = "//div/span/input[@name= 'passwd']")
     WebElement logInPassword;

    @FindBy (xpath = "//p/button[@type ='submit']")
     WebElement signInButton;

    @FindBy (xpath = "//div/a[@class='account']/span")
    private WebElement loggedInAccount;

    @FindBy (xpath = "//div/div/ol")
    private WebElement authenticationErrorMessage;

    public void createAccountWithIncorrectEmailAndVerifyThrownError(String emailAddress, String expectedErrorMessage){
        emailAddressField.sendKeys(emailAddress);
        createAccountButton.click();
        Assert.assertTrue("The expected error is not received for inccorect Email address",errorMessageForInvalidEmail.getText().contentEquals(expectedErrorMessage) );
    }
    public void createAccountWithValidEmail(String emailAddress){
        emailAddressField.sendKeys(emailAddress);
        createAccountButton.click();
    }

    public void logInAndVerifyAccount (String userName, String password, String expectedLoggedInAccount){

        logInEmail.sendKeys(userName);
        logInPassword.sendKeys(password);
        signInButton.click();
        Assert.assertTrue("Your user name is not displayed as the logged in account", loggedInAccount.getText().contentEquals(expectedLoggedInAccount));
    }
    public void checkErrorMessageAtFailedAuthentication(String userName, String password){
        logInEmail.sendKeys(userName);
        logInPassword.sendKeys(password);
        signInButton.click();
        Assert.assertTrue("the error message was not received",authenticationErrorMessage.getText().contains("Authentication failed") );
    }
}
