package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


/**
 * Created by catalindorgo on 3/14/2017.
 */
public class ToolBarPage extends GeneralMethods{

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButtonFromToolbar;

    @FindBy(xpath = "//input[contains(@value, 'Enter')]")
    private WebElement newsletterInputEmailField;

    @FindBy(xpath = "//li[@class='facebook']")
    private WebElement facebookFollowUsButton;

    @FindBy(xpath = "//li[@class='twitter']")
    private WebElement twitterFollowUsButton;

    @FindBy(xpath = "//li[@class='youtube']")
    private WebElement youtubeFollowUsButton;

    @FindBy(xpath = "//li[@class='google-plus']")
    private WebElement googlePlusFollowUsButton;

    @FindBy(xpath = "//form/div/button")
    private WebElement goButtonFromNewsLetterSubscription;

    @FindBy(xpath = "//div/p[contains(@class,'alert')]")
    private WebElement newsLetterSubscriptionMessage;

    @FindBy(xpath = "//div/p[@class='alert alert-danger']")
    private WebElement newsLetterSubscriptionErrorMessage;

    String FOLLOW_US_BUTTON_STANDARD_STRING = "//li[@class='%value%']";

    //TODO: Assert that you are on the desired page- Authentication
    // Done
    //General bread crumb not authentication. just click method, and the assert from its class : Toolbar. /atuh class.
    public void clickSignInButtonAndVerifyLandingPage(){
        signInButtonFromToolbar.click();
        Assert.assertTrue("Incorrect bread crumbs displayed. 'Authentication expected.'", pageHeaderBreadCrumb.getText().contains("Authentication") );
    }

    public void verifyBottomToolbarNewsletterAndFollowUsButtonsArePresent(){
        Assert.assertTrue("Newsletter field not displayed",newsletterInputEmailField.isDisplayed());
        Assert.assertTrue("Facebook Follow Us button not displayed",facebookFollowUsButton.isDisplayed());
        Assert.assertTrue("Twitter Follow Us button not displayed",twitterFollowUsButton.isDisplayed());
        Assert.assertTrue("Youtube Follow Us button not displayed",youtubeFollowUsButton.isDisplayed());
        Assert.assertTrue("Google Follow Us button not displayed",googlePlusFollowUsButton.isDisplayed());
    }

    public void clickOnFollowUsIconAndCheckLandingPage(String followUsSiteName){
        WebElement followUsButton = getDriver().findElement(By.xpath(FOLLOW_US_BUTTON_STANDARD_STRING.replace("%value%", followUsSiteName)));
        followUsButton.click();

        ArrayList<String> tabList = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabList.get(1));
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue("expected url is incorrect compared to your input", currentUrl.contains(followUsSiteName));
    }

    public void subscribeToNewsletterAndCheckIfSubscriptionWasSuccessfull(String emailAddress){
        newsletterInputEmailField.sendKeys(emailAddress);
        goButtonFromNewsLetterSubscription.click();
        Assert.assertTrue("The subscription Successful message was not received", newsLetterSubscriptionMessage.getText().contains("successfully subscribed"));

    }

    public void subscribeToNewsletterWithInvalidEmailAndVerifyIfErrorMessageIsThrown(String invalidEmail){
        newsletterInputEmailField.sendKeys(invalidEmail);
        goButtonFromNewsLetterSubscription.click();
        Assert.assertTrue("The expected error message for invalid email was not received", newsLetterSubscriptionErrorMessage.getText().contains("Invalid") || newsLetterSubscriptionErrorMessage.getText().contains("already registered"));
    }
}
