package com.sausedemo.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftMenuPage extends BasePage {
    public LeftMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public BasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(startPage));
        return null;
    }
    @FindBy(id = "react-burger-menu-btn")
    public WebElement leftMenuId;
    @FindBy(id ="logout_sidebar_link")
    public WebElement logOut;
    @FindBy(css = ".login_password")
    public WebElement startPage;
    @FindBy(id = "about_sidebar_link")
    public WebElement buttonAbout;
    @FindBy(id = "inventory_sidebar_link")
    public WebElement leftMenuLocator;

    public LeftMenuPage pushLeftMenu() {
        leftMenuId.click();
        return this;
    }
    public LeftMenuPage logOutMeted() {
        logOut.click();
        return this;
    }
    public void waitLeftMenuOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(leftMenuLocator));
    }
}