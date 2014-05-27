package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class DriverPool {

    private static volatile ThreadLocal<WebDriver> instance = new ThreadLocal<WebDriver>();

    private DriverPool() {
    }

    public static synchronized WebDriver getInstance() {
            if (instance.get() == null) {
                instance.set(new FirefoxDriver());
                instance.get().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            }
        return instance.get();
    }

    public static void close() {
        instance.get().quit();
        instance = null;
//        driver = null;
    }
}
