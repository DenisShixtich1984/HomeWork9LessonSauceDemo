package com.sausedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class TestProducts extends BaseTest{
    @Test
    public void testCheckButtonJacketAddToCart() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.addToCartRedTShirt();
        Assert.assertEquals(productsPage.checkPressedButton(), "REMOVE");

    }

    @Test
    public void testLocationCart() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.addToCartRedTShirt();
        productsPage.pressCartButton();
        waitForAction.waitOpenCartPage();
        Assert.assertEquals(cartPage.getCartTitle(), "YOUR CART");

    }
    @Test
    public void testSelectSortOfName() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.selectFilter().click();
        productsPage.selectOptionsZtoA().click();
        Assert.assertEquals(productsPage.checkSelectZtoA(),"Name (Z to A)");
            }
    @Test
    public void testCortOtherWay() {
        loginPage.startLoginPasAndClick();
        List initialName = productsPage.getItemName();
        initialName.sort(Comparator.reverseOrder());
        productsPage.selectValueByText("Name (Z to A)");
        Assert.assertEquals(productsPage.getItemName(),initialName);
        productsPage.selectValueByText("Name (A to Z)");
        initialName.sort(Comparator.naturalOrder());
        Assert.assertEquals(productsPage.getItemName(),initialName);
    }

    @Test
    public void testAddToCartAllThings() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.addToCartAllElements();
        Assert.assertEquals(productsPage.checkCart(), "6");
    }
}
