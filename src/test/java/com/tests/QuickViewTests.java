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
    @Steps
    AuthenticationSteps authenticationSteps;
    @Steps
    ToolBarSteps toolBarSteps;


    @Before
    public void launchFireFox(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void shareProductOnSocialNetworkAndChekLauncedPopUp(){
        mainSteps.clickOnWomenSection();
        catalogSteps.quickViewProduct("Blouse");
        catalogSteps.switchToQuickViewPopUp();
        quickViewSteps.shareProductOnSocialNetworkAndCheckLaunchedPopUpsURL("facebook");
    }

    @Test
    public void addProductToWishListAndCheckConfirmation()   {
        toolBarSteps.clickSignInButton();
        authenticationSteps.logInAndVerifyAccount("admin@yahoo.ro", "password", "Admin lastName");
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

    @Test
    public void increaseProductQuantityAndCheckQuantityFieldInput(){
        mainSteps.clickOnWomenSection();
        catalogSteps.quickViewProduct("Blouse");
        catalogSteps.switchToQuickViewPopUp();
        quickViewSteps.increaseProductQuantity(3);
    }
}
