package task5;

import framework.seleniumEngine.SeleniumManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.utils.BrowserType;

public class AppiumTest {

    public static final String GOOGLE_HOME = "http://www.google.com";
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4.2");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/
        driver = SeleniumManager.start(BrowserType.Android_Chrome);
    }

    @After
    public void tearDown() throws Exception {
//        driver.quit();
        SeleniumManager.closeQuietly();
    }

    @Test
    public void apiDemo(){
        driver.get(GOOGLE_HOME);
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
        System.out.println("TEST IS PASSED");
    }

}
