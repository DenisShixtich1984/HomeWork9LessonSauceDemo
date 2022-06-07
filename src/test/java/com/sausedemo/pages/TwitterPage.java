package com.sausedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TwitterPage extends BasePage {
    public TwitterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Sauce Labs']")
    public WebElement checkTwit;

    public void waitUntilTwitUp () {
        wait.until(ExpectedConditions.visibilityOf(checkTwit));
    }
    @Override
    public BasePage isPageOpened() {
        return null;
    }
}
