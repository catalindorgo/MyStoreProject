package com.Tests;

import com.Steps.AuthenticationSteps;
import com.Steps.ShoppingCartSteps;
import com.pages.MainPage;
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
    WebDriver webDriver;
    @Steps
    ShoppingCartSteps shoppingCartSteps;
    @Steps
    AuthenticationSteps authenticationSteps;

    @Before
    public void userLogIn(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        authenticationSteps.logInAndVerifyAccount("admin@yahoo.ro", "password", "Admin lastName");
    }
    @Test
    public void addProductToCartAndCheckIfPresentInShoppingSummary(){
        shoppingCartSteps.addProductToCartAndCheckIfPresentInShoppingSummary("1");
    }

    @Test
    public void checkAddressPageDetailsAreCorrect(){
        shoppingCartSteps.checkAddressPageDetailsAreCorrect("1", "7432221");
    }

    @Test
    public void checkShippingPageDetailsAreCorrect(){
        shoppingCartSteps.checkShippingPageDetailsAreCorrect("1", "7432221");
    }
    @Test
    public void checkPaymentDetailsAreCorrect(){
        shoppingCartSteps.checkPaymentDetailsAreCorrect("1","7432221");
    }
    @Test
    public void buyAProductCompleteTestFlow(){
        shoppingCartSteps.buyAProductCompleteTestFlow("1","7432221" );
    }
}
