package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by catalindorgo on 3/23/2017.
 */
public class ShoppingCartPage extends CatalogPage {

    String PRODUCT_IN_SHOPPING_CHART_SUMMARY ="//td/p[@class='product-name']/a[text()='%value%']";
    String PRODUCT_NAME_IN_PAYMENT_PAGE = "//td/p/a[text()= '%value%']";

    @FindBy(xpath = "//div/h1")
    private WebElement shoppingCartPageTitle;

    @FindBy (xpath = "//p/a[contains(@title, 'Proceed')]")
    private WebElement proceedToCheckOutButtonFromSummaryTab;

    @FindBy(xpath = "//li[@class='step_current third']/span")
    private WebElement addressTabTitle;

    @FindBy(xpath = "//ul[@id='address_delivery']/li[contains(@class, 'country')]")
    private WebElement countryNameFromDeliveryAddress;

    @FindBy(xpath = "//ul[@id='address_delivery']/li[contains(@class, 'mobile')]")
    private WebElement mobileNumberFromDeliveryAddress;

    @FindBy(xpath = "//li/span[contains(text(), 'Shipping')]")
    private WebElement shippingTabTile;

    @FindBy(xpath = "//td[@class='delivery_option_price']")
    private WebElement shippingPriceBox;

    @FindBy(xpath = "//div[@class='checker']/span")
    private WebElement agreeToTermsCheckBox;

    @FindBy(xpath = "//p/button[@type='submit']")
    private WebElement proceedToCheckOutButtonGeneral;

    @FindBy(xpath = "//div/p/a[contains(text(), 'bank')]/..")
    private WebElement payByBankWireFromPaymentTab;

    @FindBy(xpath = "//p/button[contains(@class, 'button')]")
    private WebElement confirmOrderButtonFromPaymentTab;

    @FindBy(xpath = "//div/p/strong")
    private WebElement titleOfOrderConfirmationMessage;

    public void checkIfProductIsSuccessfullyAddedToShoppingChartSummary(String productTitle){
        WebElement productInShoppingChartSummary = getDriver().findElement(By.xpath(PRODUCT_IN_SHOPPING_CHART_SUMMARY.replace("%value%", productTitle)));
        Assert.assertTrue("Incorrect title", shoppingCartPageTitle.getText().contains("SHOPPING-CART SUMMARY"));
        Assert.assertTrue("Name of the added/ selected product from list is not the same as in Shopping Cart Summary", productInShoppingChartSummary.getText().contentEquals(productTitle));
    }

    public void checkAddressPageDetailsAreCorrect( String userMobileNumber){
        Assert.assertTrue("incorrect Tab Title, 'address' expected", addressTabTitle.getText().contains("Address"));
        System.out.print(mobileNumberFromDeliveryAddress.getText());
        Assert.assertTrue("The users mobile number is incorrect", mobileNumberFromDeliveryAddress.getText().contentEquals(userMobileNumber));
    }

    public void checkShippingPageUIElemnts(){
        shippingTabTile.isDisplayed();
        shippingPriceBox.isDisplayed();
    }

    public void checkPaymentPageDetailsAreCorrect(String productTitle){
        WebElement productNameInPaymentSection = getDriver().findElement(By.xpath(PRODUCT_NAME_IN_PAYMENT_PAGE.replace("%value%", productTitle)));
        Assert.assertTrue("Name of the added/ selected product from list is not the same as in Shopping Cart Summary", productNameInPaymentSection.getText().contentEquals(productTitle));
    }

    public void clickTheAgreeToTermsButton(){
        agreeToTermsCheckBox.click();
    }
    public void clickProceedToCheckOutButtonSummaryTab(){
            proceedToCheckOutButtonFromSummaryTab.click();
        }

    public void clickProceedToCheckOutButton(){
        proceedToCheckOutButtonGeneral.click();
    }

    public void clickPayByBankWire(){
        payByBankWireFromPaymentTab.click();
    }
    public void clickConfirmOrderAndCheckCompleteMessage(){
        confirmOrderButtonFromPaymentTab.click();
        Assert.assertTrue("Incorrect Title", titleOfOrderConfirmationMessage.getText().contains("complete"));

    }
}
