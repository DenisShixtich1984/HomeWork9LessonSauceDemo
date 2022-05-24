package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftMenuPage extends BasePage {
    public LeftMenuPage(WebDriver driver) {
        super(driver);
    }

    protected By leftMenuId = By.id("react-burger-menu-btn");
    protected By logOut = By.id("logout_sidebar_link");
    protected By startPage = By.cssSelector(".login_password");



    public WebElement getLeftMenu() {
        return driver.findElement(leftMenuId);
    }

    public LeftMenuPage pushLeftMenu() {
        getLeftMenu().click();
        return this;
    }

    public LeftMenuPage logOutMeted() {
        driver.findElement(logOut).click();

        return this;

    }


}