package task5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.URL;

public class AppiumTest {

    public static final String GOOGLE_HOME = "http://www.google.com";
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        /*DesiredCapabilities  capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability("app", "Chrome");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.VERSION, "4.3");
        capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4.2");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void apiDemo(){
        driver.get(GOOGLE_HOME);
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
    }

}
