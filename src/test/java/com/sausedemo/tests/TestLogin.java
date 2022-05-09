package com.sausedemo.tests;

import com.sausedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest{
    @Test
    public void testLogin() {
        loginPage.openPage();
        loginPage.LoginWithStandardUser();
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
    }

    @Test
    public void testEmptyPassword() {
        loginPage.openPage();
        loginPage.setUsername(LoginPage.STANDARD_USER).clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void testWrongLoginAndPassword() {
        loginPage.openPage();
        loginPage.login("rsbsfb", "eeeeeee");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testLocked_out_userLoginAndStandardPassword() {
        loginPage.openPage();
        loginPage.login("locked_out_user", LoginPage.STANDARD_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void testProblem_userLoginAndStandardPassword() {
        loginPage.openPage();
        loginPage.login("problem_user", LoginPage.STANDARD_PASSWORD);
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
    }
    @Test
    public void testPerformance_glitch_userLoginAndStandardPassword() {
        loginPage.openPage();
        loginPage.login("performance_glitch_user", LoginPage.STANDARD_PASSWORD);
        Assert.assertEquals(productsPage.getPageProdTitle(), "PRODUCTS");
    }
}
