package task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GmailLoginPage;
import pages.GmailPage;
import utilities.TestUtils;
import utilities.drivers.DriverManager;

import java.util.List;

public class GmailPageTestWithPageObject {
    private WebDriver driver = DriverManager.getInstance();
    private GmailPage page = null;

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    @BeforeTest
    public void setUp() {
        driver.get(GmailLoginPage.LOGIN_URL);
        GmailLoginPage loginPage = new GmailLoginPage();
        page = loginPage.loginAs(USER_LOGIN, USER_PASSWORD);
    }

    @Test(groups = "GMAIL_PAGE")
    public void testIfDraftFolderContainsSavedAndClosedDraft() {
        page.pressComposeButton();
        page.sendTextToMessageFrame(TestUtils.TEST_MESSAGE_FOR_GMAIL_PAGE_TEST);
        page.clickDraftLink();
        List<WebElement> allMessages = page.takeAllMessages();
        Assert.assertTrue(letterContainsTextMessage(allMessages, TestUtils.TEST_MESSAGE_FOR_GMAIL_PAGE_TEST),
                "any letter doesn't contain test message");
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
