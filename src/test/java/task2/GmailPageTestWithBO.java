package task2;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GmailLoginPage;
import pages.utils.TestUtils;
import task2.business.GmailHeaderPanelBO;
import task2.business.GmailLeftPanelBO;
import task2.business.GmailMainContentBO;
import task2.business.LoginBO;

import java.util.List;
import static java.util.concurrent.TimeUnit.*;

public class GmailPageTestWithBO {

    private static Logger log = Logger.getLogger(GmailPageTestWithBO.class);

    private WebDriver driver = null;
    private GmailLeftPanelBO leftPanelBO;
    private GmailMainContentBO mainContentBO;
    private GmailHeaderPanelBO headerPanelBO;
    private LoginBO loginBO;

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    public GmailPageTestWithBO() {
        driver = WebDriverManager.getInstance();
        leftPanelBO = new GmailLeftPanelBO();
        mainContentBO = new GmailMainContentBO();
        headerPanelBO = new GmailHeaderPanelBO();
        loginBO = new LoginBO();
    }

    @BeforeTest
    public void setUp() {
        try {
            driver.get(GmailLoginPage.LOGIN_URL);
            driver.manage().window().maximize();
            loginBO.setLogin(USER_LOGIN);
            loginBO.setPassword(USER_PASSWORD);
            loginBO.clickLoginBtn();
        } catch (Exception e) {
            log.error("setUp() for GmailPageTestWithBO fail, more details - ", e);
            Assert.fail("setUp() for GmailPageTestWithBO fail, more details - ", e.getCause());
        }
    }

    @Test(groups = "GMAIL_PAGE")
    public void testIfDraftFolderContainsSavedAndClosedDraft() {
        try {
            mainContentBO.pressComposeBtn();
            TestUtils.interrupt(SECONDS, 1);
            mainContentBO.typeTextToNewMsg(TestUtils.TEST_MESSAGE_FOR_GMAIL_PAGE_TEST);
            mainContentBO.clickSaveAndClose();
            leftPanelBO.clickDraftLink();
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
        try {
            headerPanelBO.clickProfileOptionMenu();
            headerPanelBO.clickSignOutBtn();
        } catch (Exception e) {
            log.error("Exception at tearDown() testIfDraftFolderContainsSavedAndClosedDraft - ", e);
            Assert.fail("Exception at tearDown() testIfDraftFolderContainsSavedAndClosedDraft - ", e.getCause());
        } finally {
            WebDriverManager.closeQuietly();
        }
    }

    /**
     * Check if list of letters from page contains text message.
     * @param webElementList list of web elements.
     * @param message test message.
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
