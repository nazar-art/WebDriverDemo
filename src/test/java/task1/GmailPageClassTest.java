package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import pages.GmailLoginPageClass;
import pages.GmailPageClass;

import java.util.List;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-20.
 */

public class GmailPageClassTest {

    private static Logger log = Logger.getLogger(GmailPageClassTest.class);
    private WebDriver driver = new FirefoxDriver();
    private GmailPageClass page = null;

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    @BeforeTest
    public void setUp() {
//        try {
            driver.get(GmailLoginPageClass.LOGIN_URL);
            GmailLoginPageClass loginPage = new GmailLoginPageClass(driver);
            page = loginPage.loginAs(USER_LOGIN, USER_PASSWORD);
        /*} catch (Exception e) {
            log.error(e);
        }*/
    }

    @Test(groups = "GMAIL_PAGE")
    public void testAllMailLink() {
//        try {
            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.xpath("//*[@id=':4e']/div/div")).isEnabled();
                }
            });
            page.pressComposeButton();
            page.sendTextToMessageFrame("This is the test message");
            page.clickAllMailLink();

            List<WebElement> allMessages = page.takeAllMessage();
            page.clickInboxLink();
            List<WebElement> inboxMessages = page.takeInboxMessage();
            page.clickDraftLink();
            List<WebElement> draftMessages = page.takeDraftMessage();

            Assert.assertTrue(allMessages.containsAll(inboxMessages),
                    "All messages doesn't contains all inbox messages");
            Assert.assertTrue(allMessages.containsAll(draftMessages),
                    "All messages doesn't contains all draft messages");
            log.info("test is passed");
        /*} catch (Exception e) {
            log.error(e);
        }*/
    }

    @AfterTest
    public void tearDown() {
//        try {
            page.clickProfileImage();
            page.clickSignOut();

            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("gmail");
                }
            });
        /*} catch (Exception e) {
            log.error(e);
        } finally {*/
            driver.close();
            driver.quit();
//        }
    }
}
