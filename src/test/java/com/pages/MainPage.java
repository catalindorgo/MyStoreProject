package com.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by catalindorgo on 3/14/2017.
 */
public class MainPage extends GeneralMethods {
    private String PRODUCT_MAIN_SECTIONS_FROM_PAGE_TOP ="//div/ul/li/a[@title='%value%']";

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

    @FindBy (xpath = " //a[@title='Women']/..//a[@title='Casual Dresses']")
    private WebElement casualDressesSubSectionFromWomenSection;

    @FindBy (xpath = "//a[@title='Women']/..//a[@title='Evening Dresses']")
    private WebElement eveningDressSubSectionFromWomenSection;

    @FindBy(xpath = "//a[@title='Women']/..//a[@title='Summer Dresses']")
    private WebElement summerDressSubSectionFromWomenSection;

    @FindBy(xpath = "//div/ul/li/a[@title='Dresses']")
    private WebElement dressesSection;

    @FindBy(xpath = "//ul[contains(@class, 'submenu')]/li/a[@title='Casual Dresses']")
    private WebElement casualDressSubSectionFromDressesSection;

    @FindBy(xpath = "//ul[contains(@class, 'submenu')]/li/a[@title='Evening Dresses']")
    private WebElement eveningDressSubSectionFromDressesSection;

    @FindBy(xpath = "//ul[contains(@class, 'submenu')]/li/a[@title='Summer Dresses']")
    private WebElement summerDressSubSectionFromDressesSection;

    @FindBy(xpath = "//div/ul/li/a[@title='T-shirts']")
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
    private WebElement bestSealersSection;

    @FindBy(xpath = ".//form[@id='searchbox']/input[@class]")
    private WebElement searchBoxField;

    @FindBy(xpath = ".//form[@id='searchbox']/button")
    private WebElement searchBoxGoButton;

    @FindBy(xpath = "//div[contains(@class, 'breadcrumb')]")
    private WebElement pageHeaderBreadCrumb;

    private void clickOnTopMainProductsSection(String mainSectionTitle){
        WebElement mainSection = getDriver().findElement(By.xpath(PRODUCT_MAIN_SECTIONS_FROM_PAGE_TOP.replace("%value%", mainSectionTitle)));
        mainSection.click();
    }

    public void checkElementsPresenceFromWomenDropDown(){
        Actions actions = new Actions(getDriver());
        womenSection.isDisplayed();
        actions.moveToElement(womenSection).perform();
        Assert.assertTrue("The tShirt subsection element is not displayed on page", tShirtSubSectionFromWomenSection.isDisplayed());
        Assert.assertTrue("The blouses subsection element is not displayed on page", blousesSubSectionFromWomenSection.isDisplayed());
        Assert.assertTrue("The casual dresses element is not displayed on page", casualDressesSubSectionFromWomenSection.isDisplayed());
        Assert.assertTrue("The evening dresses element is not displayed on page", eveningDressSubSectionFromWomenSection.isDisplayed());
        Assert.assertTrue("The summer dresses element is not displayed on page",summerDressSubSectionFromWomenSection.isDisplayed() );

    }
    public void checkLogoPresence(){
        Assert.assertTrue("The sites Logo is not displayed", siteLogo.isDisplayed());
    }

    public void checkShoppingChartPresence(){Assert.assertTrue("The shoping cart element is not displayed", shoppingCart.isDisplayed());}

    public void checkElementsPresenceFromDressesDropDown(){
        Actions actions = new Actions(getDriver());
        dressesSection.isDisplayed();
        actions.moveToElement(dressesSection).perform();
        Assert.assertTrue("The casual Dresses subsection is not displayed", casualDressSubSectionFromDressesSection.isDisplayed());
        Assert.assertTrue("The evening dress subsection is not displayed on page", eveningDressSubSectionFromDressesSection.isDisplayed());
        Assert.assertTrue("The summer Dress subsection is not displayed on page",summerDressSubSectionFromDressesSection.isDisplayed() );
    }

    public void checkTShirtElementPresence(){
       Assert.assertTrue("The tShirt Section is not displayed on page", tShirtsSection.isDisplayed());
    }

    public void checkBannersPresence(){
        Assert.assertTrue("The main top banner is not displayed on page",mainTopBanner.isDisplayed());
        Assert.assertTrue("The secondary banner is not displayed on page", secondaryTopBanner.isDisplayed());
        Assert.assertTrue("The bottom banner is not displayed on page", bottomBannerGroup.isDisplayed());
    }
    public void checkPopularAndBestSellersSectionsPresence(){
        Assert.assertTrue("The popular section is not displayed on page", popularSection.isDisplayed());
        Assert.assertTrue("The Best sellers section is not displayed", bestSealersSection.isDisplayed());
    }

    public void clickOnWomenSectionAndVerifyLandingPageBreadCrumb(){
       clickOnTopMainProductsSection("Women");
       Assert.assertTrue("The Women bread crumb title was not displayed", pageHeaderBreadCrumb.getText().contains("Women"));
    }
    public void clickOnDressesSectionAndVerifyLandingPageBreadCrumb(){
        clickOnTopMainProductsSection( "Dresses");
        Assert.assertTrue("The landing page bread crumb does not contain the Dresses text", pageHeaderBreadCrumb.getText().contains("Dresses"));
    }

    public void clickTShirtSectionAndVerifyLandingPageBreadCrumb(){
        clickOnTopMainProductsSection("T-shirts");
        Assert.assertTrue("The landing page bread crumb does not contain the T shirts text", pageHeaderBreadCrumb.getText().contains("T-shirts"));
        }

    public void selectBlousesSubSection(){
        hoverOverWebElement(womenSection);
        blousesSubSectionFromWomenSection.click();
    }
    public void selectTShirtSubSection(){
        hoverOverWebElement(womenSection);
        tShirtSubSectionFromWomenSection.click();
    }
    public void selectCasualDressesSubSectionFromDresses(){
        hoverOverWebElement(dressesSection);
        casualDressSubSectionFromDressesSection.click();
    }
    public void searchForTerm(String searchTerm){
        searchBoxField.click();
        searchBoxField.sendKeys(searchTerm);
        searchBoxGoButton.click();
    }
}

