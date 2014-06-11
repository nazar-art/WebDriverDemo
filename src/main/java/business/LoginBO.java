package business;

import pages.GmailLoginPage;

public class LoginBO {

    public void login(String userLogin, String userPass) {
        GmailLoginPage loginPage = new GmailLoginPage();
        loginPage.setLogin(userLogin);
        loginPage.setPassword(userPass);
        loginPage.clickLoginBtn();

    }

    public void setLogin(String loginName) {
        GmailLoginPage loginPage = new GmailLoginPage();
        loginPage.setLogin(loginName);
    }

    public void setPassword(String password) {
        GmailLoginPage loginPage = new GmailLoginPage();
        loginPage.setPassword(password);
    }

    public void clickLoginBtn() {
        GmailLoginPage loginPage = new GmailLoginPage();
        loginPage.clickLoginBtn();
    }
}
