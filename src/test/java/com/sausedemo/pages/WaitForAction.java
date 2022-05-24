package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAction extends BasePage {
    public WaitForAction(WebDriver driver) {
        super(driver);
    }
    protected By leftMenuLocator = By.id("inventory_sidebar_link");
    protected By titleOfProduct = By.cssSelector(".title");
    protected By elementOfCart = By.className("cart_desc_label");
    protected By elementInCart = By.className("inventory_item_name");

    public void waitLogOutHappened() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
    }

    public void waitLeftMenuOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(leftMenuLocator)));
    }

    public void waitOpenProductPage() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(titleOfProduct)));
    }

    public void waitOpenCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementOfCart)));
    }
    public void waitOpenAndCheckTShirt() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementInCart)));
    }
}