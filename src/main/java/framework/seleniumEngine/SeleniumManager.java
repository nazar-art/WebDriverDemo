package framework.seleniumEngine;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.utils.BrowserType;

import java.net.MalformedURLException;
import java.net.URL;


public class SeleniumManager {

    private static WebDriver driver = null;

    private static volatile SeleniumManager instance = null;

    private static Logger log = Logger.getLogger(SeleniumManager.class);

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
                System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
                return driver = new ChromeDriver();
            }

            case IE: {
                return driver = new InternetExplorerDriver();
            }

            case Android_Chrome: {
                try {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
                    capabilities.setCapability("platformName", "Android");
                    capabilities.setCapability("deviceName","Android Emulator");
                    capabilities.setCapability("platformVersion", "4.4.2");

                    return driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    log.error(e);
                }
            }

            default: {
                throw new RuntimeException("Not supported browser type!");
            }
        }
    }

    public static void closeQuietly() {
        driver.quit();
//        driver.close();
        instance = null;
    }
}
