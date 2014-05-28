package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class DriverPool {

    private static volatile ThreadLocal<WebDriver> instance = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            WebDriver driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            return driver;
        }
    };

    public static synchronized WebDriver getDriver() {
        return instance.get();
    }

    public static synchronized void closeDriver() {
        WebDriver driver = instance.get();

        driver.close();
        driver.quit();

        instance.remove();
    }
}
