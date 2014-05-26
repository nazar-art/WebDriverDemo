package task2.business;

import org.openqa.selenium.WebElement;
import pages.GmailPage;

import java.util.List;

public class GmailMainContentBO {

    private GmailPage gmailPage;

    public GmailMainContentBO() {
        gmailPage = new GmailPage();
    }

    public void pressComposeBtn() {
        gmailPage.clickComposeBtn();
    }

    public void typeTextToNewLetter(String msg) {
        gmailPage.typeTextToMessage(msg);
    }

    public void clickSaveAndClose() {
        gmailPage.clickSaveAndCloseBtn();
    }

    public List<WebElement> takeAllLettersFromPage() {
        return gmailPage.takeAllMessages();
    }
}
