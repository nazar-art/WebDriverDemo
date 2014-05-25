package task2.business;

import pages.GmailPage;

public class GmailLeftPanelBO {

    private GmailPage gmailPage;

    public GmailLeftPanelBO() {
        gmailPage = new GmailPage();
    }

    public void clickDraftLink() {
        gmailPage.clickDraftLink();
    }


}
