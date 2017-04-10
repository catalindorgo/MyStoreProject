package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.jruby.RubyProcess;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 * Created by catalindorgo on 3/10/2017.
 */
public class SignUpPage extends GeneralMethods {


    private String DAY_OF_BIRTH = "//select[@id='days']//option[@value='%value%']";
    private String MONTH_OF_BIRTH = "//select[@id='months']//option[contains(text(), '%value%')]";
    private String YEAR_OF_BIRTH = "//select[@id='years']//option[contains(text(), '%value%')]";
    private String STATE = "//select[@id='id_state']//option[contains(text(), '%value%')]";
    private String DATE_DROP_DOWN_LISTS_BUTTONS_EXPANDER ="//div/div[@id='uniform-%value%']";
    private String DATE_DROP_DOWN_LISTS_SELECT = "//select[@id='%value%']";

    @FindBy(xpath = ".//div[@class='row']//h1")
    private WebElement signUpPageTitle;

    @FindBy(xpath = "//button/span[contains(text(), 'Register')]")
    private WebElement registerButton;

    //TODO: change xpaths to private String mrs_msRadioButton = .//div[contains(@class,'radio')]//bla bla text() and if it works change "selectGender" method accordingly
    // NOT DONE - I tried using a String mrs_ms but if you check the HTML code you'll notice that its written badly and the label that contains the actual "mr" text, also contains a <div>
    // try this xpath that should work if no div would have been present: //label[contains(text(),'Mr')]
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
    // Done - way better this way. looks better. (also changed for moths / years)

    @FindBy(xpath = "//div[contains(@id,'days')]")
    private WebElement dayOfBirthDropDown;

    @FindBy(xpath = "//div[contains(@id,'months')]")
    private WebElement monthsDropDown;

    @FindBy(xpath = "//div[contains(@id,'years')]")
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
    //Done - now the WebElement is identified by different attributes, besides its text.
    @FindBy(xpath = "//div[@class='row']/div/p")
    private WebElement welcomeToAccountText;

    @FindBy(xpath = "//div/button[@name='submitAccount']")
    private WebElement submitAccountButton;

    @FindBy(xpath = "//div[contains(@class, 'alert')]")
    private WebElement errorMessageForSignUpProblems;


    //TODO: Remove System.out.println
    // Done - Removed.
    //TODO: Change assert error to be thrown to reflect reality
    // Updated the assert error.
    public void verifyCurrentPageTitle(String expectedPageTitle) {
        Assert.assertTrue("The page title is incorrect, it should be: " +expectedPageTitle, signUpPageTitle.getText().contentEquals(expectedPageTitle));
    }

    public void waitForSignUpPageHeader() {
        waitMethod(signUpPageTitle);
    }

    /*TODO: Change the method to reflect what you intend to do in the test
      TODO: Question: Why did you declare "ERROR_MESSAGE_FOR_INVALID_CREDENTIALS" as a String and not used @FindBy?
    */
    /* Done  - Method Name updated. I believe that initially I wanted to use the String in order to parametrize different error messages for different faulty credentials or tests.
    but now switched to a WebElement instead of String */
    public void clickRegisterButtonWithAllFieldsBlankAndVerifyTheErrorMessageIsThrown() {
        registerButton.click();
        Assert.assertTrue("The error message banner is not displayed at all", errorMessageForSignUpProblems.isDisplayed());
        Assert.assertTrue("The 'Sign Up failed' error message was not displayed" , errorMessageForSignUpProblems.getText().contains("errors"));
    }

    /*
    TODO: I don't think we need the or in the id clause. We should use only the value that the user sees on the screen- Mr. and Mrs.
     */
    // Done - the OR operator is removed, using the values displayed in the UI only.
    public void selectGender(String gender) {
        if (gender == "Mr." ) {
            mrButton.click();
        } else if (gender == "Mrs.") {
            mrsButton.click();
        }
    }
/*TODO: Duplicated methods; use only one private method parameterised
  TODO: Try to use Select for this method
  */
// In Progress - method does not fully work due to how html code is written (days options have +1extra space; months options have + 2extra blanks)
    // selfnote - When finished, delete the top 3 Old Strings and the 3 old methods.


    private void selectOptionFromDropDownList(String option, String dateSubCategory){
        WebElement dropDownListExpander = getDriver().findElement(By.xpath(DATE_DROP_DOWN_LISTS_BUTTONS_EXPANDER.replace("%value%",dateSubCategory )));
        WebElement dropDownListSelect = getDriver().findElement(By.xpath(DATE_DROP_DOWN_LISTS_SELECT.replace("%value%", dateSubCategory)));
        dropDownListExpander.click();
        Select dropDownListOption = new Select (dropDownListSelect);
        dropDownListOption.selectByVisibleText(option);

    }

    public void selectDaysOfBirth(String dayOfBirthOption) {
        selectOptionFromDropDownList(dayOfBirthOption,"days" );
    }

    public void selectMonthsOfBirth(String monthOfBirthOption){
        selectOptionFromDropDownList(monthOfBirthOption, "months");
    }

    public void selectYearsOfBirth(String yearOfBirthOption){
        selectOptionFromDropDownList(yearOfBirthOption, "years");
    }

//    public void selectDateOfBirth(String dayOfBirth) {
//        WebElement theDayOfBirth = getDriver().findElement(By.xpath(DAY_OF_BIRTH.replace("%value%", dayOfBirth)));
//        dayOfBirthDropDown.click();
//        theDayOfBirth.click();
//    }
//
//    public void selectMonth(String month) {
//        WebElement monthOfBirth = getDriver().findElement(By.xpath(MONTH_OF_BIRTH.replace("%value%", month)));
//        monthsDropDown.click();
//        monthOfBirth.click();
//    }
//
//    public void selectYear(String year) {
//        WebElement yearOfBirth = getDriver().findElement(By.xpath(YEAR_OF_BIRTH.replace("%value%", year)));
//        yearsDropDown.click();
//        yearOfBirth.click();
//    }

    public void selectState(String state) {
        WebElement theState = getDriver().findElement(By.xpath(STATE.replace("%value%", state)));
        stateDropDown.click();
        theState.click();
    }

    /*
    TODO: Remove userMobilePhoneNumber and userFirstName- useless
    //done - removed.
    TODO: I would do 2 separate methods and use them in a StepGroup
    TODO: Use expected welcoming message in the assert; I think there is no need in declaring it at the beginning of the method as it's not used somewhere else
    // Done - Removed the String and added text in the Assert method.
    TODO: Remove System.out.println
    // done - removed.
    TODO: User contentEquals instead of contains in the Assert
    // done - updated to contentEquals .
     */
    public void fillInAndRegisterUserAccountCredentials(String gender, String firstName, String lastName, String email, String password, String dayOfBirthNumber, String monthName, String year, String addressFirstname, String addressLastname, String homeAddress, String cityName, String state, String zipCodeNumber, String mobilePhoneNumber, String alias) {
        selectGender(gender);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        selectDaysOfBirth(dayOfBirthNumber);
        selectMonthsOfBirth(monthName);
        selectYearsOfBirth(year);
//        selectDateOfBirth(dayOfBirthNumber);
//        selectMonth(monthName);
//        selectYear(year);
        addressFirstName.sendKeys(addressFirstname);
        addressLastName.sendKeys(addressLastname);
        addressAddress1.sendKeys(homeAddress);
        cityField.sendKeys(cityName);
        selectState(state);
        zipCode.sendKeys(zipCodeNumber);
        mobilePhone.sendKeys(mobilePhoneNumber);
        aliasAddress.sendKeys(alias);
        submitAccountButton.click();
        Assert.assertTrue("Sign Up failed. You should have been redirected to MY ACCOUNT page and the 'Welcome to your account. Here you can manage all of your personal information and orders' message, should have been displayed", welcomeToAccountText.getText().contentEquals("Welcome to your account. Here you can manage all of your personal information and orders."));
    }
}
