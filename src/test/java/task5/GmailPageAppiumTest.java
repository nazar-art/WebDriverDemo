package task5;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.appium.GmailAndroidPage;

import java.net.URL;
import java.util.List;

public class GmailPageAppiumTest {

    private static Logger log = Logger.getLogger(GmailPageAppiumTest.class);
    private WebDriver driver = null;
    private GmailAndroidPage gmailAndroidPage;

    public static final String LOGIN_URL = "https://accounts.google.com";

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    @Before
    public void setUp() throws Exception {
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
    public void DraftLinkAndroidTest() {
//        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
        driver.get(LOGIN_URL);
        driver.findElement(By.id("Email")).sendKeys(USER_LOGIN);
        driver.findElement(By.id("Passwd")).sendKeys(USER_PASSWORD);
        driver.findElement(By.id("signIn")).click();

    }

    /**
     * Check if list of letters from page contains text message.
     *
     * @param webElementList list of web elements.
     * @param message        test message.
     * @return if letter contain message true, otherwise false.
     */
    public boolean letterContainsTextMessage(List<WebElement> webElementList, String message) {
        for (WebElement element : webElementList) {
            String fullLetterText = element.getText().trim();
//            System.out.printf("full: %s%n", fullLetterText);
            if (fullLetterText.startsWith("-")) {
                String letterText = fullLetterText.substring(2);
//                System.out.printf("short: %s%n", letterText);
                if (letterText.equals(message)) {
                    return true;
                }
            }
        }
        return false;
    }

}
