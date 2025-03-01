package com.identity.support;

import com.identity.browsers.WebDriverFactory;
import com.identity.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class World {

    private static BasePage basePage;
    private static final WebDriver webDriver = WebDriverFactory.getThreadedDriver();

    public BasePage getBasePage(){
        if(basePage != null)return basePage;
        basePage = PageFactory.initElements(webDriver, BasePage.class);
        return basePage;
    }
}

