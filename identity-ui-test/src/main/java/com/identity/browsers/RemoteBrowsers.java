package com.identity.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteBrowsers {

    public static final String USERNAME = System.getProperty("bs.username");
    public static final String AUTOMATE_KEY = System.getProperty("bs.key");
    public static final String url = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver getRemoteDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Edge");
        caps.setCapability("browser_version", "83.0");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browserstack.local", "false");
        //caps.setCapability("browserstack.selenium_version", "3.141.59");
        caps.setCapability("build", "version1");
        caps.setCapability("project", System.getProperty("project.name"));
        return new RemoteWebDriver(new URL(url), caps);
    }
}