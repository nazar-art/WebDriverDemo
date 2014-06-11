package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static utilities.ProrpertiesFileHandler.readBrowserType;

public class DriverManager {

    private static Logger log = Logger.getLogger(DriverManager.class);

    private static volatile WebDriver instance;

    private DriverManager() {
    }

    public static synchronized WebDriver getInstance() {
        if (instance == null) {
            switch (readBrowserType()) {
                case Firefox: {
                    instance = new FirefoxDriver();
                    instance.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                    return instance;
                }

                case Chrome: {
                    System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
                    instance = new ChromeDriver();
                    instance.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                    return instance;
                }

                case IE: {
                    instance = new InternetExplorerDriver();
                    instance.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                    return instance;
                }

                case Android_Chrome: {
                    try {
                        DesiredCapabilities capabilities = new DesiredCapabilities();
                        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
                        capabilities.setCapability("platformName", "Android");
                        capabilities.setCapability("deviceName","Android Emulator");
                        capabilities.setCapability("platformVersion", "4.4.2");

                        instance = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                        instance.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                        return instance;
                    } catch (MalformedURLException e) {
                        log.error(e);
                    }
                }

                default: {
                    throw new RuntimeException("Not supported browser type");
                }
            }
        }
        return instance;
    }

    public static void closeQuietly() {
        if (instance != null) {
            instance.quit();
            instance = null;
        }
    }
}
