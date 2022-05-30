package com.sausedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends BasePage{

    @FindBy (className = "title")
    public WebElement titleCheckOut;
    @FindBy (id = "continue")
    public WebElement continueButton;
    @FindBy (xpath = "//h3")
    public WebElement errorMessage;
    @FindBy (id = "first-name")
    public WebElement firstName;
    @FindBy (id = "last-name")
    public WebElement lastName;
    @FindBy (id = "postal-code")
    public WebElement zipCode;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String titleText () {
        return titleCheckOut.getText();
    }
    public OverviewPage continueButtonClick () {
        continueButton.click();
        return new OverviewPage(driver);
    }
    public String getErrorMessageText () {
       return errorMessage.getText();
    }
    public CheckOutPage getFirstLastZipCode () {
        firstName.sendKeys("Den");
        lastName.sendKeys("Den");
        zipCode.sendKeys("1111");
        return new CheckOutPage(driver);
    }

    @Override
    public BasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(titleCheckOut));
        return this;
    }

}
