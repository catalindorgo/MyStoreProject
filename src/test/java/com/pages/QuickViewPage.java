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

    String SHARE_ON_SOCIAL_NETWORK_BUTTON ="//p/button/i[@class='icon-%value%']/..";
    String PRODUCT_NAME_IN_QUICK_VIEW_POP_UP ="//div/div/h1[text()='%value%']";

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

    @FindBy(xpath = "//span/i[@class='icon-plus']")
    private WebElement plusQuantityButton;

    @FindBy(xpath = "//p/input[@type='text']")
    private WebElement quantityInputField;


    public void shareProductOnSocialNetwork(String socialNetwork){
       WebElement socialNetworkButton = getDriver().findElement(By.xpath(SHARE_ON_SOCIAL_NETWORK_BUTTON.replace("%value%",socialNetwork)));
        socialNetworkButton.click();
    }
    public void switchToNewLaunchedTabAndCheckIfURLContainsSocialNetworkName(String socialNetwork){
        switchToLaunchedPopUp();
        Assert.assertTrue("Your URL does not contain the Social Network name", getDriver().getCurrentUrl().contains(socialNetwork));
    }

    public void clickAddToWishlistButtonAndCheckConfirmationPopUp() {
        addToWishListButton.click();
        addedToWishlistConfirmationMessage.isDisplayed();
    }

    public void checkProductNameIsCorrect(String productTitle){
        WebElement productName = getDriver().findElement(By.xpath(PRODUCT_NAME_IN_QUICK_VIEW_POP_UP.replace("%value%", productTitle)));
        Assert.assertTrue("name not correct", productName.getText().contains(productTitle));

    }

    public void increaseProductQuantityAndCheckQuantityFieldInput(Integer quantity){
        for(int i =0; i < quantity; i++){
            plusQuantityButton.click();
        }
        Integer quantityAfterUpdate = Integer.valueOf(quantityInputField.getAttribute("value"));
        Assert.assertTrue("the quantity is not updated correctly", quantity.equals(quantityAfterUpdate -1 ) );
    }
}
