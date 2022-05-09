package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private By cartTitle = By.className("title");
    private By thingInCart = By.xpath ("//div[text() ='Test.allTheThings() T-Shirt (Red)']");
    private By priceInCart = By.xpath("//div[text() ='15.99']");
    private By removeButton = By.xpath("//button[text()='Remove']");
    private By cart = By.className("shopping_cart_link");


    public String getCartTitle () {
        return driver.findElement(cartTitle).getText();
    }

    public String getCheckThingInTheCart () {
        return driver.findElement(thingInCart).getText();
    }
    public String getCheckPriceInTheCart () {
        return driver.findElement(priceInCart).getText();
    }
    public WebElement getRemoveButton () {
        return driver.findElement(removeButton);
    }
    public String getCart () {
        return driver.findElement(cart).getText();
    }
}
