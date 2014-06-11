package mobile.business;

import mobile.pages.GmailAndroidPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GmailAndroidBO {

    public void clickComposeBtn() {
        GmailAndroidPage androidPage = new GmailAndroidPage();
        androidPage.clickComposeBtn();
    }

    public List<WebElement> checkSavingDraftLetter(String msg) {
        GmailAndroidPage androidPage = new GmailAndroidPage();
        androidPage.clickComposeBtn();
        androidPage.typeTextToMsg(msg);
        androidPage.clickCloseMessageBtn();
        androidPage.clickDraftLink();
        // return all messages per page from draft folder
        return androidPage.takeAllMsgFromPage();
    }

    public void logOut() {
        GmailAndroidPage androidPage = new GmailAndroidPage();
        androidPage.logOutUser();
    }
}

