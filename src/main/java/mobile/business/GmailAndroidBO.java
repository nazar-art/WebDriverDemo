package mobile.business;

import mobile.pages.GmailAndroidPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GmailAndroidBO {

    public void clickComposeBtn() {
        GmailAndroidPage androidPage = new GmailAndroidPage();
        androidPage.clickComposeBtn();
    }

    public boolean checkSavingDraftLetter(String msg) {
        GmailAndroidPage androidPage = new GmailAndroidPage();
        androidPage.clickComposeBtn();
        androidPage.typeTextToMsg(msg);
        androidPage.clickCloseMessageBtn();
        androidPage.clickDraftLink();

        List<WebElement> draftLetters = androidPage.takeAllMsgFromPage();
        return letterContainsTextMessage(draftLetters, msg);
    }

    public void logOut() {
        GmailAndroidPage androidPage = new GmailAndroidPage();
        androidPage.logOutUser();
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

