package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by catalindorgo on 3/22/2017.
 */
public class CartPopUpPage extends CatalogPage {

    @FindBy(xpath = "//div/span[@class='product-name']")
    private WebElement productsNameInCartPopUp;

    @FindBy(xpath ="//div[@class='clearfix']/div/h2/i/..")
    private WebElement productSuccessfullyAddedMessage;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div/a[contains(@title,'checkout')]")
    private WebElement proceedToCheckoutButton;

    public void checkAddedProductIsPresentInCartPopUp (String productTitle){
        WebElement addToCartButton = getDriver().findElement(By.xpath(ADD_TO_CART_BUTTON.replace("%value%", productTitle)));
        Assert.assertTrue("The product you clicked AddToCart is not the same as in the basket", productsNameInCartPopUp.getText().equals(productTitle));
        Assert.assertTrue("The Product Successfully added message was not received", productSuccessfullyAddedMessage.getText().contains("successfully added"));
    }
// NOT USED in current tests.
//    public void clickContinueShopping(){
//        continueShoppingButton.click();
//    }

    public void clickProceedToCheckout(){
        proceedToCheckoutButton.click();
    }
}
