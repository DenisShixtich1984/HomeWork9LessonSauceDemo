package com.sausedemo.pages;
import com.sausedemo.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    public WebElement userNameField;
    @FindBy (id = "password")
    public WebElement passwordField;
    @FindBy (id = "login-button")
    public WebElement loginButton;
    @FindBy (css = ".error-message-container.error")
    public WebElement errorMessage;

    public LoginPage(WebDriver driver) {
    super(driver);
        PageFactory.initElements(driver, this);
}
    @Override
    public BasePage isPageOpened() {
        wait.until(ExpectedConditions.urlToBe(reader.getProperty("urlSaucedemo")));
        return this;
    }

    public void openPage() {
        driver.get(reader.getProperty("urlSaucedemo"));
    }
    public String getUserName() {
        return reader.getProperty("username");
    }

    public String getUserPassword() {
        return reader.getProperty("password");
    }

    public LoginPage setUsername(String username) {
        userNameField.sendKeys(username);
        return this;
    }

    public LoginPage setPasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public ProductsPage clickLogin() {
        loginButton.click();
        return new ProductsPage(driver);
    }

    public ProductsPage login(String username, String password) {
        return setUsername(username).setPasswordField(password).clickLogin();

    }

    public ProductsPage loginWithStandardUser() {
        return login(getUserName(), getUserPassword());
    }

    public ProductsPage startLoginPasAndClick() {
        openPage();
        loginWithStandardUser();
        return new ProductsPage(driver);
    }

}