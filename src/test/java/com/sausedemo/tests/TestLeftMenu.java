package com.sausedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLeftMenu extends BaseTest{
    @Test
    public void testPressLeftMenu () {
        loginPage.openPage();
        loginPage.LoginWithStandardUser();
        menu.pushLeftMenu();
        menu.logOutMeted();
        Assert.assertEquals(menu.getUrl(),"https://www.saucedemo.com/");

    }

}
