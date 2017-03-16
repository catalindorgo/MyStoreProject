package com.Tests;

import com.Steps.MainSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
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

    @Test
    public void checkLogoPresence(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        mainSteps.checkLogoPresence();
    }
    @Test
    public void checkShoppingChartPresence(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        mainSteps.checkShoppingChartPresence();
    }
    @Test
    public void checkElementsPresenceFromWomenDropDown(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        mainSteps.checkElementsPresenceFromWomenDropDown();
    }

    @Test
    public void checkElementsPresenceFromDressesDropDown(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        mainSteps.checkElementsPresenceFromDressesDropDown();
    }
    @Test
    public void checkTshirtElementPresence(){
        webDriver.get("http://automationpractice.com/index.php");
        checkTshirtElementPresence();
    }
    @Test
    public void checkBannersPresence(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        mainSteps.checkBannersPresence();
    }
    @Test
    public void checkPopularAndBestSellersSectionsPresence(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        mainSteps.checkPopularAndBestSellersSectionsPresence();
    }
}
