package com.tests;

import com.steps.CartPopUpSteps;
import com.steps.CatalogSteps;
import com.steps.MainSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
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
    MainSteps mainSteps;
    @Steps
    CartPopUpSteps cartPopUpSteps;
    @Steps
    CatalogSteps catalogSteps;

    @Before
    public void launchFireFox(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void addProductToCartAndCheckIfSuccessfullyAdded(){
        mainSteps.clickOnWomenSection();
        catalogSteps.viewProductsAsList();
        catalogSteps.addProductToCart("Faded Short Sleeve T-shirts");
        cartPopUpSteps.addProductToCartAndCheckIfSuccessfullyAdded("Faded Short Sleeve T-shirts");
    }

}
