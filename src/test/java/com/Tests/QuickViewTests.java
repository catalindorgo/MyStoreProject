package com.Tests;

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
    QuickViewTests quickViewTests;

    @Before
    public void launchFireFox(){
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();}

    @Test
    public void shareProductOnSocialNetwork(){}
}
