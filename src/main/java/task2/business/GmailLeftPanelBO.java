package task2.business;

import org.openqa.selenium.WebDriver;
import pages.GmailPage;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-23.
 */
public class GmailLeftPanelBO {

    private GmailPage gmailPage;

    public GmailLeftPanelBO(WebDriver driver) {
        gmailPage = new GmailPage(driver);
    }

    public void clickDraftLink() {
        gmailPage.clickDraftLink();
    }


}
