package com.sausedemo.tests;

import com.sausedemo.pages.CartPage;
import com.sausedemo.pages.LeftMenuPage;
import com.sausedemo.pages.LoginPage;
import com.sausedemo.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected LeftMenuPage menu;

    @BeforeMethod
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        menu = new LeftMenuPage(driver);
    }
//    @AfterMethod
//    public void closeBrowser () {
//        driver.quit();
//    }
}
