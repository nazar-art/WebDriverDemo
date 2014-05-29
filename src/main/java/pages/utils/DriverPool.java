package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static pages.utils.TestUtils.interrupt;

public class DriverPool {

    public static final int MAX_NUMBER = 5;

    public static AtomicInteger counter = new AtomicInteger(0);

    private static volatile ThreadLocal<WebDriver> instance = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            WebDriver driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            return driver;
        }
    };

    public static synchronized WebDriver getDriver() {
        while (counter.get() > MAX_NUMBER) {
            interrupt(TimeUnit.SECONDS, 1200);
        }
        counter.getAndIncrement();

        return instance.get();
    }

    public static synchronized void closeDriver() {
        WebDriver driver = instance.get();

        driver.close();
        driver.quit();

        instance.remove();
        counter.decrementAndGet();
    }
}
