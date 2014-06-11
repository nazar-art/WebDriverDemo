package task5;

import framework.seleniumEngine.SeleniumManager;
import mobile.business.GmailAndroidBO;
import mobile.business.LoginAndroidBO;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BrowserType;


public class TestGmailAndroidPage {

    public static final String TEST_MESSAGE = "This is test message";
    private static Logger log = Logger.getLogger(TestGmailAndroidPage.class);
    private WebDriver driver = SeleniumManager.start(BrowserType.Android_Chrome);
    private GmailAndroidBO androidBO;

    public static final String LOGIN_URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&service=mail";

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    @Before
    public void setUp() throws Exception {
        driver.get(LOGIN_URL);
        LoginAndroidBO loginAndroidBO = new LoginAndroidBO();
        loginAndroidBO.login(USER_LOGIN, USER_PASSWORD);

        androidBO = new GmailAndroidBO();
    }

    @After
    public void tearDown() throws Exception {
        SeleniumManager.closeQuietly();
    }

    @Test
    public void DraftLinkAndroidTest() {
        Assert.assertTrue(androidBO.checkSavingDraftLetter(TEST_MESSAGE));
        log.info("DraftLinkAndroidTest() passed successfully");
    }

}
