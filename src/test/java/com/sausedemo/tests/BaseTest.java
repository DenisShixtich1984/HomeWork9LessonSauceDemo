package com.sausedemo.tests;

import com.sausedemo.pages.*;
import com.sausedemo.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
@Listeners (OurListener.class)
public class BaseTest {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected LeftMenuPage menu;
    protected CheckOutPage checkOutPage;
    protected OverviewPage overviewPage;
    protected FinishPage finishPage;
    protected TwitterPage twitterPage;

    @BeforeMethod (alwaysRun = true)
    public void setUp () {
        System.out.println("---------------Before Method--------------");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        menu = new LeftMenuPage(driver);
        checkOutPage = new CheckOutPage(driver);
        overviewPage = new OverviewPage(driver);
        finishPage = new FinishPage(driver);
        twitterPage = new TwitterPage(driver);
    }

    @AfterMethod (alwaysRun = true)
    public void closeBrowser () {
       driver.quit();
        System.out.println("---------------After Method--------------");
    }
    @BeforeClass
    public void beforeClass () {
        System.out.println("*************** BeforeClass *********************");
    }
    @AfterClass
    public void afterClass () {
        System.out.println("********************* AfterClass **************");
    }
    @BeforeTest
    public void beforeTest () {
        System.out.println("/////////////// Before Test //////////////////////");
    }
    @AfterTest
    public void afterTest () {
        System.out.println("//////////////// After Test ////////////////////////");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("^^^^^^^^^^^^^^^^^^ Before Suite ^^^^^^^^^^^^^^^^^^^^^^");
    }
    @AfterSuite
    public void afterSuite () {
        System.out.println("^^^^^^^^^^^^^^^^^^^ After Suite ^^^^^^^^^^^^^^^^^^^^^^");
    }
    @BeforeGroups
    public void beforeGroups () {
        System.out.println("================ Before Groups ===============");
    }
    @AfterGroups
    public void afterGroups () {
        System.out.println("================ After Groups ===============");
    }
}
