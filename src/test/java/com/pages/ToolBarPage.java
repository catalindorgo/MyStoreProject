package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Created by catalindorgo on 3/14/2017.
 */
public class ToolBarPage extends PageObject{
    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButtonFromToolbar;

    public void clickSignInButton(){
        signInButtonFromToolbar.click();
    }
}
