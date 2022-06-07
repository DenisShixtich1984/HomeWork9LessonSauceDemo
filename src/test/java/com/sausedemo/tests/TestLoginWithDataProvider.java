package com.sausedemo.tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLoginWithDataProvider extends BaseTest{
    @DataProvider (name = "LoginAndPassword")
    public Object [][] objects () {
        return new Object[][] {
                {"performance_glitch_user","secret_sauce"},
                {"standard_user","secret_sauce"},
                {"problem_user","secret_sauce"}
        };
    }
    @Test (dataProvider = "LoginAndPassword")
    public void testLoginWithParameters(String Log, String Pass) {
        System.out.println("New login and password");
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login(Log, Pass);
        productsPage.waitOpenProductPage();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
    }
}
