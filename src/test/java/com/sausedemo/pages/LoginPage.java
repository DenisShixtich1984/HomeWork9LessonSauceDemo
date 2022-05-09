package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector(".error-message-container.error");

    public static final String STANDARD_USER = "standard_user";
    public static final String STANDARD_PASSWORD = "secret_sauce";

    public void openPage () {
        driver.get("https://www.saucedemo.com/");
    }
    public LoginPage setUsername (String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }
    public LoginPage setPasswordField (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public WebElement getLoginButton () {
        return driver.findElement(loginButton);
    }
    public String getErrorMessage () {
        return driver.findElement(errorMessage).getText();
    }
    public ProductsPage clickLogin () {
        getLoginButton().click();
        return new ProductsPage(driver);
    }

    public ProductsPage login (String username, String password) {
        setUsername(username);
        setPasswordField(password);
        return clickLogin();

    }
    public ProductsPage LoginWithStandardUser () {
        return login(STANDARD_USER,STANDARD_PASSWORD);
    }

}
