package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        Assert.assertTrue("The expected current page title is not displayed", pageTitle.isDisplayed());
        Assert.assertTrue("The expected current page banner is not displayed ", banner.isDisplayed());
    }

    public void hoverOverWebElement(WebElement button){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(button).perform();
    }

    public void waitMethod(WebElement element){
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 4);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void switchToLaunchedPopUp(){
        String parentHandle = getDriver().getWindowHandle();
        ArrayList<String> tabListHandles = new ArrayList<String>(getDriver().getWindowHandles());

        for (String windowHandle : tabListHandles){
            if(!windowHandle.contentEquals(parentHandle) ){
                getDriver().switchTo().window(windowHandle);
            }
        }
    }

    public void switchToFrame(WebElement iFrameName){
        getDriver().switchTo().frame(iFrameName);
    }

}
