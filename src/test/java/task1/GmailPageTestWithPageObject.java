package task1;

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
import pages.GmailPage;
import pages.TestUtils;
import task2.WebDriverManager;

import java.util.List;

import static framework.seleniumEngine.BrowserType.Firefox;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-20.
 */
public class GmailPageTestWithPageObject {

    private static Logger log = Logger.getLogger(GmailPageTestWithPageObject.class);

    private WebDriver driver = WebDriverManager.getInstance(Firefox); // todo move to properties file
    private GmailPage page = null;

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    @BeforeTest
    public void setUp() {
//        try {
            driver.get(GmailLoginPage.LOGIN_URL);
            GmailLoginPage loginPage = new GmailLoginPage(driver);
            page = loginPage.loginAs(USER_LOGIN, USER_PASSWORD);
        /*} catch (Exception e) {
            log.error("GmailPageClassTest - setUp() fail", e);
            Assert.fail("GmailPageClassTest - setUp() fail", e.getCause());
        }*/
    }

    @Test(groups = "GMAIL_PAGE")
    public void testIfDraftFolderContainsSavedAndClosedDraft() {
//        try {
            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.xpath("//*[@id=':4e']/div/div")).isEnabled();
                }
            });
            page.pressComposeButton();
            page.sendTextToMessageFrame(TestUtils.TEST_MESSAGE_FOR_GMAIL_PAGE_TEST);
            page.clickDraftLink();
            List<WebElement> allMessages = page.takeAllMessages();
            Assert.assertTrue(letterContainsTextMessage(allMessages, TestUtils.TEST_MESSAGE_FOR_GMAIL_PAGE_TEST),
                    "any letter doesn't contain test message");
        /*} catch (Exception e) {
            log.error("GmailPageClassTest - testIfDraftFolderContainsSavedAndClosedDraft() fail", e);
            Assert.fail("GmailPageClassTest - testIfDraftFolderContainsSavedAndClosedDraft() fail", e);
        }*/
    }

    @AfterTest
    public void tearDown() {
        try {
            page.clickProfileOptionMenu();
            page.clickSignOut();

            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("gmail");
                }
            });
        } catch (Exception e) {
            log.error("GmailPageClassTest - tearDown() fail", e);
            Assert.fail("GmailPageClassTest - tearDown() fail", e.getCause());
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
