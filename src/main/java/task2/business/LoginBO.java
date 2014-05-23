package task2.business;

import org.openqa.selenium.WebDriver;
import pages.GmailLoginPage;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-23.
 */
public class LoginBO {

    private GmailLoginPage loginPage;

    public LoginBO(WebDriver driver) {
        loginPage = new GmailLoginPage(driver);
    }

    public void login(String userLogin, String usepPass) {
        loginPage.setLogin(userLogin);
        loginPage.setPassword(userLogin);
        loginPage.clickLoginBtn();
    }
}
