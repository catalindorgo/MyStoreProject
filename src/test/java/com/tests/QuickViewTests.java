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
        catalogSteps.quickViewProduct("Blouse");
        catalogSteps.switchToQuickViewPopUp();
        //metoda de mai jos nu merge bine inca.
        quickViewSteps.shareProductOnSocialNetworkAndCheckLaunchedPopUp("facebook");
    }

    @Test
    public void addProductToWishListAndCheckConfirmation()   {
        mainSteps.clickOnWomenSection();
        catalogSteps.quickViewProduct("Blouse");
        catalogSteps.switchToQuickViewPopUp();
        quickViewSteps.addProductToWishListAndCheckConfirmation();
    }
    @Test
    public void checkProductNameIsCorrect(){
        mainSteps.clickOnWomenSection();
        catalogSteps.quickViewProduct("Blouse");
        catalogSteps.switchToQuickViewPopUp();
        quickViewSteps.checkProductNameIsCorrect("Blouse");
    }
}
