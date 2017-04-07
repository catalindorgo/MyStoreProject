package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by catalindorgo on 3/15/2017.
 */
public class CatalogPage extends GeneralMethods {

    @FindBy(xpath = "//div[contains(@class, 'rte')]")
    private WebElement pageBannerText;

    @FindBy(xpath = "//span[contains(@class, 'cat-name')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//li[contains(@class, 'block_product')]")
    private List<WebElement> listOfProductsPerPage;

    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement numberOfProductsCounterPerPage;

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

    @FindBy(xpath = "//div/iframe")
    private WebElement quickViewWindowiFrame;

    @FindBy(xpath = "//ul[contains(@class, 'product_list')]")
    private WebElement entireProductListBodyOnCurrentPage;


    String LIST_OF_PRODUCT_PRICES = "//form[@id='productsSortForm']//span[text()='%value%']/../../../../../..//li/div/div/div/span[@itemprop]";
    String LIST_OF_CHECKBOX_TEXT = "//input[@type='checkbox']/../../..//a[text()='%value%']";
    String LIST_OF_COLOR_CHECKBOX = "//label[@class='layered_color']/a[text()='%value%']";
    String PRODUCT_NAME ="//div/div/h5/a[@title='%value%']";
    String PRODUCT_IMAGES = "//img[@title='%value%']";
    String ADD_TO_CART_BUTTON ="//h5/a[@title='%value%']/../../../div//a[contains(@class, 'add_to_cart')]";
    String QUICK_VIEW_BUTTONS ="//img[@title='%value%']/../../a[@class='quick-view']";



    public void checkIfPageTitleBannerAndListedItemsAreCorrectlyDisplayed() {
        checkPageTitleAndBanner(pageTitle, pageBannerText);
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

    public void clickACatalogCheckboxAndVerifyFilteringIsApplied(String checkboxName){
        WebElement checkbox = getDriver().findElement(By.xpath(LIST_OF_CHECKBOX_TEXT.replace("%value%", checkboxName)));
        checkbox.click();
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void clickColorCheckboxAndVerifyFilteringIsApplied(String checkboxColorName){
        WebElement checkbox = getDriver().findElement(By.xpath(LIST_OF_COLOR_CHECKBOX.replace("%value%", checkboxColorName)));
        checkbox.click();
        compareNumberOfProductsListedAgainstProductCounter(numberOfProductsCounterPerPage, listOfProductsPerPage);
    }

    public void addProductToCart (String producTitle){
        //WebElement product = getDriver().findElement(By.xpath(LIST_OF_PRODUCT_NAMES.replace("%value%", productIndex)));
        WebElement addToCartButton = getDriver().findElement(By.xpath(ADD_TO_CART_BUTTON.replace("%value%", producTitle)));
        //PRODUCT_NAME = product.getText();
        addToCartButton.click();
        //System.out.println( +  "   first");
    }

    public void quickViewProduct(String productTitle){
        WebElement productImage = getDriver().findElement(By.xpath(PRODUCT_IMAGES.replace("%value%", productTitle)));
        WebElement productQuickViewButton = getDriver().findElement(By.xpath(QUICK_VIEW_BUTTONS.replace("%value%", productTitle)));
        hoverOverWebElement(productImage);
        productQuickViewButton.click();
    }

    public void switchToQuickViewPopUp(){
        switchToFrame(quickViewWindowiFrame);
    }

    public void selectPriceRange(){}

    public void viewProductsAsList(){
        listViewButton.click();
       // System.out.print("aaaaaaaaaaaaaaa" + entireProductListBodyOnCurrentPage);
    }


}