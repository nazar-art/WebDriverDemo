package task2;

import framework.seleniumEngine.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-23.
 */
public class WebDriverManager {

    private static volatile WebDriver instance = null;

    private WebDriverManager() {
    }

    public static WebDriver getInstance(BrowserType browserType) {
        WebDriver localInstance = instance;

        if (localInstance == null) {
            synchronized (WebDriverManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    switch (browserType) {
                        case Firefox: {
                            return instance = localInstance = new FirefoxDriver();
                        }

                        case Chrome: {
                            return instance = localInstance = new ChromeDriver();
                        }

                        case IE: {
                            return instance = localInstance = new InternetExplorerDriver();
                        }
                        default: {
                            throw new RuntimeException("Not supported");
                        }
                    }

                }
            }
        }
        return localInstance;
    }

    public static void stop() {
        if (instance != null) {
            instance.quit();
            instance = null;
        }
    }
}
