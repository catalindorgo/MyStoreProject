package com.tests;

import com.steps.CatalogSteps;
import com.steps.MainSteps;
import com.steps.QuickViewSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 3/27/2017.
 */
@RunWith(SerenityRunner.class)
public class QuickViewTests {
    @Managed(uniqueSession = true)
    WebDriver webDriver;

    @Steps
    QuickViewSteps quickViewSteps;
    @Steps
    MainSteps mainSteps;
    @Steps
    CatalogSteps catalogSteps;

    @Before
    public void launchFireFox(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void shareProductOnSocialNetworkAndChekLauncedPopUp(){
        mainSteps.clickOnWomenSection();
        catalogSteps.quickViewProduct("1");
        quickViewSteps.shareProductOnSocialNetworkAndCheckLaunchedPopUp("facebook",  0);
    }

    @Test
    public void addProductToWishList()   {
        mainSteps.clickOnWomenSection();
        catalogSteps.quickViewProduct("1");
        quickViewSteps.addProductToWishList(1);
    }
    @Test
    public void checkProductNameIsCorrect(){
        mainSteps.clickOnWomenSection();
        catalogSteps.quickViewProduct("1");
        quickViewSteps.checkProductNameIsCorrect("1");
    }
}
