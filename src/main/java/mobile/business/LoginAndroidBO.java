package mobile.business;

import mobile.pages.LoginAndroidPage;

public class LoginAndroidBO {

    private LoginAndroidPage loginAndroidPage;

    public LoginAndroidBO() {
        loginAndroidPage = new LoginAndroidPage();
    }

    public void login(String login, String pass) {
        loginAndroidPage.loginAs(login, pass);
    }
}
