package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import javax.validation.constraints.AssertTrue;
import java.util.List;

/**
 * Created by catalindorgo on 3/15/2017.
 */
public class CatalogPage extends GeneralMethods {
    @FindBy(xpath = "//div[@class='rte']//p[contains(text(), 'category includes all ')]")
    private WebElement womenBanner;

    @FindBy(xpath = "//h1/span[contains(text(), 'Women')]")
    private WebElement womenPageTitle;

    @FindBy(xpath = "//ul/li[contains(@class, 'block_product')]")
    private List<WebElement> listOfProductsPerPage;

    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement numberOfProductsCounterPerPage;

    @FindBy(xpath = "//h1/span[contains(text(), 'Dresses')]")
    private WebElement dressesPageTitle;

    @FindBy(xpath = "//div[@class='rte']//p[contains(text(), 'We offer dresses ')]")
    private WebElement dressesBanner;

    @FindBy(xpath = "//h1/span[contains(text(), 'T-sh')]")
    private WebElement tShirtPageTitle;

    @FindBy(xpath = "//div[@class='rte']//p[contains(text(), 'must have')]")
    private WebElement tShirtBanner;

    @FindBy(xpath = "//div[@class='content_scene_cat_bg']")
    private WebElement blousesBanner;

    @FindBy(xpath = "//h1/span[contains(text(), 'Blouses')]")
    private WebElement blousesPageTItle;

    @FindBy(xpath = "//h1/span[contains(text(), 'Casual')]")
    private WebElement casualDressesPageTitle;

    @FindBy(xpath = "//div[@class='rte']//p[contains(text(), 'every day')]")
    private WebElement casualDressesBanner;


    public void checkWomenPageTitleAndBannerAndListedItems() {
        checkPageTitleAndBanner(womenPageTitle, womenBanner);
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void checkDressesPageTitleAndBannerAndListedItems(){
        checkPageTitleAndBanner(dressesPageTitle, dressesBanner );
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void checkTShirtTitleAndBannerAndListedItems(){
        checkPageTitleAndBanner(tShirtPageTitle, tShirtBanner);
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void checkBlousesSubsectionsTitleBannerAndListeItmes(){
        checkPageTitleAndBanner(blousesPageTItle, blousesBanner);
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void checkTShirtSubsectionsTitleBannerAndListeItmes() {
        checkPageTitleAndBanner(tShirtPageTitle, tShirtBanner);
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }
    public void checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems(){
        checkPageTitleAndBanner(casualDressesPageTitle, casualDressesBanner);
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }
}
