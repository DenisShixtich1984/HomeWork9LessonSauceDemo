package com.sausedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFinish extends BaseTest{
    @Test
    public void testEnterFinishAndReturn() {
        loginPage.startLoginPasAndClick();
        productsPage.addToCartRedTShirt().pressCartButton();
        cartPage.pressButtonAndSwitch();
        checkOutPage.getFirstLastZipCode().continueButtonClick();
        overviewPage.getButtonFinish();
        Assert.assertEquals(finishPage.getTitleText(), "THANK YOU FOR YOUR ORDER");
        finishPage.buttonBack.click();
        productsPage.isPageOpened();
    }
}
