package mobile.business;

import mobile.pages.LoginAndroidPage;

public class LoginAndroidBO {

    public void login(String login, String pass) {
        LoginAndroidPage loginAndroidPage = new LoginAndroidPage();
        loginAndroidPage.loginAs(login, pass);
    }
}
