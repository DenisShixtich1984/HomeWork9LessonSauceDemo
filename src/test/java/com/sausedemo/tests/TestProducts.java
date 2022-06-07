package com.sausedemo.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Comparator;
import java.util.List;

public class TestProducts extends BaseTest {
    @Test
    public void testCheckButtonJacketAddToCart() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        productsPage.isPageOpened();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.addToCartRedTShirt();
        Assert.assertEquals(productsPage.checkPressedButton(), "REMOVE");
    }

    @Test
    public void testLocationCart() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        productsPage.isPageOpened();
        productsPage.addToCartRedTShirt().pressCartButton();
        cartPage.waitOpenCartPage();
        Assert.assertEquals(cartPage.getCartTitle(), "YOUR CART");

    }

    @Test
    public void testSelectSortOfName() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        productsPage.isPageOpened();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.selectFilterName.click();
        productsPage.selectZtoA.click();
        Assert.assertEquals(productsPage.checkSelectZtoA(), "Name (Z to A)");
    }

    @Test
    public void testCortOtherWay() {
        loginPage.startLoginPasAndClick();
        productsPage.isPageOpened();
        List initialName = productsPage.getItemName();
        // асерт переставил стачала на 2 строчки выше -или на 1 строчку ниже только так работает !!!!!!!!!!!!!!!!!!!!
        initialName.sort(Comparator.reverseOrder());
        productsPage.selectValueByText("Name (Z to A)");
        productsPage.selectValueByText("Name (A to Z)");
        Assert.assertEquals(productsPage.getItemName(), initialName);
        initialName.sort(Comparator.naturalOrder());
        Assert.assertEquals(productsPage.getItemName(), initialName);
    }

    @Test
    public void testAddToCartAllThings() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        productsPage.isPageOpened();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
        productsPage.addToCartAllElements();
        Assert.assertEquals(productsPage.checkCart(), "6");
    }

    @Test
    public void testCheckTwitter() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        productsPage.isPageOpened();
        productsPage.pressButtonTwitter();
       // twitterPage.waitUntilTwitUp();
       // Assert.assertTrue(twitterPage.checkTwit.isEnabled());
    }

    @Test
    public void testCheckFacebook() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        productsPage.isPageOpened();
        productsPage.iconFacebook.click();
    }

    @Test
    public void testCheckLinkId() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        productsPage.isPageOpened();
        productsPage.iconLinkedIn.click();
    }
}