package com.sausedemo.pages;

import com.sausedemo.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector(".error-message-container.error");

//    public static final String STANDARD_USER = "standard_user";
//    public static final String STANDARD_PASSWORD = "secret_sauce";
//    --------------------------------------------------------------------

    PropertyReader reader = new PropertyReader();

    public void openPage() {
        driver.get(reader.getProperty("urlSaucedemo"));
    }


    public String getUserName() {
        return reader.getProperty("username");
    }

    public String getUserPassword() {
        return reader.getProperty("password");
    }


    //-----------------------------------------------------------------------
    public LoginPage setUsername(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public LoginPage setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public ProductsPage clickLogin() {
        getLoginButton().click();
        return new ProductsPage(driver);
    }

    public ProductsPage login(String username, String password) {
        setUsername(username);
        setPasswordField(password);
        return clickLogin();

    }

    public ProductsPage loginWithStandardUser() {
        return login(getUserName(), getUserPassword());
    }
//    public ProductsPage LoginWithStandardUser () {
//        return login(STANDARD_USER,STANDARD_PASSWORD);
//    }

    public ProductsPage startLoginPasAndClick() {
        openPage();
        loginWithStandardUser();
        return new ProductsPage(driver);
    }

    public void waitProductPageAppear() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
    }
}