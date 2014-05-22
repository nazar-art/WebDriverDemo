package seleniumEngine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class SeleniumManager {

    private static WebDriver driver = null;

    private static volatile SeleniumManager instance = new SeleniumManager();

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


    public static void start(BrowserType browserType) {
        switch (browserType) {
            case Firefox: {
                driver = new FirefoxDriver();
                break;
            }

            case Chrome: {
                driver = new ChromeDriver();
                break;
            }

            case IE: {
                driver = new InternetExplorerDriver();
                break;
            }
            default: {
                throw new RuntimeException("Not supported");
            }
        }
    }

    public static void stop() {
        driver.quit();
    }
}
