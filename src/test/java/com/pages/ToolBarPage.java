package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

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

    public void clickSignInButton(){
        signInButtonFromToolbar.click();
    }
    public void checkBottomToolbarElementsPrsence(){
        newsletterInputEmailField.isDisplayed();
        facebookFollowUsButton.isDisplayed();
        twitterFollowUsButton.isDisplayed();
        youtubeFollowUsButton.isDisplayed();
        googlePlusFollowUsButton.isDisplayed();
    }
}
