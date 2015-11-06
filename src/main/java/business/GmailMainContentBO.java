package business;

import org.openqa.selenium.WebElement;
import pages.GmailPage;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static utilities.TestUtils.interrupt;

public class GmailMainContentBO {

    public void clickComposeBtn() {
        GmailPage gmailPage = new GmailPage();
        gmailPage.clickComposeBtn();
    }

    public void typeTextToNewLetter(String msg) {
        GmailPage gmailPage = new GmailPage();
        gmailPage.typeTextToMessage(msg);
    }

    public void clickSaveAndCloseBtn() {
        GmailPage gmailPage = new GmailPage();
        gmailPage.clickSaveAndCloseBtn();
    }

    public List<WebElement> takeAllLettersFromPage() {
        GmailPage gmailPage = new GmailPage();
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
