package framework.seleniumEngine;

import pages.utils.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class SeleniumManager {

    private static WebDriver driver = null;

    private static volatile SeleniumManager instance = null;

    // private constructor
    private SeleniumManager() {
    }

    public static SeleniumManager getInstance() {
        return instance;
    }

    public static WebDriver activeBrowser() {
        if (driver == null) {
            throw new RuntimeException("You need to specify browser before");
        }
        return driver;
    }


    public static WebDriver start(BrowserType browserType) {
        switch (browserType) {
            case Firefox: {
                return driver = new FirefoxDriver();
            }

            case Chrome: {
                return driver = new ChromeDriver();
            }

            case IE: {
                return driver = new InternetExplorerDriver();
            }
            default: {
                throw new RuntimeException("Not supported");
            }
        }
    }

    public static void stop() {
        driver.quit();
        instance = null;
    }
}
