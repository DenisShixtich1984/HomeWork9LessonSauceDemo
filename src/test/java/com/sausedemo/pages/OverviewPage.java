package com.sausedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewPage extends BasePage{
    public OverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy (className = "title")
    public WebElement titleOverPage;
    @FindBy (className = "inventory_item_name")
    public WebElement productInCart;
    @FindBy (id = "finish")
    public WebElement buttonFinish;


    public String getTextProd () {
        return productInCart.getText();
    }
    public FinishPage getButtonFinish () {
        buttonFinish.click();
        return new FinishPage (driver);
    }

    @Override
    public BasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(titleOverPage));
        return this;
    }
}
