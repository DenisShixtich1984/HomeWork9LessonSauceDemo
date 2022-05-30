package com.sausedemo.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLeftMenu extends BaseTest {
    @Test
    public void testPressLeftMenu() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        menu.pushLeftMenu();
        menu.waitLeftMenuOpened();
        menu.logOutMeted();
        loginPage.isPageOpened();
        Assert.assertEquals(loginPage.getUrl(), "https://www.saucedemo.com/");
    }
    @Test
    public void testPressButtonAbout() {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        menu.pushLeftMenu();
        menu.waitLeftMenuOpened();
        menu.buttonAbout.click();
        Assert.assertEquals(menu.getUrl(),"https://saucelabs.com/");
    }
}