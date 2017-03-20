package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

   // @FindBy(xpath = "//li/div/div/div/span[@itemprop]")
    //@FindBy(xpath = "//div[@id='center_column']//div[@class='right-block']//span[@itemprop='price']")
    //private List<WebElement> priceOfProductList;

    @FindBy(xpath = "//div[@id='uniform-selectProductSort']")
    private WebElement sortByDropDownButton;

    @FindBy(xpath = "//select[@id='selectProductSort']/option[@value='position:asc']")
    private WebElement sortByPriceLowToHigh;

    String LIST_OF_PRODUCT_PRICES = "//form[@id='productsSortForm']//span[text()='%value%']/../../../../../..//li/div/div/div/span[@itemprop]";

    public void checkWomenPageTitleAndBannerAndListedItems() {
        checkPageTitleAndBanner(womenPageTitle, womenBanner);
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void checkDressesPageTitleAndBannerAndListedItems() {
        checkPageTitleAndBanner(dressesPageTitle, dressesBanner);
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void checkTShirtTitleAndBannerAndListedItems() {
        checkPageTitleAndBanner(tShirtPageTitle, tShirtBanner);
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void checkBlousesSubsectionsTitleBannerAndListeItmes() {
        checkPageTitleAndBanner(blousesPageTItle, blousesBanner);
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void checkTShirtSubsectionsTitleBannerAndListeItmes() {
        checkPageTitleAndBanner(tShirtPageTitle, tShirtBanner);
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void checkCasualDressesSubSectionFromDressesTitleBannerAndListedItems() {
        checkPageTitleAndBanner(casualDressesPageTitle, casualDressesBanner);
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }
    public void sortByPriceLowToHigh(String sortByOption){
        sortByDropDownButton.click();
        WebElement dropdown = getDriver().findElement(By.id("selectProductSort"));
        Select dropdown1 = new Select(dropdown);
        dropdown1.selectByVisibleText(sortByOption);
        waitABit(2000);


    }
    public void checkIfProductsAreSoretedByPriceLowToHigh(String sortByOption) {
        List<Double> priceList = new ArrayList<Double>();
        int productPositionInList;
        boolean a = false;
        List<WebElement> listOfProductPrices = getDriver().findElements(By.xpath(LIST_OF_PRODUCT_PRICES.replace("%value%", sortByOption)));
        for (WebElement wb : listOfProductPrices) {

            String priceString = wb.getText();
            System.out.println(priceString);

            double priceFloat = Double.parseDouble(priceString);
            priceList.add(priceFloat);
            System.out.println(priceString);
        }

        for (productPositionInList = 1; productPositionInList < priceList.size(); productPositionInList++) {
            if (priceList.get(productPositionInList-1) < priceList.get(productPositionInList)) {
                a = true;
            }else {
                a = false;
                break;
            }
        }
        Assert.assertTrue("not sorted correctly", a == true);
    }
}