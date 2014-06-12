package task2;

import business.GmailHeaderPanelBO;
import business.GmailLeftPanelBO;
import business.GmailMainContentBO;
import business.LoginBO;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GmailLoginPage;
import utilities.drivers.DriverManager;
import utilities.TestUtils;

import java.util.List;

public class GmailPageTestWithBO {

    private static Logger log = Logger.getLogger(GmailPageTestWithBO.class);

    private WebDriver driver = DriverManager.getInstance();
    private GmailHeaderPanelBO headerPanelBO;
    private LoginBO loginBO;
    private GmailMainContentBO mainContentBO;
    private GmailLeftPanelBO leftPanelBO;

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    @BeforeTest
    public void setUp() {
        try {
            driver.get(GmailLoginPage.LOGIN_URL);
            driver.manage().window().maximize();
            loginBO = new LoginBO();
            loginBO.login(USER_LOGIN, USER_PASSWORD);
        } catch (Exception e) {
            log.error("setUp() for GmailPageTestWithBO fail, more details - ", e);
            Assert.fail("setUp() for GmailPageTestWithBO fail, more details - ", e.getCause());
        }
    }

    @Test(groups = "GMAIL_PAGE")
    public void testIfDraftFolderContainsSavedAndClosedDraft() {
        try {
            mainContentBO = new GmailMainContentBO();
            mainContentBO.saveAndCloseDraftMessage(TestUtils.TEST_MESSAGE_FOR_GMAIL_PAGE_TEST);

            leftPanelBO = new GmailLeftPanelBO();
            leftPanelBO.clickDraftLink();

            List<WebElement> allMessages = mainContentBO.takeAllLettersFromPage();
            Assert.assertTrue(letterContainsTextMessage(allMessages, TestUtils.TEST_MESSAGE_FOR_GMAIL_PAGE_TEST),
                    "any letter doesn't contain test message");
        } catch (Exception e) {
            log.error("Exception occurred at GmailPageTestWithBO - testIfDraftFolderContainsSavedAndClosedDraft() - ", e);
            Assert.fail("Exception occurred at GmailPageTestWithBO - testIfDraftFolderContainsSavedAndClosedDraft() - ", e);
        }
    }

    @AfterTest
    public void tearDown() {
        DriverManager.closeQuietly();
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
            if (element.getText().contains(message)) {
                return true;
            }
        }
        return false;
    }

}
