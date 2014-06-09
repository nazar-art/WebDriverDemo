package mobile.business;

import mobile.pages.GmailAndroidPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GmailAndroidBO {

    private GmailAndroidPage androidPage;

    public GmailAndroidBO() {
        androidPage = new GmailAndroidPage();
    }

    public void clickComposeBtn() {
        androidPage.clickComposeBtn();
    }

    public List<WebElement> checkSavingDraftLetter(String msg) {
        androidPage.clickComposeBtn();
        androidPage.typeTextToMsg(msg);
        androidPage.clickSaveAndCloseBtn();
        androidPage.clickDraftLink();
        // return all messages per page from draft folders
        return androidPage.takeAllMsgFromPage();
    }
}

