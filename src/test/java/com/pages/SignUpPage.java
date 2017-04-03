package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 * Created by catalindorgo on 3/10/2017.
 */
public class SignUpPage extends GeneralMethods {

    private String ERROR_MESSAGE_FOR_INVALID_CREDENTIALS = "//div//div[@class='alert alert-danger']";
    private String DAY_OF_BIRTH = "//select[@id='days']//option[@value='%value%']";
    private String MONTH_OF_BIRTH = "//select[@id='months']//option[contains(text(), '%value%')]";
    private String YEAR_OF_BIRTH = "//select[@id='years']//option[contains(text(), '%value%')]";
    private String STATE = "//select[@id='id_state']//option[contains(text(), '%value%')]";

    @FindBy(xpath = "//h1[text()= 'Create an account']")
    private WebElement signUpPageTitle;

    @FindBy(xpath = "//button/span[contains(text(), 'Register')]")
    private WebElement registerButton;

    //TODO: change xpaths to private String mrs_msRadioButton = .//div[contains(@class,'radio')]//bla bla text() and if it works change "selectGender" method accordingly

    @FindBy(xpath = "//div//label[@for='id_gender2']")
    private WebElement mrsButton;

    @FindBy(xpath = "//div//label[@for='id_gender1']")
    private WebElement mrButton;

    @FindBy(xpath = "//input[@name='customer_firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='customer_lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[contains(@class,'required')]//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//div[contains(@class,'required')]//input[@name='passwd']")
    private WebElement passwordField;

    //TODO: XPATH proposal? //div[contains(@id,'days')] to avoid //div[@class='col-xs-4']

    @FindBy(xpath = "//div[@class='col-xs-4']/div[@id='uniform-days']")
    private WebElement dayOfBirthDropDown;

    @FindBy(xpath = "//div[@class='col-xs-4']/div[@id='uniform-months']")
    private WebElement monthsDropDown;

    @FindBy(xpath = "//div[@class='col-xs-4']/div[@id='uniform-years']")
    private WebElement yearsDropDown;

    @FindBy(xpath = "//p/input[@name='firstname']")
    private WebElement addressFirstName;

    @FindBy(xpath = "//p/input[@name='lastname']")
    private WebElement addressLastName;

    @FindBy(xpath = "//p/input[@name='address1']")
    private WebElement addressAddress1;

    @FindBy(xpath = "//p/input[@name='city']")
    private WebElement cityField;

    @FindBy(xpath = "//p/div[@id='uniform-id_state']")
    private WebElement stateDropDown;

    @FindBy(xpath = "//p/input[@name='phone_mobile']")
    private WebElement mobilePhone;

    @FindBy(xpath = "//p/input[@name='alias']")
    private WebElement aliasAddress;

    @FindBy(xpath = "//p/input[@name='postcode']")
    private WebElement zipCode;

    //TODO: Wrong xpath- you identify the element and get text
    @FindBy(xpath = "//div/p[contains(text(), 'Welcome to your account')]")
    private WebElement welcomeToAccountText;

    @FindBy(xpath = "//div/button[@name='submitAccount']")
    private WebElement submitAccountButton;


    public void verifyCurrentPageTitle(String expectedPageTitle) {
        System.out.print(signUpPageTitle);
        Assert.assertTrue("page title not found", expectedPageTitle.contentEquals(signUpPageTitle.getText()));
    }

    public void waitForSignUpPageHeader() {
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
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(signUpPageTitle));
    }

    /*TODO: Change the method to reflect what you intend to do in the test
      TODO: Question: Why did you declare "ERROR_MESSAGE_FOR_INVALID_CREDENTIALS" as a String and not used @FindBy?
    */
    public void registerWithInvalidCredentialsAndVerifyThrownError() {
        registerButton.click();
        Assert.assertTrue("Error message not thrown", getDriver().findElement(By.xpath(ERROR_MESSAGE_FOR_INVALID_CREDENTIALS)).isDisplayed());
    }

    /*
    TODO: I don't think we need the or in the id clause. We should use only the value that the user sees on the screen- Mr. and Mrs.
     */
    public void selectGender(String gender) {
        if (gender == "Mr." || gender == "Mr" || gender == "mr") {
            mrButton.click();
        } else if (gender == "Mrs" || gender == "Mrs." || gender == "mrs") {
            mrsButton.click();
        }
    }
/*TODO: Duplicated methods; use only one private method parameterised
  TODO: Try to use Select for this method
  */

    public void selectDateOfBirth(String dayOfBirth) {
        dayOfBirthDropDown.click();
        WebElement theDayOfBirth = getDriver().findElement(By.xpath(DAY_OF_BIRTH.replace("%value%", dayOfBirth)));
        theDayOfBirth.click();
    }

    public void selectMonth(String month) {
        WebElement monthOfBirth = getDriver().findElement(By.xpath(MONTH_OF_BIRTH.replace("%value%", month)));
        monthsDropDown.click();
        monthOfBirth.click();
    }

    public void selectYear(String year) {
        WebElement yearOfBirth = getDriver().findElement(By.xpath(YEAR_OF_BIRTH.replace("%value%", year)));
        yearsDropDown.click();
        yearOfBirth.click();
    }

    public void selectState(String state) {
        WebElement theState = getDriver().findElement(By.xpath(STATE.replace("%value%", state)));
        stateDropDown.click();
        theState.click();
    }

    /*
    TODO: Remove userMobilePhoneNumber and userFirstName- useless
    TODO: I would do 2 separate methods and use them in a StepGroup
    TODO: Use expected welcoming message in the assert; I think there is no need in declaring it at the beginning of the method as it's not used somewhere else
    TODO: Remove System.out.println
    TODO: User contentEquals instead of contains in the Assert
     */
    public void fillInAndRegisterUserAccountCredentials(String gender, String firstName, String lastName, String email, String password, String dayOfBirth, String month, String year, String addressFirstname, String addressLastname, String homeAddress, String cityName, String state, String zipCodeNumber, String mobilePhoneNumber, String alias) {
        String expectedWelcomingText = "Welcome to your account";
//        userMobilePhoneNumber = mobilePhoneNumber;
//        userFirstName = firstName;

        selectGender(gender);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        selectDateOfBirth(dayOfBirth);
        selectMonth(month);
        selectYear(year);
        addressFirstName.sendKeys(addressFirstname);
        addressLastName.sendKeys(addressLastname);
        addressAddress1.sendKeys(homeAddress);
        cityField.sendKeys(cityName);
        selectState(state);
        zipCode.sendKeys(zipCodeNumber);
        mobilePhone.sendKeys(mobilePhoneNumber);
        aliasAddress.sendKeys(alias);
        submitAccountButton.click();
        Assert.assertTrue("SingUp failed", welcomeToAccountText.getText().contains(expectedWelcomingText));
        System.out.println(userFirstName + " and " + userMobilePhoneNumber);
    }
}
