package com.sausedemo.tests;

import com.sausedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest{
    @Test
    public void testLogin() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        waitForAction.waitOpenProductPage();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
    }

    @Test
    public void testEmptyPassword() {
        loginPage.openPage();
        loginPage.setUsername(loginPage.getUserName()).clickLogin();
//      loginPage.setUsername(loginPage.STANDARD_USER).clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void testWrongLoginAndPassword() {
        loginPage.openPage();
        loginPage.login("rsbsfb", "eeeeeee");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testLockedOutUserLoginAndPropertiesPassword() {
        loginPage.openPage();
        loginPage.login("locked_out_user",loginPage.getUserPassword());
//        loginPage.login("locked_out_user", LoginPage.STANDARD_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void testProblemUserLoginAndStandardPassword() {
        loginPage.openPage();
        loginPage.login("problem_user", loginPage.getUserPassword());
//        loginPage.login("problem_user", loginPage.STANDARD_PASSWORD);
        waitForAction.waitOpenProductPage();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
    }
    @Test
    public void testPerformanceGlitchUserLoginAndStandardPassword() {
        loginPage.openPage();
        loginPage.login("performance_glitch_user", loginPage.getUserPassword());
//        loginPage.login("performance_glitch_user", loginPage.STANDARD_PASSWORD);
        waitForAction.waitOpenProductPage();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
    }
}
