package task2;

import pages.utils.BrowserType;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.*;
import java.util.Properties;

public class WebDriverManager {

    private static Logger log = Logger.getLogger(WebDriverManager.class);
    public static final String CONFIG_PROPERTIES = "src/main/resources/config.properties";
    public static final String KEY = "browser.type";

    private static volatile WebDriver instance = null;

    private WebDriverManager() {
    }

    public static WebDriver getInstance() {
        WebDriver localInstance = instance;

        if (localInstance == null) {
            synchronized (WebDriverManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    switch (readBrowserType()) {
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

    public static BrowserType readBrowserType() {
        BrowserType browserType = null;
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(CONFIG_PROPERTIES);

            properties.load(inputStream);
            browserType = Enum.valueOf(BrowserType.class, properties.getProperty(KEY));
            inputStream.close();
        } catch (FileNotFoundException e) {
            log.error("Properties file wasn't found - " + e);
        } catch (IOException e) {
            log.error("Problem with reading properties file - " + e);
        }

        return browserType;
    }

    public static void closeQuietly() {
        if (instance != null) {
            instance.quit();
            instance = null;
        }
    }
}
