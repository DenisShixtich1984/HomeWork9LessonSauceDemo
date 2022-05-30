package com.sausedemo.pages;
import com.sausedemo.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,5);
    }
    public String getUrl () {
        return driver.getCurrentUrl();
    }
    public  abstract BasePage isPageOpened ();
    protected WebDriverWait wait;
    PropertyReader reader = new PropertyReader();

}

