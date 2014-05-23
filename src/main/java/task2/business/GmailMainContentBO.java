package task2.business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.GmailPage;

import java.util.List;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-23.
 */
public class GmailMainContentBO {

    private GmailPage gmailPage;

    public GmailMainContentBO(WebDriver driver) {
        gmailPage = new GmailPage(driver);
    }

    public void pressComposeBtn() {
        gmailPage.clickComposeBtn();
    }

    public void typeTextToNewMsg(String msg) {
        gmailPage.typeTextToMessage(msg);
    }

    public void clickSaveAndClose() {
        gmailPage.clickSaveAndCloseBtn();
    }

    public List<WebElement> takeAllLettersFromPage() {
        return gmailPage.takeAllMessages();
    }
}
