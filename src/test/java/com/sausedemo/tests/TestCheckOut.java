package com.sausedemo.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCheckOut extends BaseTest {
    @Test
    public void testCheckOutCrossing() {
        loginPage.startLoginPasAndClick();
        productsPage.addToCartRedTShirt().pressCartButton();
        Assert.assertEquals(cartPage.getCheckThingInTheCart(), "Test.allTheThings() T-Shirt (Red)");
        cartPage.pressButtonAndSwitch();
        checkOutPage.isPageOpened();
    }
    @Test
    public void testOverViewCrossingWithOutRegistration() {
        loginPage.startLoginPasAndClick();
        productsPage.addToCartRedTShirt().pressCartButton();
        Assert.assertEquals(cartPage.getCheckThingInTheCart(), "Test.allTheThings() T-Shirt (Red)");
        cartPage.pressButtonAndSwitch();
        checkOutPage.isPageOpened();
        checkOutPage.continueButtonClick();
        Assert.assertEquals(checkOutPage.getErrorMessageText(),"Error: First Name is required");
    }
    @Test
    public void testEnterRegistration () {
        loginPage.startLoginPasAndClick();
        productsPage.addToCartRedTShirt().pressCartButton();
        cartPage.pressButtonAndSwitch();
        checkOutPage.getFirstLastZipCode().continueButtonClick();
        overviewPage.isPageOpened();
    }

}