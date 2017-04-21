package com.tests;

import com.steps.MainSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalindorgo on 3/14/2017.
 */

@RunWith(SerenityRunner.class)
public class MainTests {
    @Managed(uniqueSession = true)
    WebDriver webDriver;

    @Steps
    MainSteps mainSteps;

    @Before
    public void launchApplication(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void checkLogoPresence(){
        mainSteps.checkLogoPresence();
    }

    @Test
    public void checkShoppingCartPresence(){
        mainSteps.checkShoppingChartPresence();
    }

    @Test
    public void checkElementsPresenceFromWomenDropDown(){
        mainSteps.checkElementsPresenceFromWomenDropDown();
    }

    @Test
    public void checkElementsPresenceFromDressesDropDown(){
        mainSteps.checkElementsPresenceFromDressesDropDown();
    }

    @Test
    public void checkTShirtElementPresence(){
        mainSteps.checkTShirtElementPresence();
    }

    @Test
    public void checkBannersPresence(){
        mainSteps.checkBannersPresence();
    }

    @Test
    public void checkPopularAndBestSellersSectionsPresence(){
        mainSteps.checkPopularAndBestSellersSectionsPresence();
    }

    // just wanted to try this method.
    @Test
    public void scrollDown(){
        mainSteps.scrollDown(1);
    }
}
