package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

/**
 * Created by catalindorgo on 3/14/2017.
 */
public class MainPage extends PageObject {
    @FindBy(xpath = "//a/img[@alt='My Store']")
    private WebElement siteLogo;

    @FindBy (xpath = "//div/a[@title='View my shopping cart']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//li/a[@title='Women']")
    private WebElement womenSection;

    @FindBy(xpath = "//li/ul/li/a[@title='T-shirts']")
    private WebElement tShirtSubSectionFromWomenSection;

    @FindBy(xpath = "//li/ul/li/a[@title='Blouses']")
    private WebElement blousesSubSectionFromWomenSection;

    @FindBy (xpath = " //ul[contains(@class, 'submenu')]//a[@title='Casual Dresses']")
    private WebElement casualDressesSubSectionFromWomenSection;

    @FindBy (xpath = "//ul[contains(@class, 'submenu')]//a[@title='Evening Dresses']")
    private WebElement eveningDressSubSectionFromWomenSection;

    @FindBy(xpath = "//ul[contains(@class, 'submenu')]//a[@title='Summer Dresses']")
    private WebElement summerDressSubSectionFromWomenSection;

    @FindBy(xpath = "//div/ul/li/a[@title='Dresses']")
    private WebElement dressesSection;

    @FindBy(xpath = "//ul[contains(@class, 'container')]/li/a[@title='Casual Dresses']")
    private WebElement casualDressSubSectionFromDressesSection;

    @FindBy(xpath = "//ul[contains(@class, 'container')]/li/a[@title='Evening Dresses']")
    private WebElement eveningDressSubSectionFromDressesSection;

    @FindBy(xpath = "//ul[contains(@class, 'container')]/li/a[@title='Summer Dresses']")
    private WebElement summerDressSubSectionFromDressesSection;

    @FindBy(xpath = "//li/a[@title='T-shirts']")
    private WebElement tShirtsSection;

    @FindBy(xpath = "//div[@id='homepage-slider']")
    private WebElement mainTopBanner;

    @FindBy(xpath = "//div[@id='htmlcontent_top']")
    private WebElement secondaryTopBanner;

    @FindBy(xpath = "//div[@id='htmlcontent_home']")
    private WebElement bottomBannerGroup;

    @FindBy(xpath = "//a[contains(text(), 'Popular')]")
    private WebElement popularSection;

    @FindBy(xpath = "//a[contains(text(), 'Sellers')]")
    private WebElement bestSellesrSection;

    public void checkElementsPresenceFromWomenDropDown(){
        Actions actions = new Actions(getDriver());
        womenSection.isDisplayed();
        actions.moveToElement(womenSection).perform();
        tShirtSubSectionFromWomenSection.isDisplayed();
        blousesSubSectionFromWomenSection.isDisplayed();
        casualDressesSubSectionFromWomenSection.isDisplayed();
        eveningDressSubSectionFromWomenSection.isDisplayed();
        summerDressSubSectionFromWomenSection.isDisplayed();
    }
    public void checkLogoPresence(){
        siteLogo.isDisplayed();
    }

    public void checkShoppingChartPresence(){shoppingCart.isDisplayed();}

    public void checkElementsPresenceFromDressesDropDown(){
        Actions actions = new Actions(getDriver());
        dressesSection.isDisplayed();
        actions.moveToElement(dressesSection).perform();
        casualDressSubSectionFromDressesSection.isDisplayed();
        eveningDressSubSectionFromDressesSection.isDisplayed();
        summerDressSubSectionFromDressesSection.isDisplayed();
    }

    public void checkTShirtElementPresence(){
        tShirtsSection.isDisplayed();
    }

    public void checkBannersPresence(){
        mainTopBanner.isDisplayed();
        secondaryTopBanner.isDisplayed();
        bottomBannerGroup.isDisplayed();
    }
    public void checkPopularAndBestSellersSectionsPresence(){
        popularSection.isDisplayed();
        bestSellesrSection.isDisplayed();
    }

    public void clickOnWomenSection(){
       womenSection.click();
    }
    public void clickOnDressesSection(){
        dressesSection.click();
    }

}

