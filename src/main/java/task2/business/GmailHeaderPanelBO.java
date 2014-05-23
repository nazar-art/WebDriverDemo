package task2.business;

import org.openqa.selenium.WebDriver;
import pages.GmailPage;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-23.
 */
public class GmailHeaderPanelBO {

    private GmailPage gmailPage;

    public GmailHeaderPanelBO(WebDriver driver) {
        gmailPage = new GmailPage(driver);
    }

    public void clickProfileOptionMenu() {
        gmailPage.clickProfileOptionMenu();
    }

    public void clickSignOutBtn() {
        gmailPage.clickSignOut();
    }
}
