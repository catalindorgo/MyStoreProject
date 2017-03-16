package com.pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by catalindorgo on 3/15/2017.
 */
public class GeneralMethods extends PageObject {
    public void compareNumberOfProductsListedAgainstProductCounter(WebElement nrOfProducts, List<WebElement> entriesPerPage ){
        String productCounterString = nrOfProducts.getText();
        char productCounterChar = productCounterString.charAt(10);
        int productCounter = Character.getNumericValue(productCounterChar);
        Assert.assertTrue("The number of listed products are not equal to the top product counter", productCounter == entriesPerPage.size());
    }
    public void checkPageTitleAndBanner(WebElement pageTitle, WebElement banner){
        pageTitle.isDisplayed();
        banner.isDisplayed();
    }

}
