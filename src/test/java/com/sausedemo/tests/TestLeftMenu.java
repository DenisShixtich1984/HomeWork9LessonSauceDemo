package com.sausedemo.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLeftMenu extends BaseTest{
    @Test
    public void testPressLeftMenu () {
        loginPage.openPage();
        loginPage.loginWithStandardUser();
        menu.pushLeftMenu();
        waitForAction.waitLeftMenuOpened();
        menu.logOutMeted();
        waitForAction.waitLogOutHappened();
        Assert.assertEquals(menu.getUrl(),"https://www.saucedemo.com/");

    }

}
