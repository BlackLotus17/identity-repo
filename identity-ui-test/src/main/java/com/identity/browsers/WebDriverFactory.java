package com.identity.browsers;

import com.identity.utilites.PropFileMgr;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class WebDriverFactory {

    public WebDriverFactory() {
    }

    //This driver when registered with JVM thread, will be available framework wide
    private static ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<WebDriver>();


    private static void setThreadedDriver(WebDriver webDriver){
        DRIVER_THREAD_LOCAL.set(webDriver);
    }

    public static WebDriver getThreadedDriver(){
        return DRIVER_THREAD_LOCAL.get();
    }

    public static String scanForBrowser(){
        String browser = System.getProperty("browser");
        if(browser == null)
            browser = PropFileMgr.getSettings("browser");
        if(browser==null)
            browser = null;
        return browser;
    }

    //This is the entry point into the entire codes
    public static WebDriver create(){
        String browser = scanForBrowser();
        if(browser == null || browser.isEmpty()){
            throw new IllegalStateException("The webdriver system property must be set to a browser type eg. chrome");
        }
        try{
            createAndSetupThreadBrowser(browser);
            return getThreadedDriver();
        }catch (Exception e){
            String message = format("The webdriver system property '%s' did not match any"
                            + "existing browser or the browser was not supported"
                            + "Valid values are %s",
                    browser,
                    Arrays
                            .stream(Drivers.values())
                            .map(Enum::name)
                            .map(String::toLowerCase)
                            .collect(Collectors.toList())
            );
            throw new IllegalStateException(message, e);
        }
    }


    public static void createAndSetupThreadBrowser(String browserValue) throws Exception{
        WebDriver webDriver;
        if(System.getProperty("testbed").toLowerCase().contains("local")
                || PropFileMgr.getSettings("testbed").toLowerCase().contains("local")){
            webDriver = Drivers.valueOf(browserValue.toUpperCase()).newDriver();
        }else {
            webDriver = RemoteBrowsers.getRemoteDriver();
        }
        setThreadedDriver(webDriver);
    }




    private enum Drivers{
        FIREFOX{
            @Override
            public WebDriver newDriver(){
                return LocalBrowsers.getFirefoxDriver();
            }
        },
        CHROME{
            @Override
            public WebDriver newDriver(){
                return LocalBrowsers.getChromeDriver();
            }
        };
        public abstract WebDriver newDriver();
    }
}

