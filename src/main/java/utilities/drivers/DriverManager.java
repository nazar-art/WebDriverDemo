package utilities.drivers;

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

import static utilities.files.PropertiesFileHandler.readBrowserType;

public class DriverManager {

    private static volatile WebDriver driverInstance;

    private DriverManager() {
    }

    public static /*synchronized*/ WebDriver getInstance() {
        if (driverInstance == null) {
            switch (readBrowserType()) {
                case Firefox: {
                    System.setProperty("webdriver.gecko.driver","/home/nazar/Software/geckodriver");

                    driverInstance = new FirefoxDriver();
                    driverInstance.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                    driverInstance.manage().window().maximize();
                    return driverInstance;
                }

                case Chrome: {
                    System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
                    driverInstance = new ChromeDriver();
                    driverInstance.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                    driverInstance.manage().window().maximize();
                    return driverInstance;
                }

                case IE: {
                    driverInstance = new InternetExplorerDriver();
                    driverInstance.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                    driverInstance.manage().window().maximize();
                    return driverInstance;
                }

                case Android_Chrome: {
                    try {
                        DesiredCapabilities capabilities = new DesiredCapabilities();
                        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
                        capabilities.setCapability("platformName", "Android");
                        capabilities.setCapability("deviceName","Android Emulator");
                        capabilities.setCapability("platformVersion", "4.4.2");

                        driverInstance = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                        driverInstance.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                        return driverInstance;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        e.getCause();
                    }
                }

                default: {
                    throw new RuntimeException("Not supported browser type");
                }
            }
        }
        return driverInstance;
    }

    public static void closeQuietly() {
        if (driverInstance != null) {
            driverInstance.quit();
            driverInstance = null;
        }
    }
}
