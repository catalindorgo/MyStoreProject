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



    public void checkWomenPageTitleAndBannerAndListedItems() {
        checkPageTitleAndBanner(womenPageTitle, womenBanner);
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void checkDressesPageTitleAndBannerAndListedItems(){
        checkPageTitleAndBanner(dressesPageTitle, dressesBanner );
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }
}
