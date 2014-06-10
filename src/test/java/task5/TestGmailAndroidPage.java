package task5;

import framework.seleniumEngine.SeleniumManager;
import mobile.business.GmailAndroidBO;
import mobile.business.LoginAndroidBO;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.utils.BrowserType;

import java.util.List;


public class TestGmailAndroidPage {

    public static final String TEST_MESSAGE = "This is test message";
    private static Logger log = Logger.getLogger(TestGmailAndroidPage.class);
    private WebDriver driver = SeleniumManager.getInstance().start(BrowserType.Android_Chrome);
    private GmailAndroidBO androidBO;

    public static final String LOGIN_URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&service=mail";

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    @Before
    public void setUp() throws Exception {
        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4.2");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/

        driver.get(LOGIN_URL);
        LoginAndroidBO loginAndroidBO = new LoginAndroidBO();
        loginAndroidBO.login(USER_LOGIN, USER_PASSWORD);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void DraftLinkAndroidTest() {
        androidBO = new GmailAndroidBO();
        List<WebElement> draftLetters = androidBO.checkSavingDraftLetter(TEST_MESSAGE);
        Assert.assertTrue(letterContainsTextMessage(draftLetters, TEST_MESSAGE));
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
            System.out.printf("full: %s%n", fullLetterText);
            if (fullLetterText.startsWith("-")) {
                String letterText = fullLetterText.substring(2);
                System.out.printf("short: %s%n", letterText);
                if (letterText.equals(message)) {
                    return true;
                }
            }
        }
        return false;
    }

}
