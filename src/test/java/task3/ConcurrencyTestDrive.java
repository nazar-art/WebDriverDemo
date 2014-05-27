package task3;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GmailLoginPage;
import pages.utils.DriverPool;
import business.GmailHeaderPanelBO;
import business.GmailLeftPanelBO;
import business.GmailMainContentBO;
import business.LoginBO;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import static pages.utils.TestUtils.interrupt;

public class ConcurrencyTestDrive {

    private static final Logger log = Logger.getLogger(ConcurrencyTestDrive.class);

    private WebDriver driver = DriverPool.getInstance();
//    private WebDriver driver = WebDriverManager.getInstance();
    private GmailHeaderPanelBO headerPanelBO;
    private LoginBO loginBO;
    private GmailMainContentBO mainContentBO;
    private GmailLeftPanelBO leftPanelBO;

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    @BeforeTest
    public void setUp() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(GmailLoginPage.LOGIN_URL);
            driver.manage().window().maximize();
            loginBO = new LoginBO();
            loginBO.login(USER_LOGIN, USER_PASSWORD);
        } catch (Throwable e) {
            log.error("Error at setUp() ", e);
            fail("Error at setUp() ", e.getCause());
        }
    }

    @Test(groups = "PARALLEL_TEST", dataProvider = "concurrencyData", dataProviderClass = task3.DataSource.class,
            threadPoolSize = 5)
    public void testConcurrencySavedAndClosedDrafts(String msg) {
        try {
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
        } catch (Throwable e) {
            log.error("Error at testConcurrencySavedAndClosedDrafts() ", e);
            fail("Error at testConcurrencySavedAndClosedDrafts() ", e);
        }
    }

    @AfterTest
    public void tearDown() {
        try {
            headerPanelBO = new GmailHeaderPanelBO();
            headerPanelBO.clickProfileOptionMenu();
            headerPanelBO.clickSignOutBtn();
        } catch (Throwable e) {
            log.error("Error at tearDown() ", e);
            fail("Error at tearDown() ", e.getCause());
        } finally {
            DriverPool.close();
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

}
