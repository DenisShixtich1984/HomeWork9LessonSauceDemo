package com.sausedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCart extends BaseTest {
    @Test
    public void testRedShirtAddToCart() {
        loginPage.startLoginPasAndClick();
        // проба завернуть еще в большую обертку
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.addToCartRedTShirt();
        productsPage.pressCartButton();
        Assert.assertEquals(cartPage.getCartTitle(), "YOUR CART");
        Assert.assertEquals(cartPage.getCheckThingInTheCart(), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void testCheckPrice() {
        loginPage.startLoginPasAndClick();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.addToCartRedTShirt();
        productsPage.pressCartButton();
        Assert.assertEquals(cartPage.getCartTitle(), "YOUR CART");
        Assert.assertEquals(cartPage.getCheckThingInTheCart(), "Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(cartPage.getCheckPriceInTheCart(), "$15.99");
    }

    @Test
    public void testRemoveShirt() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.addToCartRedTShirt();
        productsPage.pressCartButton();
        waitForAction.waitOpenAndCheckTShirt();
        Assert.assertEquals(cartPage.getCartTitle(), "YOUR CART");
        Assert.assertEquals(cartPage.getCheckThingInTheCart(), "Test.allTheThings() T-Shirt (Red)");
        cartPage.getRemoveButton().click();
        Assert.assertEquals(cartPage.getCart(), "");
    }
}