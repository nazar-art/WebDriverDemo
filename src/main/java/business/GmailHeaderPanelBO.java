package business;

import pages.GmailPage;

public class GmailHeaderPanelBO {

    public void clickProfileOptionMenu() {
        GmailPage gmailPage = new GmailPage();
        gmailPage.clickProfileOptionMenu();
    }

    public void clickSignOutBtn() {
        GmailPage gmailPage = new GmailPage();
        gmailPage.clickSignOut();
    }
}
