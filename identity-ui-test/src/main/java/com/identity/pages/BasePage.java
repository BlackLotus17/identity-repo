package com.identity.pages;

import com.identity.utilites.PropFileMgr;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected   WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage loadApplication(){
        String baseUrl = PropFileMgr.getSettings("base.url");
        driver.navigate().to(baseUrl);
        return PageFactory.initElements(driver, HomePage.class);
    }
}

