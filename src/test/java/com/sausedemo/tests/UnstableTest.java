package com.sausedemo.tests;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnstableTest extends BaseTest{
    @Test (timeOut = 1000, retryAnalyzer = Retry.class)
    public void testRemoveShirtUnstable() {
        long timeout = RandomUtils.nextLong(1100,1400);
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.addToCartRedTShirt().pressCartButton();
        cartPage.waitOpenAndCheckTShirt();
        cartPage.isPageOpened();
        Assert.assertEquals(cartPage.getCartTitle(), "YOUR CART");
        Assert.assertEquals(cartPage.getCheckThingInTheCart(), "Test.allTheThings() T-Shirt (Red)");
        cartPage.removeButton.click();
        Assert.assertEquals(cartPage.getCart(), "");
        System.out.println("Retry = " + timeout);
    }
}
