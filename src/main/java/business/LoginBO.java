package business;

import pages.GmailLoginPage;

public class LoginBO {

    private GmailLoginPage loginPage;

    public LoginBO() {
        loginPage = new GmailLoginPage();
    }

    public void login(String userLogin, String userPass) {
        loginPage.setLogin(userLogin);
        loginPage.setPassword(userPass);
        loginPage.clickLoginBtn();

    }

    public void setLogin(String loginName) {
        loginPage.setLogin(loginName);
    }

    public void setPassword(String password) {
        loginPage.setPassword(password);
    }

    public void clickLoginBtn() {
        loginPage.clickLoginBtn();
    }
}
