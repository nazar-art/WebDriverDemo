package task3;

import business.GmailHeaderPanelBO;
import business.GmailLeftPanelBO;
import business.GmailMainContentBO;
import business.LoginBO;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GmailLoginPage;
import pages.utils.DriverPool;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertTrue;
import static pages.utils.TestUtils.interrupt;

public class TestConcurrencyDrive {

    private static final Logger log = Logger.getLogger(TestConcurrencyDrive.class);

    private WebDriver driver = DriverPool.getDriver();

    private GmailHeaderPanelBO headerPanelBO;
    private LoginBO loginBO;
    private GmailMainContentBO mainContentBO;
    private GmailLeftPanelBO leftPanelBO;

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    @BeforeTest
    public void setUp() {
//        try {
        driver.get(GmailLoginPage.LOGIN_URL);
        loginBO = new LoginBO();
        loginBO.login(USER_LOGIN, USER_PASSWORD);
        /*} catch (Throwable e) {
            log.error("Error at setUp() ", e);
            fail("Error at setUp() ", e.getCause());
        }*/
    }

    @Test(groups = "PARALLEL_TEST", dataProvider = "concurrencyData", threadPoolSize = 5)
    public void testConcurrencySavedAndClosedDrafts(String msg) {
//        try {
        mainContentBO = new GmailMainContentBO();
        mainContentBO.pressComposeBtn();
        interrupt(SECONDS, 1);
        mainContentBO.typeTextToNewLetter(msg);
        interrupt(SECONDS, 1);
        mainContentBO.clickSaveAndClose();
        interrupt(SECONDS, 1);
        leftPanelBO = new GmailLeftPanelBO();
        leftPanelBO.clickDraftLink();

        List<WebElement> allMessages = mainContentBO.takeAllLettersFromPage();
        assertTrue(letterContainsTextMessage(allMessages, msg),
                "letter doesn't contain test message");
        /*} catch (Throwable e) {
            log.error("Error at testConcurrencySavedAndClosedDrafts() ", e);
            fail("Error at testConcurrencySavedAndClosedDrafts() ", e);
        }*/
    }

    @AfterTest
    public void tearDown() {
        try {
            headerPanelBO = new GmailHeaderPanelBO();
            headerPanelBO.clickProfileOptionMenu();
            headerPanelBO.clickSignOutBtn();
        }
        /*catch (Throwable e) {
            log.error("Error at tearDown() ", e);
            fail("Error at tearDown() ", e.getCause());
        } */ finally {
            DriverPool.closeDriver();
//            WebDriverManager.closeQuietly();
        }
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
                if (letterText.contains(message)) {
                    return true;
                }
            }
        }
        return false;
    }

    @DataProvider(parallel = true)
    public Object[][] concurrencyData() {
        return new Object[][]{
                {"This is the test message for draft link #1"}, {"This is the test message for draft link #2"},
                {"This is the test message for draft link #3"}, {"This is the test message for draft link #4"},
                {"This is the test message for draft link #5"}, {"This is the test message for draft link #6"},
                {"This is the test message for draft link #7"}, {"This is the test message for draft link #8"},
                {"This is the test message for draft link #9"}, {"This is the test message for draft link #10"},
                {"This is the test message for draft link #11"}, {"This is the test message for draft link #12"},
                {"This is the test message for draft link #13"}, {"This is the test message for draft link #14"},
                {"This is the test message for draft link #15"}, {"This is the test message for draft link #16"},
                {"This is the test message for draft link #17"}, {"This is the test message for draft link #18"},
                {"This is the test message for draft link #19"}, {"This is the test message for draft link #20"}
        };
    }

}
