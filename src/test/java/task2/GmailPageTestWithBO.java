package task2;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GmailLoginPage;
import pages.TestUtils;
import task2.business.GmailHeaderPanelBO;
import task2.business.GmailLeftPanelBO;
import task2.business.GmailMainContentBO;
import task2.business.LoginBO;

import java.util.List;

import static framework.seleniumEngine.BrowserType.Firefox;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-23.
 */
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
        driver = WebDriverManager.getInstance(Firefox); // todo move to properties file
        leftPanelBO = new GmailLeftPanelBO(driver);
        mainContentBO = new GmailMainContentBO(driver);
        headerPanelBO = new GmailHeaderPanelBO(driver);
        loginBO = new LoginBO(driver);
    }

    @BeforeTest
    public void setUp() {
        try {
            driver.get(GmailLoginPage.LOGIN_URL);
            loginBO.login(USER_LOGIN, USER_PASSWORD);
        } catch (Exception e) {
            log.error("GmailPageTestWithBO - setUp() fail - ", e);
            Assert.fail("GmailPageTestWithBO - setUp() fail", e.getCause());
        }
    }

    @Test(groups = "GMAIL_PAGE")
    public void testIfDraftFolderContainsSavedAndClosedDraft() {
        try {
            /*(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.xpath("/*//*[@id=':4e']/div/div")).isEnabled();
                }
            });*/
            mainContentBO.pressComposeBtn();
            mainContentBO.typeTextToNewMsg(TestUtils.TEST_MESSAGE_FOR_GMAIL_PAGE_TEST);
            mainContentBO.clickSaveAndClose();
            leftPanelBO.clickDraftLink();
            leftPanelBO.clickDraftLink();
            List<WebElement> allMessages = mainContentBO.takeAllLettersFromPage();
            Assert.assertTrue(letterContainsTextMessage(allMessages, TestUtils.TEST_MESSAGE_FOR_GMAIL_PAGE_TEST),
                    "any letter doesn't contain test message");
        } catch (Exception e) {
            log.error("GmailPageTestWithBO - testIfDraftFolderContainsSavedAndClosedDraft() fail", e);
            Assert.fail("GmailPageTestWithBO - testIfDraftFolderContainsSavedAndClosedDraft() fail", e);
        }
    }

    @AfterTest
    public void tearDown() {
        try {
            headerPanelBO.clickProfileOptionMenu();
            headerPanelBO.clickSignOutBtn();
            /*(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("gmail");
                }
            });*/
        } catch (Exception e) {
            log.error("GmailPageTestWithBO - tearDown() fail - ", e);
            Assert.fail("GmailPageTestWithBO - tearDown() fail", e.getCause());
        } finally {
            WebDriverManager.stop();
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
