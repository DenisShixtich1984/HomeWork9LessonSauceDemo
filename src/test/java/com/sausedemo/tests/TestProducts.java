package com.sausedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProducts extends BaseTest{
    @Test
    public void testCheckButtonJacketAddToCart() {
        loginPage.openPage();
        loginPage.LoginWithStandardUser();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.addToCartRedTShirt();
        Assert.assertEquals(productsPage.checkPressedButton(), "REMOVE");

    }

    @Test
    public void testLocationCart() {
        loginPage.openPage();
        loginPage.LoginWithStandardUser();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.addToCartRedTShirt();
        productsPage.pressCartButton();
        Assert.assertEquals(cartPage.getCartTitle(), "YOUR CART");

    }
    @Test
    public void testSelectSortOfName() {
        loginPage.openPage();
        loginPage.LoginWithStandardUser();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.selectFilter().click();
        productsPage.selectOptionsZtoA().click();
        Assert.assertEquals(productsPage.checkSelectZtoA(),"Name (Z to A)");

    }
    @Test
    public void testAddToCartAllThings() {
        loginPage.openPage();
        loginPage.LoginWithStandardUser();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.addToCartAllElements();
        Assert.assertEquals(productsPage.checkCart(), "6");
    }
}
