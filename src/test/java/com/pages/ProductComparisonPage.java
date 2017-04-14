package com.pages;

import com.steps.MainSteps;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

/**
 * Created by catalindorgo on 4/13/2017.
 */
public class ProductComparisonPage extends MainPage{

    @FindBy(xpath = "//h1[@class='page-heading']")
    public WebElement productComparisonPageHeader;

    @FindBy(xpath = "//ul[@class='footer_link']//a")
    private WebElement continueShoppingBottmButton;

    public void clickContinueShoppingButtonAndVerifyLandingPage(){
        continueShoppingBottmButton.click();
        Assert.assertTrue("The main banner is not displayed, meaning you were not redirected to main page", mainTopBanner.isDisplayed());
    }
}
