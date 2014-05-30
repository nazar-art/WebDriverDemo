package framework.pages;

import framework.UIElements.BaseUIPage;
import framework.UIElements.UIButton;
import framework.UIElements.UIControlBuilder;
import framework.UIElements.UIForm;
import framework.seleniumEngine.UIRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author nlelyak.
 * @version 1.00 2014-05-23.
 */
public class GmailLoginPage extends BaseUIPage {
    private UIForm loginPanel;
    private UIButton btnLogin;

    public UIForm getLoginPanel() {
        loginPanel = (UIForm) UIControlBuilder.buildControl(UIRepository.Pages.GmailLoginPage.loginPanel);
        return loginPanel;
    }

    public UIButton getBtnLogin() {
        btnLogin = new UIButton();
        WebElement seleniumElem = getLoginPanel().controlWrapper.findElement(By.id("signIn"));
        btnLogin.assign(seleniumElem);

        return btnLogin;
    }
}
