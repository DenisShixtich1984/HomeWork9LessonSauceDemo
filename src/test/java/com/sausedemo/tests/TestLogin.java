package com.sausedemo.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest{
    @Test(groups = "number1")
    public void testLogin() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginWithStandardUser();
         productsPage.waitOpenProductPage();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
    }
        @Test(groups = "number1")
    public void testEmptyPassword() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.setUsername(loginPage.getUserName()).clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }
    @Test
    public void testWrongLoginAndPassword() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login("rsbsfb", "eeeeeee");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void testLockedOutUserLoginAndPropertiesPassword() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login("locked_out_user",loginPage.getUserPassword());
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }
    @Test
    public void testProblemUserLoginAndStandardPassword() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login("problem_user", loginPage.getUserPassword());
        productsPage.waitOpenProductPage();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
    }
    @Test
    public void testPerformanceGlitchUserLoginAndStandardPassword() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login("performance_glitch_user", loginPage.getUserPassword());
        productsPage.waitOpenProductPage();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
    }
}
