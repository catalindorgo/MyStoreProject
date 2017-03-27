package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

/**
 * Created by catalindorgo on 3/27/2017.
 */
public class QuickViewPage extends GeneralMethods {
    @FindBy(xpath = )
    private WebElement productDescription;

    @FindBy(xpath = "//div/div/h1[@itemprop]")
    private WebElement productName;

    @FindBy(xpath = )
    private WebElement socialNetworkShareButton;

    @FindBy(xpath = "//div/span/img")
    private WebElement productImage;

    @FindBy(xpath = "//div//p/a[contains(@title, 'Add')]")
    private WebElement addToWishList;

    @FindBy(xpath = "//div//p[@class='fancybox-error']")
    private WebElement addedToWishlistConfirmationMessage;

    String SHARE_ON_SOCIAL_NETWORK_BUTTON ="//p/button/i[@class='icon-twitter']/..";

    public void shareProductOnSocialNetwork(){}
}
