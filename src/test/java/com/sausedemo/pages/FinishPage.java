package com.sausedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinishPage extends BasePage{
    public FinishPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "pony_express")
    public WebElement ponyExpress;
    @FindBy (className = "complete-header")
    public WebElement titleExpress;
    @FindBy (id = "back-to-products")
    public WebElement buttonBack;


    public String getTitleText () {
        return titleExpress.getText();
    }

    @Override
    public BasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(ponyExpress));

        return null;
    }
}
