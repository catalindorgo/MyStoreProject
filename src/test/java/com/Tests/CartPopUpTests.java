package com.Tests;

import com.Steps.CartPopUpSteps;
import com.pages.CartPopUpPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 3/22/2017.
 */
@RunWith(SerenityRunner.class)
public class CartPopUpTests {
    @Managed(uniqueSession = true)
    WebDriver webDriver;

    @Steps
    CartPopUpSteps cartPopUpSteps;

    @Test
    public void addProductToCartAndCheckIfSuccessfullyAdded(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        cartPopUpSteps.addProductToCartAndCheckIfSuccessfullyAdded("2");
    }

}
