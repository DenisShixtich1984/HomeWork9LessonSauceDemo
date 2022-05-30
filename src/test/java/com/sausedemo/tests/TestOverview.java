package com.sausedemo.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOverview extends BaseTest {
    @Test
    public void testEnterRegistrationAndCheck() {
        loginPage.startLoginPasAndClick();
        productsPage.addToCartRedTShirt().pressCartButton();
        cartPage.pressButtonAndSwitch();
        checkOutPage.getFirstLastZipCode().continueButtonClick();
        overviewPage.isPageOpened();
        Assert.assertEquals(overviewPage.getTextProd(), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void testEnterFinish() {
        loginPage.startLoginPasAndClick();
        productsPage.addToCartRedTShirt().pressCartButton();
        cartPage.pressButtonAndSwitch();
        checkOutPage.getFirstLastZipCode().continueButtonClick();
        overviewPage.getButtonFinish();
        finishPage.isPageOpened();
    }
}