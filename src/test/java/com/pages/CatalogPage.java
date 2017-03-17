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

    @FindBy(xpath = "//li/div/div/div/span[@itemprop]")
    private List<WebElement> priceOfProductList;

    @FindBy(xpath = "//form[@id='productsSortForm']")
    private WebElement sortByDropDownButton;

    @FindBy(xpath = "//select[@id='selectProductSort']/option[@value='position:asc']")
    private WebElement sortByPriceLowToHigh;

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
    public void sortByPriceLowToHigh(){
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
        webDriverWait.until(ExpectedConditions.visibilityOf(sortByDropDownButton));
        sortByDropDownButton.click();
        // nu reusesc sa selectez nicio optiune din acest drop down. Fie cu index fie cu selectbytext sau mai rau cu click.
        Select dropdown = new Select(sortByDropDownButton);
        dropdown.selectByIndex(2);



    }
    public void checkIfProductsAreSoretedByPriceLowToHigh() {
        List<Integer> priceList = new ArrayList<Integer>();
        int i;
        boolean a = false;

        for (WebElement wb : priceOfProductList) {
            String priceString = wb.getText().substring(1, 3);
            int priceInteger = Integer.parseInt(priceString);
            priceList.add(priceInteger);
            System.out.println(priceString);
        }

        for (i = 1; i < priceList.size(); i++) {
            if (priceList.get(i-1) > priceList.get(i)) {
                a = true;
            }else {
                a = false;
                break;
            }
        }
        Assert.assertTrue("not sorted correctly", a == true);
    }
}