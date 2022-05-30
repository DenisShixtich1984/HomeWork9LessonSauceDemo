package com.sausedemo.pages;
import com.sausedemo.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//span[text() ='Products']")
    public WebElement nameTitle;
    @FindBy(xpath = "//button[text() ='Remove']")
    public WebElement checkButton;
    @FindBy(css = ".shopping_cart_link")
    public WebElement checkCart;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backpack;
    @FindBy(id ="add-to-cart-test.allthethings()-t-shirt-(red)")
    public WebElement redTShirt;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement bikeLight;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement blackTShirt;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement grayJacket;
    @FindBy (name = "add-to-cart-sauce-labs-onesie")
    public WebElement lightningTShirts;
    @FindBy (className = "product_sort_container")
    public WebElement selectFilterName;
    @FindBy (xpath = "//option[text() ='Name (Z to A)']")
    public WebElement selectZtoA;
    @FindBy (className = "product_sort_container")
    public WebElement select;
    @FindBys({
            @FindBy(css = ".inventory_item")
            })
    public List <WebElement> itemList;
    @FindBy (css = ".inventory_item_name")
    public WebElement itemName;
    @FindBy (css = ".inventory_item_price")
    public WebElement itemPrice;
    @FindBy (xpath = "//span[text ()='6']")
    public WebElement checkThingsInCart;
    @FindBy (xpath = "//a[text()='Twitter']")
    public WebElement iconTwitter;
    @FindBy (xpath = "//a[text()='Facebook']")
    public WebElement iconFacebook;
    @FindBy (xpath = "//h1[text()='Sauce Labs']")
    public WebElement xFacebook;
    @FindBy (xpath = "//a[text()='LinkedIn']")
    public WebElement iconLinkedIn;
    @FindBy (css = ".title")
    public WebElement titleOfProduct;

    // конструктор
    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public BasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(nameTitle));
        return this;
    }

    public Select getSelect() {
        return new Select(select);
    }

    public void selectValueByText(String text) {
        getSelect().selectByVisibleText(text);
    }

    public List<String> getItemName() {
        List<String> names = new ArrayList<>();
        for (WebElement item : itemList) {
            names.add((itemName).getText());
        }
        return names;
    }

    public String getPageProdTitle () {
        return nameTitle.getText();
    }

    public ProductsPage addToCartRedTShirt () {
        redTShirt.click();
        return this;
    }

    public String checkPressedButton () {
        return checkButton.getText();
    }

    public CartPage pressCartButton () {
        checkCart.click();
        return new CartPage(driver);
    }

    public ProductsPage addToCartAllElements () {
        redTShirt.click();
        backpack.click();
        bikeLight.click();
        blackTShirt.click();
        grayJacket.click();
        lightningTShirts.click();
        return this;
    }
    public String checkCart () {
        return checkThingsInCart.getText();
    }

    public String checkSelectZtoA () {
        return selectZtoA.getText();
    }
    public String checkFaceBook () { return xFacebook.getText();}
    public void waitOpenProductPage() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(titleOfProduct));
    }
}