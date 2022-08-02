package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private By NameTitle = By.xpath("//span[text() ='Products']");
    private By checkButton = By.xpath("//button[text() ='Remove']");
    private By checkCart = By.cssSelector(".shopping_cart_link");
    private By backpack = By.id("add-to-cart-sauce-labs-backpack");
    private By redTShirt = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private By bikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By blackTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By grayJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By lightningTShirts = By.name("add-to-cart-sauce-labs-onesie");
    private By selectFilterName = By.className("product_sort_container");
    private By selectZtoA = By.xpath("//option[text() ='Name (Z to A)']");
    //-----------------------------------------------------------------------------
    private By select = By.className("product_sort_container");
    private By itemList = By.cssSelector(".inventory_item");
    private By itemName = By.cssSelector(".inventory_item_name");
    private By itemPrice = By.cssSelector(".inventory_item_price");

    public Select getSelect() {
        return new Select(driver.findElement(select));
    }

    public void selectValueByText(String text) {
        getSelect().selectByVisibleText(text);
    }

    public List<WebElement> getItemList() {
        return driver.findElements(itemList);
    }

    public List<String> getItemName() {
        List<String> names = new ArrayList<>();
        for (WebElement item : getItemList()) {
            names.add(item.findElement(itemName).getText());
        }
        return names;
    }
//---------------------------------------------------------------------------------
    public String getPageProdTitle () {
        return driver.findElement(NameTitle).getText();
    }
    public WebElement getRedTShirtAddToCart () {
        return driver.findElement(redTShirt);
    }
    public ProductsPage addToCartRedTShirt () {
        getRedTShirtAddToCart().click();
        return this;
    }

    public String checkPressedButton () {
        return driver.findElement(checkButton).getText();
    }
    public WebElement getCartButton () {
        return driver.findElement(checkCart);
    }
    public CartPage pressCartButton () {
        getCartButton().click();
        return new CartPage(driver);
    }
    public WebElement getBackpack () {
        return driver.findElement(backpack);}
    public WebElement getBikeLight () {
        return driver.findElement(bikeLight);}
    public WebElement getBlackTShirt () {
        return driver.findElement(blackTShirt);}
    public WebElement getGrayJacket () {
        return driver.findElement(grayJacket);}
    public WebElement getLightningTShirts () {
        return driver.findElement(lightningTShirts);}

    public ProductsPage addToCartAllElements () {
        getRedTShirtAddToCart().click();
        getBackpack().click();
        getBikeLight().click();
        getBlackTShirt().click();
        getGrayJacket().click();
        getLightningTShirts().click();
        return this;
    }
    public String checkCart () {
        return driver.findElement(By.xpath("//span[text ()='6']")).getText();
    }
    public WebElement selectFilter () {
        return driver.findElement(selectFilterName);
    }

    public WebElement selectOptionsZtoA () {
        return driver.findElement(selectZtoA);
    }
    public String checkSelectZtoA () {
        return driver.findElement(selectZtoA).getText();
    }
}
