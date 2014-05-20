package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-20.
 */

/*
  7. Verify that "All mail" folder contains messages from "inbox" and "draft" folders
*/
public class GmailPageTest {

    private static Logger log = Logger.getLogger(GmailPageTest.class);
    private WebDriver driver = new FirefoxDriver();
    private GmailPage page = null;

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    @BeforeTest
    public void setUp() {
        try {
            driver.get(GmailLoginPage.LOGIN_URL);
            GmailLoginPage loginPage = new GmailLoginPage(driver);
            page = loginPage.loginAs(USER_LOGIN, USER_PASSWORD);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test(groups = "GMAIL_PAGE")
    public void testAllMailLink() {
        try {
            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.xpath(".//*[@id=':4e']/div/div")).isEnabled();
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

            Assert.assertTrue(allMessages.containsAll(inboxMessages) && allMessages.containsAll(draftMessages),
                    "All messages doesn't contains all inbox or draft messages");
        } catch (Exception e) {
            log.error(e);
        }
    }

    @AfterTest
    public void tearDown() {
        try {
            page.clickProfileImage();
            page.clickSignOut();

            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("gmail");
                }
            });

            driver.close();
            driver.quit();
        } catch (Exception e) {
            log.error(e);
        }
    }
}
