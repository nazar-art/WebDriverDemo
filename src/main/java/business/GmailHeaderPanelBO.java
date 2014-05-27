package business;

import pages.GmailPage;

public class GmailHeaderPanelBO {

    private GmailPage gmailPage;

    public GmailHeaderPanelBO() {
        gmailPage = new GmailPage();
    }

    public void clickProfileOptionMenu() {
        gmailPage.clickProfileOptionMenu();
    }

    public void clickSignOutBtn() {
        gmailPage.clickSignOut();
    }
}
