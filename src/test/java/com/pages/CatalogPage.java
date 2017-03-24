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
import java.util.Collections;
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

    @FindBy(xpath = "//form[@id='productsSortForm']//span[text()='In stock']/../../../../../..//li//span[@class='available-now']")
    private List<WebElement> listOfProductsInStockAttribute;

    @FindBy(xpath = "//form[@id='productsSortForm']//span[text()='Product Name: A to Z']/../../../../../..//li//a[@class='product-name']")
    private List<WebElement> listOfProductsNamesAtoZ;

    @FindBy(xpath = "//form[@id='productsSortForm']//span[text()='Product Name: Z to A']/../../../../../..//li//a[@class='product-name']")
    private List<WebElement> listOfProductsNamesZtoA;

    @FindBy(xpath = "//li/a[text()='List']")
    private WebElement listViewButton;

    String LIST_OF_PRODUCT_PRICES = "//form[@id='productsSortForm']//span[text()='%value%']/../../../../../..//li/div/div/div/span[@itemprop]";
    String LIST_OF_CHECKBOX_TEXT = "//input[@type='checkbox']/../../..//a[text()='%value%']";
    String LIST_OF_COLOR_CHECKBOX = "//label[@class='layered_color']/a[text()='%value%']";
    String LIST_OF_PRODUCT_NAMES ="(//div/div/h5/a)[%value%]";
    String LIST_OF_ADD_TO_CART_BUTTONS ="(//div/a/span[text()='Add to cart'])[%value%]";
    public static String PRODUCT_NAME;


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
    public void sortByUserOption(String sortByOption){
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

            String priceString = wb.getAttribute("innerHTML").replace("$", "");
            System.out.println(  priceString);
            double priceFloat = Double.parseDouble(priceString);
            priceList.add(priceFloat);
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
    public void checkIfProductsAreSoretedByPriceHighToLow(String sortByOption) {
        List<Double> priceList = new ArrayList<Double>();
        int productPositionInList;
        boolean a = false;
        List<WebElement> listOfProductPrices = getDriver().findElements(By.xpath(LIST_OF_PRODUCT_PRICES.replace("%value%", sortByOption)));
        for (WebElement wb : listOfProductPrices) {

            String priceString = wb.getAttribute("innerHTML").replace("$", "");
            System.out.println(  priceString);
            double priceFloat = Double.parseDouble(priceString);
            priceList.add(priceFloat);
        }

        for (productPositionInList = 1; productPositionInList < priceList.size(); productPositionInList++) {
            if (priceList.get(productPositionInList-1) > priceList.get(productPositionInList)) {
                a = true;
            }else {
                a = false;
                break;
            }
        }
        Assert.assertTrue("not sorted correctly", a == true);
    }

    public void checkIfProductIsInStock(){
        for (WebElement webElement : listOfProductsInStockAttribute){
            Assert.assertTrue("Your product is not on stock", webElement.getText().contains("In stock"));
            System.out.println(webElement);
        }
    }

    public void checkIfProductsAreSortedAlphabeticallyAtoZ(){
        List<String> productNamesDefaultOrderList = new ArrayList<>();
        List<String> productNamesSortedAtoZ = new ArrayList<>();

        for(WebElement we : listOfProductsNamesAtoZ){
            productNamesDefaultOrderList.add(we.getText());}
        for(String nameString : productNamesDefaultOrderList){
                productNamesSortedAtoZ.add(nameString);}

        Collections.sort(productNamesSortedAtoZ);
        System.out.println(productNamesSortedAtoZ);
        System.out.println("original list"+ productNamesDefaultOrderList);
        Assert.assertTrue("Your list is not ordered A to Z", productNamesSortedAtoZ.equals(productNamesDefaultOrderList));
    }
    public void checkIfProductsAreSortedAlphabeticallyZtoA(){
        List<String> productNamesDefaultOrderList = new ArrayList<>();
        List<String> productNamesSortedAtoZ = new ArrayList<>();

        for(WebElement we : listOfProductsNamesZtoA){
            productNamesDefaultOrderList.add(we.getText());}
        for(String nameString : productNamesDefaultOrderList){
            productNamesSortedAtoZ.add(nameString);}

        Collections.sort(productNamesSortedAtoZ);
        Collections.reverse(productNamesSortedAtoZ);

        System.out.println(productNamesSortedAtoZ);
        System.out.println("original list"+ productNamesDefaultOrderList);
        Assert.assertTrue("Your list is not ordered Z to A", productNamesSortedAtoZ.equals(productNamesDefaultOrderList));

    }

    public void clickCatalogCheckbox(String checkboxName){
        WebElement checkbox = getDriver().findElement(By.xpath(LIST_OF_CHECKBOX_TEXT.replace("%value%", checkboxName)));
        checkbox.click();
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void clickColorCheckbox(String checkboxColorName){
        WebElement checkbox = getDriver().findElement(By.xpath(LIST_OF_COLOR_CHECKBOX.replace("%value%", checkboxColorName)));
        checkbox.click();
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void addProductToCart (String productIndex){
        WebElement product = getDriver().findElement(By.xpath(LIST_OF_PRODUCT_NAMES.replace("%value%", productIndex)));
        WebElement addToCartButton = getDriver().findElement(By.xpath(LIST_OF_ADD_TO_CART_BUTTONS.replace("%value%", productIndex)));
        addToCartButton.click();
        PRODUCT_NAME = product.getText();
        System.out.println(PRODUCT_NAME +  "   first");
    }

    public void selectPriceRange(){}

    public void viewProductsAsList(){
        listViewButton.click();
    }


}