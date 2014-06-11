package framework.seleniumEngine;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.BrowserType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class SeleniumManager {

    private static Logger log = Logger.getLogger(SeleniumManager.class);

    private static volatile SeleniumManager instance = new SeleniumManager();

    private static WebDriver driver = null;

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
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                return driver;
            }

            case Chrome: {
                System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                return driver;
            }

            case IE: {
                driver = new InternetExplorerDriver();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                return driver;
            }

            case Android_Chrome: {
                try {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
                    capabilities.setCapability("platformName", "Android");
                    capabilities.setCapability("deviceName","Android Emulator");
                    capabilities.setCapability("platformVersion", "4.4.2");

                    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                    return driver;
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
    }
}
