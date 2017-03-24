package com.pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by catalindorgo on 3/15/2017.
 */
public class GeneralMethods extends PageObject {
    public static String userFirstName;
    public static String userMobilePhoneNumber;

    public void compareNumberOfProductsListedAgainstProductCounter(WebElement nrOfProducts, List<WebElement> entriesPerPage ){
        String productCounterString = nrOfProducts.getText();
        int productCounter = 0;
        if(entriesPerPage.size() == 1){
            char productCounterChar = productCounterString.charAt(9);
             productCounter = Character.getNumericValue(productCounterChar);
        }
        else if(entriesPerPage.size() > 1){
            char productCounterChar = productCounterString.charAt(10);
             productCounter = Character.getNumericValue(productCounterChar);
        }

        Assert.assertTrue("The number of listed products is not equal to the top product counter", productCounter  == entriesPerPage.size());
    }
    public void checkPageTitleAndBanner(WebElement pageTitle, WebElement banner){
        pageTitle.isDisplayed();
        banner.isDisplayed();
    }

    public void hoverOverWebElement(WebElement button){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(button).perform();
    }

}
