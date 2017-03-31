package com.tests;

import com.steps.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 3/23/2017.
 */
@RunWith(SerenityRunner.class)
public class ShoppingCartTests {
    @Managed (uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    ShoppingCartSteps shoppingCartSteps;
    @Steps
    AuthenticationSteps authenticationSteps;
    @Steps
    MainSteps mainSteps;
    @Steps
    CatalogSteps catalogSteps;
    @Steps
    CartPopUpSteps cartPopUpSteps;
    @Steps
    ToolBarSteps toolBarSteps;

    @Before
    public void userLogIn(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        toolBarSteps.clickSignInButton();
        authenticationSteps.logInAndVerifyAccount("admin@yahoo.ro", "password", "Admin lastName");
    }

    @Test
    public void addProductToCartAndCheckIfPresentInShoppingSummary(){
        mainSteps.clickOnWomenSection();
        catalogSteps.viewProductsAsList();
        catalogSteps.addProductToCart("Faded Short Sleeve T-shirts");
        cartPopUpSteps.clickProceedToCheckout();
        shoppingCartSteps.addProductToCartAndCheckIfPresentInShoppingSummary("Faded Short Sleeve T-shirts");
    }

    @Test
    public void checkAddressPageDetailsAreCorrect(){
        mainSteps.clickOnWomenSection();
        catalogSteps.viewProductsAsList();
        catalogSteps.addProductToCart("Faded Short Sleeve T-shirts");
        cartPopUpSteps.clickProceedToCheckout();
        shoppingCartSteps.checkAddressPageDetailsAreCorrect("Faded Short Sleeve T-shirts", "7432221");
    }

    @Test
    public void checkShippingPageDetailsAreCorrect(){
        mainSteps.clickOnWomenSection();
        catalogSteps.viewProductsAsList();
        catalogSteps.addProductToCart("Faded Short Sleeve T-shirts");
        cartPopUpSteps.clickProceedToCheckout();
        shoppingCartSteps.checkShippingPageDetailsAreCorrect("Faded Short Sleeve T-shirts", "7432221");
    }
    @Test
    public void checkPaymentDetailsAreCorrect(){
        mainSteps.clickOnWomenSection();
        catalogSteps.viewProductsAsList();
        catalogSteps.addProductToCart("Faded Short Sleeve T-shirts");
        cartPopUpSteps.clickProceedToCheckout();
        shoppingCartSteps.checkPaymentDetailsAreCorrect("Faded Short Sleeve T-shirts","7432221");
    }

    @Test
    public void buyAProductCompleteTestFlow(){
        mainSteps.clickOnWomenSection();
        catalogSteps.viewProductsAsList();
        catalogSteps.addProductToCart("Faded Short Sleeve T-shirts");
        cartPopUpSteps.clickProceedToCheckout();
        shoppingCartSteps.buyAProductCompleteTestFlow("Faded Short Sleeve T-shirts","7432221" );
    }
}
