package com.identity;

import com.identity.browsers.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class HookSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverFactory.create();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (driver != null) {
                driver.quit();
            }
        }));
    }

    @Before
    public void setup() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed. Implement screenshot capture here.");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}