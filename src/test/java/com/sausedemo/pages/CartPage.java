package com.sausedemo.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    @FindBy (className = "title")
    public WebElement cartTitle;
    @FindBy (xpath = "//div[text() ='Test.allTheThings() T-Shirt (Red)']")
    public WebElement thingInCart;
    @FindBy (xpath = "//div[text() ='15.99']")
    public WebElement priceInCart;
    @FindBy (xpath = "//button[text()='Remove']")
    public WebElement removeButton;
    @FindBy (className = "shopping_cart_link")
    public WebElement cart;
    @FindBy (id = "checkout")
    public WebElement checkoutButton;
    @FindBy(className = "cart_desc_label")
    public WebElement elementOfCart;
    @FindBy (className = "inventory_item_name")
    public WebElement elementInCart;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public BasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(checkoutButton));
        return null;
    }

    public String getCartTitle () {
        return cartTitle.getText();
    }
    public String getCheckThingInTheCart () {
        return thingInCart.getText();
    }
    public String getCheckPriceInTheCart () {
        return priceInCart.getText();
    }
    public String getCart () {
        return cart.getText();
    }

    public CheckOutPage pressButtonAndSwitch () {
    checkoutButton.click();
    return new CheckOutPage(driver);
    }
    public void waitOpenCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOf(elementOfCart));
    }
    public void waitOpenAndCheckTShirt() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(elementInCart));
    }
}
