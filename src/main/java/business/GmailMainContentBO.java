package business;

import org.openqa.selenium.WebElement;
import pages.GmailPage;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static pages.utils.TestUtils.interrupt;

public class GmailMainContentBO {

    private GmailPage gmailPage;

    public GmailMainContentBO() {
        gmailPage = new GmailPage();
    }

    public void clickComposeBtn() {
        gmailPage.clickComposeBtn();
    }

    public void typeTextToNewLetter(String msg) {
        gmailPage.typeTextToMessage(msg);
    }

    public void clickSaveAndCloseBtn() {
        gmailPage.clickSaveAndCloseBtn();
    }

    public List<WebElement> takeAllLettersFromPage() {
        return gmailPage.takeAllMessages();
    }

    public void saveAndCloseDraftMessage(String msg) {
        clickComposeBtn();
        interrupt(SECONDS, 1);
        typeTextToNewLetter(msg);
        interrupt(SECONDS, 1);
        clickSaveAndCloseBtn();
        interrupt(SECONDS, 1);
    }

    public void writeNewMessage(String msg) {
        typeTextToNewLetter(msg);
    }
}
