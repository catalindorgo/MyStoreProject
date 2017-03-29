package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Created by catalindorgo on 3/27/2017.
 */
public class QuickViewPage extends CatalogPage {
    @FindBy(xpath ="" )
    private WebElement productDescription;

    @FindBy(xpath = "//div/div/h1[@itemprop]")
    private WebElement productName;

    @FindBy(xpath = "")
    private WebElement socialNetworkShareButton;

    @FindBy(xpath = "//div/span/img")
    private WebElement productImage;

    @FindBy(xpath = ".//div//p/a[contains(@title, 'Add')]")
    private WebElement addToWishListButton;

    @FindBy(xpath = "//div//p[@class='fancybox-error']")
    private WebElement addedToWishlistConfirmationMessage;

    String SHARE_ON_SOCIAL_NETWORK_BUTTON ="//p/button/i[@class='icon-%value%']/..";
    String PRODUCT_NAME_IN_QUICK_VIEW_POP_UP ="//div/div/h1[text()='%value%']";

    //@FindBy(css = )

    public void shareProductOnSocialNetworkAndCheckLaunchedPopUp(String socialNetwork){
       WebElement socialNetworkButton = getDriver().findElement(By.xpath(SHARE_ON_SOCIAL_NETWORK_BUTTON.replace("%value%",socialNetwork)));
        String currentUrl = getDriver().getCurrentUrl();
        socialNetworkButton.click();
        switchToLaunchedPopUp();
        System.out.println(currentUrl);
        Assert.assertTrue("expected url is incorrect compared to your input", currentUrl.contains(socialNetwork));
    }

    public void clickAddToWishlistButtonAndCheckConfirmationPopUp() {
        System.out.print("--------------" + addToWishListButton.getText());
        addToWishListButton.click();
        addedToWishlistConfirmationMessage.isDisplayed();
    }

    public void checkProductNameIsCorrect(String productTitle){
        WebElement productName = getDriver().findElement(By.xpath(PRODUCT_NAME_IN_QUICK_VIEW_POP_UP.replace("%value%", productTitle)));
        Assert.assertTrue("name not correct", productName.getText().contains(productTitle));

    }
}
