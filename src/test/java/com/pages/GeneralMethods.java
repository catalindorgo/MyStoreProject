package com.pages;

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
        pageTitle.isDisplayed();
        banner.isDisplayed();
    }

    public void hoverOverWebElement(WebElement button){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(button).perform();
    }

    public void waitMethod(WebElement element){
        WebDriver driver = new WebDriver() {
            @Override
            public void get(String url) {

            }

            @Override
            public String getCurrentUrl() {
                return null;
            }

            @Override
            public String getTitle() {
                return null;
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return null;
            }

            @Override
            public String getPageSource() {
                return null;
            }

            @Override
            public void close() {

            }

            @Override
            public void quit() {

            }

            @Override
            public Set<String> getWindowHandles() {
                return null;
            }

            @Override
            public String getWindowHandle() {
                return null;
            }

            @Override
            public TargetLocator switchTo() {
                return null;
            }

            @Override
            public Navigation navigate() {
                return null;
            }

            @Override
            public Options manage() {
                return null;
            }
        };
        WebDriverWait webDriverWait = new WebDriverWait(driver, 4);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void switchToLaunchedPopUp(Integer tabNumber){
        ArrayList<String> tabList = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabList.get(tabNumber));
        System.out.println("U   R     L" + getDriver().getCurrentUrl());
    }

}
